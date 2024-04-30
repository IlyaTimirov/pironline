package ru.pir.test.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class PositionHistoryDto {
    private Long employeeId;
    private List<PositionDto> positions;
}
