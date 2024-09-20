package com.portfolio.portfoliokevincastillo.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfoliokevincastillo.entities.Project;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.*;

@Repository
@Primary
public class ProjectRepositoryJson implements ProjectRepository {
    private final Logger log = LoggerFactory.getLogger(ProjectRepositoryJson.class);

    private List<Project> projects;
    private final ObjectMapper objectMapper;
    @Value("#{jsonFilePathProjects}")
    private String jsonFilePath;

    public ProjectRepositoryJson() {
        objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void init() {
        File file = new File(System.getProperty("user.dir") + jsonFilePath);
        try {
            log.info("Reading json file: " + file.getAbsolutePath());
            projects = Arrays.asList(objectMapper.readValue(file, Project[].class));
            log.info("Project array made and reading is completed");
        } catch (Exception e){
            log.error("Exception while reading file: \n{}", e.getMessage());
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
