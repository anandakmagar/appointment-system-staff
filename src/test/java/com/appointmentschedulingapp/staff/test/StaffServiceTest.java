package com.appointmentschedulingapp.staff.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.appointmentschedulingapp.staff.entity.Staff;
import com.appointmentschedulingapp.staff.entity.StaffAddress;
import com.appointmentschedulingapp.staff.repository.StaffRepository;
import com.appointmentschedulingapp.staff.service.IStaffService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class StaffServiceTest {

    @Mock
    private StaffRepository staffRepository;

    @InjectMocks
    private IStaffService iStaffService;

    private static Stream<Object[]> staffIdProvider() {
        return Stream.of(
                new Object[]{1L, new Staff(1L, "John Doe", "johndoe@example.com", "123-456-7890", new StaffAddress("1234 Street", "City", "State", "PostalCode"), LocalDateTime.now(), null)},
                new Object[]{2L, null},
                new Object[]{3L, new Staff(3L, "Jane Doe", "janedoe@example.com", "987-654-3210", new StaffAddress("5678 Avenue", "Town", "Region", "Zip"), LocalDateTime.now(), LocalDateTime.now())}
        );
    }

    @ParameterizedTest
    @MethodSource("staffIdProvider")
    void testFindByStaffId(long staffId, Staff expectedStaff) {
        when(staffRepository.findByStaffId(staffId)).thenReturn(Optional.ofNullable(expectedStaff));

        Optional<Staff> result = iStaffService.findByStaffId(staffId);

        if (expectedStaff != null) {
            assertTrue(result.isPresent(), "Staff should be present for ID: " + staffId);
            assertNotNull(result.get(), "Resulting Staff object should not be null");
            assertStaffDetails(expectedStaff, result.get());
        } else {
            assertFalse(result.isPresent(), "Staff should not be present for ID: " + staffId);
            assertThrows(NoSuchElementException.class, result::get, "Accessing the Optional value should throw NoSuchElementException");
        }
    }

    private void assertStaffDetails(Staff expected, Staff actual) {
        assertEquals(expected.getStaffId(), actual.getStaffId(), "Staff IDs do not match");
        assertEquals(expected.getName(), actual.getName(), "Names do not match");
        assertEquals(expected.getEmail(), actual.getEmail(), "Emails do not match");
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber(), "Phone numbers do not match");
        assertNotNull(actual.getStaffAddress(), "Staff address should not be null");
        assertEquals(expected.getStaffAddress().getStreetAddress(), actual.getStaffAddress().getStreetAddress(), "Street addresses do not match");
        assertEquals(expected.getStaffAddress().getCity(), actual.getStaffAddress().getCity(), "Cities do not match");
        assertEquals(expected.getStaffAddress().getState(), actual.getStaffAddress().getState(), "States do not match");
        assertEquals(expected.getStaffAddress().getPostalCode(), actual.getStaffAddress().getPostalCode(), "Postal codes do not match");
        assertNotNull(actual.getCreatedAt(), "Creation date should not be null");
        assertEquals(expected.getCreatedAt(), actual.getCreatedAt(), "Creation dates do not match");
        assertEquals(expected.getUpdatedAt(), actual.getUpdatedAt(), "Update dates do not match");
    }
}
