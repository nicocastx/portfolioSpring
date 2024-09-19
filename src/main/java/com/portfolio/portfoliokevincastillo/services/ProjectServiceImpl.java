package com.portfolio.portfoliokevincastillo.services;

import com.portfolio.portfoliokevincastillo.entities.EmailMessage;
import com.portfolio.portfoliokevincastillo.entities.Project;
import com.portfolio.portfoliokevincastillo.entities.dto.ProjectDto;
import com.portfolio.portfoliokevincastillo.entities.exception.EmailException;
import com.portfolio.portfoliokevincastillo.repositories.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;
    private final EmailService emailService;

    public ProjectServiceImpl(ProjectRepository projectRepository, EmailService emailService) {
        this.projectRepository = projectRepository;
        this.emailService = emailService;
        log.debug("Se inicializo el servicio");
    }

    @Override
    public List<ProjectDto> findAll() {
        List<Project> projects = projectRepository.findAll();
        log.info("Se cargaron todos los proyectos desde base");
        log.debug("Los proyectos son: {}", projects);
        return mapProjectToDto(projects);
    }

    public void sendEmail(String sender, String subject, String body){
        String cuerpo = assembleEmail(sender, body);

        EmailMessage emailMessage = EmailMessage.builder()
                .subject(subject)
                .body(cuerpo)
                .build();
        try {
            emailService.emailSent(emailMessage);
            log.info("Se envio correctamente el correo de {}", sender);
        } catch (Exception e) {
            log.error("[ERROR] Revisar envio de correo");
            throw new EmailException(e.getMessage());
        }

    }

    private String assembleEmail(String sender, String body) {
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
        log.debug("mapeado de DTO completado");
        return projectDtos;
    }


}
