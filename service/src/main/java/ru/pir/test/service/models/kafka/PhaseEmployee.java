package ru.pir.test.service.models.kafka;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Data
public class PhaseEmployee {
    @SerializedName("id")
    private Long employeeId;

    @SerializedName("position_id")
    private Long positionId;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("surname")
    private String surname;

    @SerializedName("date_appointment")
    private Long dateAppointment;

    @SerializedName("date_dismissal")
    private Long dateDismissal;
}
