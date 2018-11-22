package com.github.repositories.dtos;

import lombok.Data;

import java.time.Instant;

@Data
public class ItemsDto {
    private String name;
    private String description;
    private int stars;
    private int forks;
    private Instant updated;
    private String homepage;
    private String language;
}
