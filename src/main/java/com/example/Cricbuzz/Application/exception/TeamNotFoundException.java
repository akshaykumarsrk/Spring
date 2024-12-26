package com.example.Cricbuzz.Application.exception;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(String message)
    {
        super(message);
    }
}
