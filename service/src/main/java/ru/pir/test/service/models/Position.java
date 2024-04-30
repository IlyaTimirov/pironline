package ru.pir.test.service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "positions_services")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "date_appointment")
    private Long dateAppointment;

    @Column(name = "date_dismissal")
    private Long dateDismissal;
}
