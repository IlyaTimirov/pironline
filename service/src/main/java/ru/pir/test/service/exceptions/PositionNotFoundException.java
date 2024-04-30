package ru.pir.test.service.exceptions;

public class PositionNotFoundException extends RuntimeException{
    public PositionNotFoundException() {
        super("Позиция не найдена!");
    }
}
