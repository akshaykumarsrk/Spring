package com.example.Cricbuzz.Application.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message)
    {
        super(message);
    }
}
