package com.appointmentschedulingapp.staff.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String role;
}
