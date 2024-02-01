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
import com.oxygen.model.Patient;
import com.oxygen.response.PatientResponse;
import com.oxygen.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	PatientService patientService;

	@GetMapping(value = "/patientdetails")
	public ResponseEntity<PatientResponse> getPatientDetails() {

		return patientService.getPatientDetails();

	}

	@PostMapping(value = "/patientsavedata")
	public ResponseEntity<PatientResponse> createPatientDetails(@RequestBody Patient patient) {

		return patientService.createPatientDetails(patient);
	}

	@PutMapping(value = "/patientupdatedetails")
	public ResponseEntity<PatientResponse> updatePatientDetails(@RequestBody Patient patient) {
		return patientService.updatePatientDetails(patient);
	}

	@DeleteMapping(value = "/patientdeletedetails/{patientId}")
	public ResponseEntity<PatientResponse> deletePatientDetails(@PathVariable("patientId") int patientId) {
		return patientService.deletePatientDetails(patientId);
	}

}
