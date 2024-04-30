package ru.pir.test.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class PositionDto {
    private Long positionId;

    private Date dateAppointment;

    private Date dateDismissal;
}
