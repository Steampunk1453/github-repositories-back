package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;

import java.util.List;

public interface SearchService {

    List<RepositoryDto> findByLanguage(String language);
    List<RepositoryDto> findByFreeText(String text);
    List<RepositoryDto> findByTopic(String topic);
}
