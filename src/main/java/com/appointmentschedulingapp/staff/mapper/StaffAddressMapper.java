package com.appointmentschedulingapp.staff.mapper;

import com.appointmentschedulingapp.staff.dto.StaffAddressDTO;
import com.appointmentschedulingapp.staff.entity.StaffAddress;

public class StaffAddressMapper {
    public static StaffAddressDTO mapToAddressDTO(StaffAddress staffAddress) {
        StaffAddressDTO staffAddressDTO = new StaffAddressDTO();
        staffAddressDTO.setStreetAddress(staffAddress.getStreetAddress());
        staffAddressDTO.setCity(staffAddress.getCity());
        staffAddressDTO.setState(staffAddress.getState());
        staffAddressDTO.setPostalCode(staffAddress.getPostalCode());
        return staffAddressDTO;
    }

    public static StaffAddress mapToAddress(StaffAddressDTO staffAddressDTO) {
        StaffAddress staffAddress = new StaffAddress();
        staffAddress.setStreetAddress(staffAddressDTO.getStreetAddress());
        staffAddress.setCity(staffAddressDTO.getCity());
        staffAddress.setState(staffAddressDTO.getState());
        staffAddress.setPostalCode(staffAddressDTO.getPostalCode());
        return staffAddress;
    }
}
