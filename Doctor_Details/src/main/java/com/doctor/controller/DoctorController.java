package com.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.entity.Doctor;
import com.doctor.service.DoctorService;
import com.doctor.util.ApiResponse;

@RestController
@CrossOrigin
@RequestMapping
public class DoctorController {
   @Autowired  //used for loose coupling
   private DoctorService doctorService;
   @PostMapping("/save")
   public String create(@RequestBody Doctor doctor) {
	   doctorService.create(doctor);
	   return "Save Success";
   }
   @PutMapping("/update/{doctorId}")
   public String update(@PathVariable String doctorId, @RequestBody Doctor doctor) {
	   doctorService.update(doctorId, doctor);
	   return "Update Success";
   }
   @GetMapping("/alldata")
   public List<Doctor>getAll(){
	   List<Doctor> all = doctorService.getAll();
	   return all;
   }
   @GetMapping("data/(doctorId)")
   public Doctor getById(@PathVariable String doctorId) {
	   Doctor dataById = doctorService.getDataById(doctorId);
	   return dataById;
   }
   @DeleteMapping("delete/(doctor)")
   public ResponseEntity<ApiResponse>delete(@PathVariable String doctorId){
	   doctorService.deleteBYId(doctorId);
	   return new ResponseEntity<>(new ApiResponse("Deleted successfully"), HttpStatus.OK);
   }
}
