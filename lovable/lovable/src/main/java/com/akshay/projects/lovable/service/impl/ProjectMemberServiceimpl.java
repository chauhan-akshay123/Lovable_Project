package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.member.InviteMemberRequest;
import com.akshay.projects.lovable.DTO.member.MemberResponse;
import com.akshay.projects.lovable.DTO.member.UpdateMemberRoleRequest;
import com.akshay.projects.lovable.entity.Project;
import com.akshay.projects.lovable.entity.ProjectMember;
import com.akshay.projects.lovable.entity.ProjectMemberId;
import com.akshay.projects.lovable.entity.User;
import com.akshay.projects.lovable.mapper.ProjectMemberMapper;
import com.akshay.projects.lovable.repository.ProjectMemberRepository;
import com.akshay.projects.lovable.repository.ProjectRepository;
import com.akshay.projects.lovable.repository.UserRepository;
import com.akshay.projects.lovable.security.AuthUtil;
import com.akshay.projects.lovable.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceimpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;
    AuthUtil authUtil;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId) {

        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);
        return projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request) {

        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if (projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember member = new ProjectMember().builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request) {

        Long userId = authUtil.getCurrentUserId();

        Project project = getAccessibleProjectById(projectId, userId);
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void deleteProjectMember(Long projectId, Long memberId) {

      Long userId = authUtil.getCurrentUserId();
      Project project = getAccessibleProjectById(projectId, userId);
      ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
      if(!projectMemberRepository.existsById(projectMemberId)){
          throw new RuntimeException("Member not found in project");
      }

      projectMemberRepository.deleteById(projectMemberId);
    }

    /* Utility Functions */

    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id, userId).orElseThrow();
    }
}


