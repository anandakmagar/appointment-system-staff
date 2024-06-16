package com.appointmentschedulingapp.staff.repository;

import com.appointmentschedulingapp.staff.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
        Optional<Staff> findByStaffId(long staffId);
        @Transactional
        void deleteByStaffId(long staffId);
        Optional<Staff> findByEmail(String email);
        Optional<Staff> findByPhoneNumber(String phoneNumber);

        // The below methods has no implementation
        @Query("SELECT s FROM Staff s WHERE s.staffAddress.city = :city")
        List<Staff> findByCity(@Param("city") String city);

        @Query("SELECT s FROM Staff s WHERE s.staffAddress.postalCode = :postalCode")
        List<Staff> findByPostalCode(@Param("postalCode") String postalCode);

        @Query("SELECT s FROM Staff s WHERE s.createdAt = :createdAt")
        List<Staff> findByCreatedAt(@Param("createdAt") String createdAt);

}
