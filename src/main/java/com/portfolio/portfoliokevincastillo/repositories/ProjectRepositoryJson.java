package com.portfolio.portfoliokevincastillo.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfoliokevincastillo.entities.Project;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Primary
public class ProjectRepositoryJson implements ProjectRepository {

    private List<Project> projects;
    private final ObjectMapper objectMapper;
    @Value("#{jsonFilePathProjects}")
    private String jsonFilePath;

    public ProjectRepositoryJson() {
        objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void init() {
        ClassPathResource classPathResource = new ClassPathResource(jsonFilePath);

        try {
            projects = Arrays.asList(objectMapper.readValue(classPathResource.getFile(), Project[].class));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> findAll() {
        return projects;
    }

    @Override
    public Project findById(int id) {
        return null;
    }

    @Override
    public void save(Project project) {
        //!Not implemented
    }

    @Override
    public void delete(int id) {
        //!Not implemented
    }
}
