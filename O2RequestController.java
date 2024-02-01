package com.oxygen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oxygen.model.O2Request;
import com.oxygen.response.ConsultDoctorForOxygenRequestResponse;
import com.oxygen.response.O2RequestResponse;
import com.oxygen.service.O2RequestService;

@RestController
public class O2RequestController {

	@Autowired
	O2RequestService o2RequestService;

	@GetMapping(value = "/oxygendetails")
	ResponseEntity<O2RequestResponse> getOxygenDetails() {
		return o2RequestService.getOxygenDetails();
	}

	@PostMapping(value = "/saveoxygenrequestdetails")
	ResponseEntity<O2RequestResponse> createO2RequestData(@RequestBody O2Request request) {
		return o2RequestService.createO2RequestData(request);
	}

	@PutMapping(value = "/updateo2RequestDetails")

	ResponseEntity<O2RequestResponse> updateOxygenDetails(@RequestBody O2Request request) {
		return o2RequestService.updateOxygenDetails(request);

	}
	
	@GetMapping(value = "/getConsultForOxygen")
	ResponseEntity<ConsultDoctorForOxygenRequestResponse> getConsultOps(@RequestParam(value = "doctorId") int doctorId) {
		return o2RequestService.findByDoctorId(doctorId);
	}


}
