package com.github.repositories.controllers;

import com.github.repositories.dtos.RepositoryDto;
import com.github.repositories.services.SearchRepositoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("repositories")
public class SearchController {
    private final SearchRepositoriesService searchRepositoriesService;

    public SearchController(SearchRepositoriesService searchRepositoriesService) {
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

    @GetMapping(path = "/topic/{topic}")
    public RepositoryDto getByTopic(@PathVariable("topic") String topic){
        return searchRepositoriesService.findByTopic(topic);
    }
}
