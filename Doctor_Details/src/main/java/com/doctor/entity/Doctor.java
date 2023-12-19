package com.doctor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doc")
public class Doctor {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String doctorid;
   private String name;
   private String mobile;
   
   public String getDoctorid() {
	   return doctorid;
   }
   public void setDoctorid(String doctorid) {
	   this.doctorid = doctorid;
   }
   public String getName() {
	   return name;
   }
   public void setName(String name) {
	   this.name = name;
   }
   public String getMobile() {
	   return mobile;
   }
   public void setMobile(String mobile) {
	   this.mobile = mobile;
   }
   public Doctor(String doctorid, String name, String mobile) {
	   super();
	   this.doctorid = doctorid;
	   this.name = name;
	   this.mobile = mobile;
   }
   public Doctor() {
	   super();
   }
}
