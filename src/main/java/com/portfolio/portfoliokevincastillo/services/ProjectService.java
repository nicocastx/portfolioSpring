package com.portfolio.portfoliokevincastillo.services;

import com.portfolio.portfoliokevincastillo.entities.Project;
import com.portfolio.portfoliokevincastillo.entities.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAll();
}
