package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DefaultSearchRepositoriesService implements SearchRepositoriesService {

    public static final String FILTER_QUERY_ELEMENT= "+language:";
    public static final String SORT_QUERY_ELEMENT= "&sort=";
    public static final String ORDER_TYPE_QUERY_ELEMENT= "&order=desc";
    public static final String MAX_ITEMS_PAGES = "&per_page=20";

    @Value("${search.url.language}")
    private String urlSearchLanguage;

    @Value("${search.url.text}")
    private String urlSearchText;

    @Value("${search.url.topic}")
    private String urlSearchTopic;

    @Value("${search.url.order}")
    private String urlSearchOrder;

    private final ApiRepositoriesService apiRepositoriesService;

    public DefaultSearchRepositoriesService(ApiRepositoriesService apiRepositoriesService) {
        this.apiRepositoriesService = apiRepositoriesService;
    }

    @Override
    public RepositoryDto findByLanguage(String language) {
        String url = urlSearchLanguage + language + MAX_ITEMS_PAGES;
        return apiRepositoriesService.findRepositories(url);
    }

    @Override
    public RepositoryDto findByFreeText(String text) {
        String url = urlSearchText + text + MAX_ITEMS_PAGES;
        return apiRepositoriesService.findRepositories(url);

    }

    @Override
    public RepositoryDto findByTextAndLanguage(String text, String language) {
        String url = urlSearchTopic + text + FILTER_QUERY_ELEMENT + language + MAX_ITEMS_PAGES;
        return apiRepositoriesService.findRepositories(url);

    }

    @Override
    public RepositoryDto findDataAndOrderByItem(String text, String language, String item) {
        String url = urlSearchOrder + text + FILTER_QUERY_ELEMENT + language + SORT_QUERY_ELEMENT + item + ORDER_TYPE_QUERY_ELEMENT + MAX_ITEMS_PAGES;
        return apiRepositoriesService.findRepositories(url);
    }
}
