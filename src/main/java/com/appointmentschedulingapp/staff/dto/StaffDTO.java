package com.appointmentschedulingapp.staff.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
@Setter
public class StaffDTO {
    private Long staffId;
    private String name;
    private String email;
    private String phoneNumber;
    private StaffAddressDTO staffAddressDTO;
    private LocalDateTime createdAt;
    private  LocalDateTime updatedAt;

    @Override
    public String toString() {
        return String.format("Name: %s\nEmail: %s\nPhone: %s\nAddress:\n%s",
                name, email, phoneNumber, staffAddressDTO.toString());
    }
}
