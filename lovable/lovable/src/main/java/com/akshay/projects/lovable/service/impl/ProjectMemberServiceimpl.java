package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.member.InviteMemberRequest;
import com.akshay.projects.lovable.DTO.member.MemberResponse;
import com.akshay.projects.lovable.DTO.member.UpdateMemberRoleRequest;
import com.akshay.projects.lovable.repository.ProjectMemberRepository;
import com.akshay.projects.lovable.service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectMemberServiceimpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId){
        return null;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId){
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId){
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId){
        return null;
    }
}
