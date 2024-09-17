package com.portfolio.portfoliokevincastillo.controllers;


import com.portfolio.portfoliokevincastillo.entities.dto.ProjectDto;
import com.portfolio.portfoliokevincastillo.services.ProjectService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Duration;
import java.util.List;

@Controller
public class IndexController {
    private final ProjectService projectService;
    private final Bucket bucket;

    public IndexController(ProjectService projectService){
        this.projectService = projectService;
        Bandwidth limit = Bandwidth.classic(2, Refill.greedy(2, Duration.ofMinutes(2)));
        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();
    }

    @GetMapping("/")
    public String index(Model model) {
        List<ProjectDto> projects = projectService.findAll().subList(0, 4);
        projects.forEach(proj -> proj.setDescription(proj.getDescription().length() > 250 ? proj.getDescription().substring(0, 250) + "..." : proj.getDescription()));
        model.addAttribute("projects", projects);
        return "index";
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        List<ProjectDto> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContactEmail(HttpServletRequest request){
        if (bucket.tryConsume(1)) {
            projectService.sendEmail(
                    request.getParameter("sender"),
                    request.getParameter("subject"),
                    request.getParameter("body")
            );

            return "redirect:/contact?success";
        }
        return "redirect:/contact?retryIn2Minutes";
    }

}
