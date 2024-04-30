package ru.pir.test.service.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String message;
}
