package com.oxygen.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oxygen.model.ConsultOp;
import com.oxygen.model.Doctor;
import com.oxygen.model.O2Request;
import com.oxygen.model.Patient;
import com.oxygen.repository.ConsultOpRepository;
import com.oxygen.repository.DoctorRepository;
import com.oxygen.repository.O2RequestRepository;
import com.oxygen.repository.PatientRepository;
import com.oxygen.response.ConsultDoctorForOxygenRequestResponse;
import com.oxygen.response.GlobalErrorResponse;
import com.oxygen.response.O2RequestDetailsResponse;
import com.oxygen.response.O2RequestResponse;

@Service
public class O2RequestService {
	@Autowired
	O2RequestRepository o2RequestRepository;

	@Autowired
	ConsultOpRepository consultOpRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	public ResponseEntity<O2RequestResponse> getOxygenDetails() {

		O2RequestResponse requestResponse = new O2RequestResponse();
		List<O2Request> data = o2RequestRepository.findAll();
		requestResponse.setData(data);
		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("List O2 Request details");
		requestResponse.setErrorResponse(errorResponse);

		return new ResponseEntity<O2RequestResponse>(requestResponse, HttpStatus.OK);
	}

	public ResponseEntity<O2RequestResponse> createO2RequestData(O2Request request) {

		O2RequestResponse requestResponse = new O2RequestResponse();
		O2Request data = o2RequestRepository.findById(request.getO2requestId());

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();

		if (data == null) {
			o2RequestRepository.save(request);
			errorResponse.setStatus(true);
			errorResponse.setDescription("o2 request data created successfully");
			requestResponse.setErrorResponse(errorResponse);
			return new ResponseEntity<O2RequestResponse>(requestResponse, HttpStatus.CREATED);
		}
		errorResponse.setStatus(false);
		errorResponse.setDescription("consultant id's are already exist");
		requestResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<O2RequestResponse>(requestResponse, HttpStatus.CONFLICT);

	}

	public ResponseEntity<O2RequestResponse> updateOxygenDetails(O2Request request) {
		O2RequestResponse requestResponse = new O2RequestResponse();
		List<O2Request> data = new ArrayList<O2Request>();
		o2RequestRepository.save(request);
		data.add(request);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("oxygen request details with id" + request.getO2requestId() + " is updated");
		requestResponse.setData(data);
		requestResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<O2RequestResponse>(requestResponse, HttpStatus.OK);

	}

	public ResponseEntity<ConsultDoctorForOxygenRequestResponse> findByDoctorId(int doctorId) {

		List<O2Request> oxygenRequestdetails = o2RequestRepository.findByDoctorId(doctorId);
		ConsultDoctorForOxygenRequestResponse consultdoctorDetailsRequestResponse = new ConsultDoctorForOxygenRequestResponse();

		Doctor doctorDetails = doctorRepository.findByDoctorId(doctorId);
		consultdoctorDetailsRequestResponse.setDoctorDetails(doctorDetails);

		List<O2RequestDetailsResponse> o2RequestDetails = new ArrayList<>();

		for (O2Request ob : oxygenRequestdetails) {
			O2RequestDetailsResponse o2RequestDetailsResponse = new O2RequestDetailsResponse();

			ConsultOp consultOp = consultOpRepository.findById(ob.getConsultId());
			o2RequestDetailsResponse.setConsultId(ob.getConsultId());
			if (consultOp != null) {
				Patient patientDetails = patientRepository.findById(consultOp.getPatientId());
				if (patientDetails != null) {
					o2RequestDetailsResponse.setPatientDetails(patientDetails);
					o2RequestDetails.add(o2RequestDetailsResponse);
				}
			}

		}
		consultdoctorDetailsRequestResponse.setO2RequestsDetails(o2RequestDetails);

		return new ResponseEntity<ConsultDoctorForOxygenRequestResponse>(consultdoctorDetailsRequestResponse,
				HttpStatus.OK);

	}

}
