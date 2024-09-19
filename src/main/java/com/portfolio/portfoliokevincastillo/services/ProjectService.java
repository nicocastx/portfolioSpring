package com.portfolio.portfoliokevincastillo.services;

import com.portfolio.portfoliokevincastillo.entities.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    List<ProjectDto> findAll();
    void sendEmail(String sender, String subject, String body);
}
