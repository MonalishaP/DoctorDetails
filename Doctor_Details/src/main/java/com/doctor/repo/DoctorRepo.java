package com.doctor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doctor.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, String> {

}
