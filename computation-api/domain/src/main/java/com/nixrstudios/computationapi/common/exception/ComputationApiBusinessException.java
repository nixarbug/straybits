package com.nixrstudios.computationapi.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComputationApiBusinessException extends RuntimeException {

    private final String key;
    private final String[] args;

    public ComputationApiBusinessException(String key) {
        super(key);
        this.key = key;
        args = new String[0];
    }

    public ComputationApiBusinessException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }
}