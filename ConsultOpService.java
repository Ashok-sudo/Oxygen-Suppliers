package com.oxygen.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.oxygen.model.ConsultOp;
import com.oxygen.model.Doctor;
import com.oxygen.model.Patient;
import com.oxygen.repository.ConsultOpRepository;
import com.oxygen.repository.DoctorRepository;
import com.oxygen.repository.PatientRepository;
import com.oxygen.response.ConsultDoctorDetailsResponse;
import com.oxygen.response.ConsultOpResponse;
import com.oxygen.response.GlobalErrorResponse;
import com.oxygen.response.PatientOPDetailsResponse;

@Service
public class ConsultOpService {

	@Autowired
	ConsultOpRepository consultOpRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	public ResponseEntity<ConsultOpResponse> createConsultations(ConsultOp consult) {
		ConsultOpResponse consultOpResponse = new ConsultOpResponse();

		ConsultOp data = (ConsultOp) consultOpRepository.findById(consult.getDoctorId());

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();

		if (data == null) {
			consultOpRepository.save(consult);
			errorResponse.setStatus(true);
			errorResponse.setDescription("consult data created successfully");
			consultOpResponse.setErrorResponse(errorResponse);
			return new ResponseEntity<ConsultOpResponse>(consultOpResponse, HttpStatus.CREATED);
		}

		errorResponse.setStatus(false);
		errorResponse.setDescription("consultant id's are already exist");
		consultOpResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<ConsultOpResponse>(consultOpResponse, HttpStatus.CONFLICT);

	}

	public ResponseEntity<ConsultOpResponse> updateConsultDetails(ConsultOp consult) {

		ConsultOpResponse consultOpResponse = new ConsultOpResponse();

		
		consultOpRepository.save(consult);
		

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("consultant details with id" + consult.getConsultId() + " is updated");
		consultOpResponse.setData(consult);
		consultOpResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<ConsultOpResponse>(consultOpResponse, HttpStatus.OK);

	}

	public ResponseEntity<ConsultOpResponse> findById(int consultId) {
		ConsultOpResponse consultOpResponse = new ConsultOpResponse();
		ConsultOp data = consultOpRepository.findById(consultId);
		consultOpResponse.setData(data);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("Display particular consultant based on consultantId");

		return new ResponseEntity<ConsultOpResponse>(consultOpResponse, HttpStatus.OK);
	}

	public ResponseEntity<ConsultDoctorDetailsResponse> findByDoctorId(int doctorId) {

		List<ConsultOp> consultOpDetails = consultOpRepository.findByDoctorId(doctorId);
		List<PatientOPDetailsResponse> patientOpDetailsList = new ArrayList<>();

		ConsultDoctorDetailsResponse consultDoctorDetailsResponse = new ConsultDoctorDetailsResponse();

		Doctor doctorDetails = doctorRepository.findByDoctorId(doctorId);
		consultDoctorDetailsResponse.setDoctorDetails(doctorDetails);

		for (ConsultOp op : consultOpDetails) {
			
			PatientOPDetailsResponse patientOPDetails = new PatientOPDetailsResponse();
			patientOPDetails.setConsultId(op.getConsultId());

			Patient patientDetails = patientRepository.findById(op.getPatientId());
			patientOPDetails.setPatientDetails(patientDetails);
			patientOpDetailsList.add(patientOPDetails);
		}
		consultDoctorDetailsResponse.setOpDetails(patientOpDetailsList);
		return new ResponseEntity<ConsultDoctorDetailsResponse>(consultDoctorDetailsResponse, HttpStatus.OK);
	}

}
