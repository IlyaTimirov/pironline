package ru.api.pir.api.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Error {
    private String message;
}
