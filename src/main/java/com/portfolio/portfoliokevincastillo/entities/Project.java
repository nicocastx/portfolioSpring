package com.portfolio.portfoliokevincastillo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    private int id;
    private String name;
    private String description;
    private String urlProject;
    private String urlImage;

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", urlProject='" + urlProject + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
