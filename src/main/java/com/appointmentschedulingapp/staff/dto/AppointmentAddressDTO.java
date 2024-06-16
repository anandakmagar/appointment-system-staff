package com.appointmentschedulingapp.staff.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentAddressDTO {
    private String facilityName;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
}
