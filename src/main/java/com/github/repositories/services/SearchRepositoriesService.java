package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;

public interface SearchRepositoriesService {

    RepositoryDto findByLanguage(String language);
    RepositoryDto findByFreeText(String text);
    RepositoryDto findByTextAndLanguage(String text, String language);
    RepositoryDto findDataAndOrderByItem(String text, String language, String item);
}
