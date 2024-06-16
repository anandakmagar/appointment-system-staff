package com.appointmentschedulingapp.staff.entity;

import com.appointmentschedulingapp.staff.enumeration.AppointmentStatus;
import com.appointmentschedulingapp.staff.enumeration.AppointmentType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Appointment {
    private Long id;
    @Column(updatable = false, nullable = false)
    private Long appointmentNumber;
    @Column(updatable = false, nullable = false)
    private Long clientId;
    @Column(nullable = false)
    private AppointmentType appointmentType;
    @Column(nullable = false)
    private Long assignedStaffId;
    @Column(nullable = false)
    private LocalDateTime appointmentDateTime;
    @Column(nullable = false)
    private AppointmentStatus appointmentStatus;
    @Embedded
    private AppointmentAddress appointmentAddress;
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    private  LocalDateTime updatedAt;

}