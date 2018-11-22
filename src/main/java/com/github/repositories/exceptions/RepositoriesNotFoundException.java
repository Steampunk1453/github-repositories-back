package com.github.repositories.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Repositories not found")
public class RepositoriesNotFoundException extends RuntimeException {
}
