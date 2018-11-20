package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;

import java.util.List;

public class DefaultSearchService implements SearchService {
    @Override
    public List<RepositoryDto> findByLanguage(String language) {
        return null;
    }

    @Override
    public List<RepositoryDto> findByFreeText(String text) {
        return null;
    }

    @Override
    public List<RepositoryDto> findByTopic(String topic) {
        return null;
    }
}
