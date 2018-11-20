package com.github.repositories.services;

import com.github.repositories.dtos.RepositoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DefaultSearchRepositoriesService implements SearchRepositoriesService {

    public static final String MAX_ITEMS_PAGES = "&per_page=10";
    public static final String PAGE = "&page=1";

    @Value("${search.url.language}")
    private String urlSearchLanguage;

    @Value("${search.url.text}")
    private String urlSearchText;

    @Value("${search.url.topic}")
    private String urlSearchTopic;

    @Value("${search.url.order}")
    private String urlSearchOrder;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public RepositoryDto findByLanguage(String language) {
        return restTemplate.getForObject(urlSearchLanguage + language + MAX_ITEMS_PAGES, RepositoryDto.class);
    }

    @Override
    public RepositoryDto findByFreeText(String text) {
        return restTemplate.getForObject(urlSearchText + text + MAX_ITEMS_PAGES, RepositoryDto.class);
    }

    @Override
    public RepositoryDto findByTopic(String topic) {
        return restTemplate.getForObject(urlSearchTopic + topic + MAX_ITEMS_PAGES, RepositoryDto.class);
    }
}
