package com.github.repositories.controllers;

import com.github.repositories.dtos.RepositoryDto;
import com.github.repositories.services.SearchRepositoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repositories")
public class SearchRepositoriesController {
    private final SearchRepositoriesService searchRepositoriesService;

    public SearchRepositoriesController(SearchRepositoriesService searchRepositoriesService) {
        this.searchRepositoriesService = searchRepositoriesService;
    }

    @GetMapping(path = "/language/{language}")
    public RepositoryDto getByLanguage(@PathVariable("language") String language){
        return searchRepositoriesService.findByLanguage(language);
    }

    @GetMapping(path = "/text/{text}")
    public RepositoryDto getByFreeText(@PathVariable("text") String text){
        return searchRepositoriesService.findByFreeText(text);
    }

    @GetMapping(path = "/topic/{text}/{language}")
    public RepositoryDto getByTextAndField(@PathVariable("text") String text, @PathVariable("language") String language){
        return searchRepositoriesService.findByTextAndLanguage(text, language);
    }

    @GetMapping(path = "/sort/{text}/{language}/{orderBy}")
    public RepositoryDto getSortData(@PathVariable("text") String text, @PathVariable("language") String language,
                                     @PathVariable("orderBy") String orderBy){
        return searchRepositoriesService.findDataAndOrderByItem(text, language, orderBy);
    }
}
