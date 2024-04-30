package ru.api.pir.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    @NotEmpty(message = "Заполните имя!")
    private String firstName;
    @NotEmpty(message = "Заполните фамилию!")
    private String lastName;
    @NotEmpty(message = "Заполните отчество!")
    private String surname;
    @NotEmpty(message = "Заполните СНИЛС")
    private String snils;
    @NotNull(message = "Укажите дату рождения")
    private Date dateOfBirth;
    @NotEmpty(message = "Укажите пол!")
    private String sex;
    @NotEmpty(message = "Поле компания не заполнено!")
    private String companyName;
    @NotEmpty(message = "Укажите позицию")
    private String positionName;
    @NotNull(message = "Укажите дату устройства на позицию")
    private Date dateAppointment;

}
