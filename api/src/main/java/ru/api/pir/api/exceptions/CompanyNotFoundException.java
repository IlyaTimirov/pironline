package ru.api.pir.api.exceptions;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException() {
        super("Компании с таким именем не найдено!");
    }
}
