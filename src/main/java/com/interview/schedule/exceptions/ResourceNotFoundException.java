package com.interview.schedule.exceptions;

import lombok.Getter;

public class ResourceNotFoundException extends RuntimeException {
    @Getter
    private final Long id;

    public ResourceNotFoundException(Long id) {
        super();
        this.id = id;
    }
}
