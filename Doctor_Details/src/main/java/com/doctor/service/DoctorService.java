package com.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.entity.Doctor;
import com.doctor.exception.ResourceNotFoundException;
import com.doctor.repo.DoctorRepo;
@Service
public class DoctorService {
	@Autowired
    private DoctorRepo doctorrepo;

   public Doctor create(Doctor doctor) {
	   Doctor saveD = doctorrepo.save(doctor);
	   return saveD;
   }
   public  Doctor update(String doctorId, Doctor  doctor) {
		 Doctor docId = doctorrepo.findById(doctorId).orElseThrow(() ->new ResourceNotFoundException("Not Found"));
		 docId.setName(doctor.getName());
		 Doctor updateDoc = doctorrepo.save(docId);
		 return updateDoc;
	 }
	 public List<Doctor> getAll() { 
		 List<Doctor> getall = doctorrepo.findAll();
		 return getall;
	 }
	 public Doctor getDataById(String doctorId) {
		
		Doctor dataById = doctorrepo.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		return dataById;
	 }
	 
	 public void deleteBYId( String doctorId) {
		 doctorrepo.deleteById(doctorId);
		 
	 }
	}

