package com.oxygen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oxygen.model.AuditTrial;
import com.oxygen.model.Doctor;
import com.oxygen.response.AuditTrialResponse;
import com.oxygen.response.DoctorResponse;
import com.oxygen.service.AuditTrialService;
import com.oxygen.service.DoctorService;

@RestController
public class DoctorController {
	@Autowired
	DoctorService doctorService;

	@Autowired
	AuditTrialService auditTrialService;
	
	@GetMapping(value = "/doctordetails")
	public ResponseEntity<DoctorResponse> getDoctorDetails() {

		return doctorService.getDoctorDetails();
	}

	@PostMapping(value = "/savedata")
	public ResponseEntity<DoctorResponse> createDoctorDetails(@RequestBody Doctor doctor) {

		return doctorService.createDoctorDetails(doctor);
	}

	@PutMapping(value = "/updatedetails")
	public ResponseEntity<DoctorResponse> updateDoctorDetails(@RequestBody Doctor doctor) {

		return doctorService.updateDoctorDetails(doctor);
	}

	@DeleteMapping(value = "/deletedetails/{doctorId}")
	public ResponseEntity<DoctorResponse> deleteDoctorDetails(@PathVariable("doctorId") int doctorId) {

		return doctorService.deleteDoctorDetails(doctorId);

	}
	
	
	@PostMapping(value="/saveauditdata")
	
	public ResponseEntity<AuditTrialResponse> creatAuditDetails(@RequestBody AuditTrial audit)
	{
		return auditTrialService.creatAuditDetails(audit);
	}
	

}
