package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.project.ProjectRequest;
import com.akshay.projects.lovable.DTO.project.ProjectResponse;
import com.akshay.projects.lovable.DTO.project.ProjectSummaryResponse;
import com.akshay.projects.lovable.service.ProjectService;

import java.util.List;

public class ProjectServiceimpl implements ProjectService {

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getProjectbyId(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public Void softDelete(Long id, Long userId) {
        return null;
    }
}
