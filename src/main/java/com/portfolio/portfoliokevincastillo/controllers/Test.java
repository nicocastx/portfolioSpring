package com.portfolio.portfoliokevincastillo.controllers;

import com.portfolio.portfoliokevincastillo.entities.Project;
import com.portfolio.portfoliokevincastillo.entities.dto.ProjectDto;
import com.portfolio.portfoliokevincastillo.services.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {
    private final ProjectService projectService;

    public Test(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDto> findAll(){
        return projectService.findAll();
    }
}
