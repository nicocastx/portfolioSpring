package com.portfolio.portfoliokevincastillo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
public class ErrorController {
    @GetMapping
    public String error(HttpServletRequest request, HttpServletResponse response, Model model){
        int statusCode = response.getStatus();
        model.addAttribute("statusCode", statusCode);
        model.addAttribute("message", request.getAttribute("javax.servlet.error.message"));
        return "badRequest";
    }
}
