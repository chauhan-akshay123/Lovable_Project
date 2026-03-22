package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.project.ProjectRequest;
import com.akshay.projects.lovable.DTO.project.ProjectResponse;
import com.akshay.projects.lovable.DTO.project.ProjectSummaryResponse;
import com.akshay.projects.lovable.entity.Project;
import com.akshay.projects.lovable.entity.ProjectMember;
import com.akshay.projects.lovable.entity.ProjectMemberId;
import com.akshay.projects.lovable.entity.User;
import com.akshay.projects.lovable.enums.ProjectRole;
import com.akshay.projects.lovable.error.ResourceNotFoundException;
import com.akshay.projects.lovable.mapper.ProjectMapper;
import com.akshay.projects.lovable.repository.ProjectMemberRepository;
import com.akshay.projects.lovable.repository.ProjectRepository;
import com.akshay.projects.lovable.repository.UserRepository;
import com.akshay.projects.lovable.security.AuthUtil;
import com.akshay.projects.lovable.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceimpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        User owner = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", userId.toString())
        );

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    public ProjectResponse getProjectbyId(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id, userId);
        project.setName(request.name());
        projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id,userId);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    //  Utility Functions

    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
