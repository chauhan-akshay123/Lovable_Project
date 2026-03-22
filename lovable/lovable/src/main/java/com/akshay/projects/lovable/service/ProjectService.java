package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.project.ProjectRequest;
import com.akshay.projects.lovable.DTO.project.ProjectResponse;
import com.akshay.projects.lovable.DTO.project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects();

    ProjectResponse getProjectbyId(Long id);

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);
}
