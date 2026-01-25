package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.project.ProjectRequest;
import com.akshay.projects.lovable.DTO.project.ProjectResponse;
import com.akshay.projects.lovable.DTO.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getProjectbyId(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    Void softDelete(Long id, Long userId);
}
