package com.oxygen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.oxygen.model.Patient;
import com.oxygen.repository.PatientRepository;
import com.oxygen.response.GlobalErrorResponse;
import com.oxygen.response.PatientResponse;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	public ResponseEntity<PatientResponse> getPatientDetails() {

		PatientResponse patientResponse = new PatientResponse();
		List<Patient> data = patientRepository.findAll();
		patientResponse.setData(data);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);

		errorResponse.setDescription("List of patients data");

		return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.OK);

	}

	public ResponseEntity<PatientResponse> createPatientDetails(Patient patient) {

		PatientResponse patientResponse = new PatientResponse();
		Patient data = patientRepository.findById(patient.getPatientId());

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();

		if (data == null) {
			patientRepository.save(patient);
			errorResponse.setStatus(true);
			errorResponse.setDescription("patient data created successfully");
			patientResponse.setErrorResponse(errorResponse);
			return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.CREATED);
		}

		errorResponse.setStatus(false);
		errorResponse.setDescription("patient id's are already exist");
		patientResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.CONFLICT);

	}

	public ResponseEntity<PatientResponse> updatePatientDetails(Patient patient) {

		PatientResponse patientResponse = new PatientResponse();
		List<Patient> data = new ArrayList<Patient>();
		patientRepository.save(patient);
		data.add(patient);
		patientResponse.setData(data);
		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("patient details with id" + patient.getPatientId() + " is updated");
		patientResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.OK);

	}

	public ResponseEntity<PatientResponse> deletePatientDetails(int patientId) {

		PatientResponse patientResponse = new PatientResponse();
		patientRepository.deleteById(patientId);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("patient details with id" + patientId + "is deleted");
		patientResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.OK);
	}

}
