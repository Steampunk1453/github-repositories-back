package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;
import com.github.repositories.exceptions.RepositoriesNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DefaultApiRepositoriesService implements ApiRepositoriesService {

    private final RestTemplate restTemplate;

    public DefaultApiRepositoriesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RepositoryDto findRepositories(String url) {
        log.info("request: " + url);
        RepositoryDto repositoryDto = null;
        try {
            repositoryDto = restTemplate.getForObject(url, RepositoryDto.class);
        } catch (Exception ex) {
            log.error("Connection error with developer GitHub API: " + ex.getMessage());
        }
        if (repositoryDto == null) {
            throw new RepositoriesNotFoundException();
        }
        return repositoryDto;
    }
}
