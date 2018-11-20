package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;

public interface SearchRepositoriesService {

    RepositoryDto findByLanguage(String language);
    RepositoryDto findByFreeText(String text);
    RepositoryDto findByTopic(String topic);

}
