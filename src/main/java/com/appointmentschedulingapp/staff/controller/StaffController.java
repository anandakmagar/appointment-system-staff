package com.appointmentschedulingapp.staff.controller;
import com.appointmentschedulingapp.staff.dto.CreateStaffResponseDTO;
import com.appointmentschedulingapp.staff.dto.ResponseDTO;
import com.appointmentschedulingapp.staff.dto.StaffDTO;
import com.appointmentschedulingapp.staff.service.IStaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private IStaffService iStaffService;

    @PostMapping("/create")
    public ResponseEntity<CreateStaffResponseDTO> createStaff(@Valid @RequestBody StaffDTO staffDTO){
        long staffId = iStaffService.createStaff(staffDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CreateStaffResponseDTO("201", "Staff created successfully and your staff Id is given below", staffId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteByStaffId(@RequestParam long staffId){
        boolean isDeleted = iStaffService.deleteByStaffId(staffId);
        if (isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO("200", "Staff deleted successfully"));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO("500", "An error occurred! Please try again later."));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> update(@RequestBody StaffDTO staffDTO){
        boolean isUpdated = iStaffService.updateStaff(staffDTO);
        if (isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO("200", "Staff updated successfully"));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO("500", "An error occurred! Please try again later."));
        }
    }

    @GetMapping("/fetch")
    public ResponseEntity<StaffDTO> fetchStaff(@RequestParam long staffId){
        StaffDTO staffDTO = iStaffService.fetchStaff(staffId);
        return ResponseEntity.status(HttpStatus.OK).body(staffDTO);
    }

    @GetMapping("/fetchStaffByStaffId")
    public StaffDTO fetchStaffByStaffId(@RequestParam long staffId){
        return iStaffService.fetchStaff(staffId);
    }

    @GetMapping("/fetchStaffByEmail")
    public StaffDTO fetchStaffByEmail(@RequestParam String email){
        return iStaffService.fetchStaffByEmail(email);
    }

    @GetMapping("/fetchStaffByPhoneNumber")
    public StaffDTO fetchStaffByPhoneNumber(@RequestParam String phoneNumber){
        return iStaffService.fetchStaffByPhoneNumber(phoneNumber);
    }

    @GetMapping("/fetchStaffNameByStaffId")
    public String fetchStaffNameByStaffId(@RequestParam long staffId){
        return iStaffService.fetchStaffNameByStaffId(staffId);
    }

    @GetMapping("/fetchAllStaff")
    public List<StaffDTO> fetchAllStaff(){
        return iStaffService.fetchAllStaff();
    }

}

