package com.github.repositories.services;

import com.github.repositories.exceptions.RepositoriesNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
public class ApiRepositoriesServiceTest {

    @Value("${search.url.language}")
    private String urlSearchLanguage;

    @InjectMocks
    private DefaultApiRepositoriesService apiRepositoriesService;

    @Test(expected = RepositoriesNotFoundException.class)
    public void whenFindRepositoriesForRepositoriesNotFoundThrowException() {
        apiRepositoriesService.findRepositories(urlSearchLanguage);
        fail();
    }
}