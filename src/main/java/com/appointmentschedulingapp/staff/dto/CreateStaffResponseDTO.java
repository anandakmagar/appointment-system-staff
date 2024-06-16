package com.appointmentschedulingapp.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateStaffResponseDTO {
    private String statusCode;
    private String statusMsg;
    private long staffId;
}
