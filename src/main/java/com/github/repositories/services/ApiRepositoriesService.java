package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;

public interface ApiRepositoriesService {

    RepositoryDto findRepositories(String url);
}
