package com.goadviser.repositories.exceptions;

public class AdviserNotFoudException extends RuntimeException {

    public AdviserNotFoudException(String adviser_not_found) {
        super(adviser_not_found);
    }
}
