package com.portfolio.portfoliokevincastillo.services;

import com.portfolio.portfoliokevincastillo.entities.EmailMessage;
import com.portfolio.portfoliokevincastillo.entities.Project;
import com.portfolio.portfoliokevincastillo.entities.dto.ProjectDto;
import com.portfolio.portfoliokevincastillo.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final EmailService emailService;

    public ProjectServiceImpl(ProjectRepository projectRepository, EmailService emailService) {
        this.projectRepository = projectRepository;
        this.emailService = emailService;
    }

    @Override
    public List<ProjectDto> findAll() {
        List<Project> projects = projectRepository.findAll();

        return mapProjectToDto(projects);
    }

    public boolean sendEmail(String sender, String subject, String body){
        String cuerpo = armarEmail(sender, body);

        EmailMessage emailMessage = EmailMessage.builder()
                .subject(subject)
                .body(cuerpo)
                .build();
        try {
            emailService.emailSent(emailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private String armarEmail(String sender, String body) {
        return String.format("""
                Mensaje de: %s
                Cuerpo: %s
                """, sender, body);
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
