package com.oxygen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.oxygen.model.ConsultOp;
import com.oxygen.response.ConsultDoctorDetailsResponse;
import com.oxygen.response.ConsultOpResponse;
import com.oxygen.service.ConsultOpService;

@RestController
public class ConsultOpController {

	@Autowired
	ConsultOpService consultOpService;

	@GetMapping(value = "/consultOpDetails")
	ResponseEntity<ConsultOpResponse> getConsultDetails(@RequestParam(value = "consultId") int consultId) {
		return consultOpService.findById(consultId);

	}

	@PostMapping(value = "/consultOpsaveddata")
	ResponseEntity<ConsultOpResponse> createConsultations(@RequestBody ConsultOp consult) {
		return consultOpService.createConsultations(consult);

	}

	@PutMapping(value = "/updateConsultations")
	ResponseEntity<ConsultOpResponse> updateConsultDetails(@RequestBody ConsultOp consult) {
		return consultOpService.updateConsultDetails(consult);
	}

	@GetMapping(value = "/getConsultOps")
	ResponseEntity<ConsultDoctorDetailsResponse> getConsultOps(@RequestParam(value = "doctorId") int doctorId) {
		return consultOpService.findByDoctorId(doctorId);
	}

}
