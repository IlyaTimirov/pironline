package ru.api.pir.api.exceptions;

public class PositionNotFoundException extends RuntimeException{
    public PositionNotFoundException() {
        super("Должности с таким названием не найдено!");
    }
}
