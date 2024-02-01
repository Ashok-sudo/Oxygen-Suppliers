package com.oxygen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oxygen.model.Doctor;

import com.oxygen.repository.DoctorRepository;
import com.oxygen.response.DoctorResponse;
import com.oxygen.response.GlobalErrorResponse;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	public ResponseEntity<DoctorResponse> getDoctorDetails() {

		DoctorResponse doctorResponse = new DoctorResponse();
		List<Doctor> data = doctorRepository.findAll();
		doctorResponse.setData(data);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("List of Doctors data");
		doctorResponse.setErrorResponse(errorResponse);

		return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.OK);

	}

	public ResponseEntity<DoctorResponse> createDoctorDetails(Doctor doctor) {

		DoctorResponse doctorResponse = new DoctorResponse();
		Doctor data = doctorRepository.findById(doctor.getDoctorId());

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();

		if (data == null) {
			doctorRepository.save(doctor);
			errorResponse.setStatus(true);
			errorResponse.setDescription("doctors data created successfully");
			doctorResponse.setErrorResponse(errorResponse);
			return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.CREATED);
		}

		errorResponse.setStatus(false);
		errorResponse.setDescription("doctor id's are already exist");
		doctorResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.CONFLICT);

	}

	public ResponseEntity<DoctorResponse> updateDoctorDetails(Doctor doctor) {

		DoctorResponse doctorResponse = new DoctorResponse();
		List<Doctor> data = new ArrayList<Doctor>();
		doctorRepository.save(doctor);
		data.add(doctor);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("doctor details with id" + doctor.getDoctorId() + " is updated");
		doctorResponse.setData(data);
		doctorResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.OK);

	}

	public ResponseEntity<DoctorResponse> deleteDoctorDetails(int doctorId) {

		DoctorResponse doctorResponse = new DoctorResponse();
		doctorRepository.deleteById(doctorId);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("doctor details with id" + doctorId + "is deleted");
		doctorResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<DoctorResponse>(doctorResponse, HttpStatus.OK);
	}

}
