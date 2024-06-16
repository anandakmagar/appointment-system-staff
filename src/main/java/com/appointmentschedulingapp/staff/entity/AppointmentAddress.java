package com.appointmentschedulingapp.staff.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AppointmentAddress {
    private Long addressId;
    private String facilityName;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
}
