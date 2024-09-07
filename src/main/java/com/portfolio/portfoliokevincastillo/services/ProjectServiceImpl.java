package com.portfolio.portfoliokevincastillo.services;

import com.portfolio.portfoliokevincastillo.entities.Project;
import com.portfolio.portfoliokevincastillo.entities.dto.ProjectDto;
import com.portfolio.portfoliokevincastillo.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> findAll() {
        List<Project> projects = projectRepository.findAll();

        return mapProjectToDto(projects);
    }

    private List<ProjectDto> mapProjectToDto(List<Project> projects) {
        List<ProjectDto> projectDtos = new ArrayList<>();
        projects.forEach(project -> {
            projectDtos.add(
                    ProjectDto.builder()
                            .name(project.getName())
                            .description(project.getDescription())
                            .urlImage(project.getUrlImage())
                            .urlProject(project.getUrlProject())
                            .build()
            );
        });
        return projectDtos;
    }
}
