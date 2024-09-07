package com.portfolio.portfoliokevincastillo.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {
    private String name;
    private String description;
    private String urlProject;
    private String urlImage;
}
