package com.portfolio.portfoliokevincastillo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailMessage {
    private String email;
    private String subject;
    private String body;
}
