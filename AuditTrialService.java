package com.oxygen.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.oxygen.model.AuditTrial;
import com.oxygen.repository.AuditTrialRepository;
import com.oxygen.response.AuditTrialResponse;
import com.oxygen.response.GlobalErrorResponse;

@Service
public class AuditTrialService {

	@Autowired
	AuditTrialRepository auditTrialRepository;

	public ResponseEntity<AuditTrialResponse> creatAuditDetails(AuditTrial audit) {


		AuditTrialResponse audiTrialResponse = new AuditTrialResponse();
		AuditTrial data = auditTrialRepository.findById(audit.getAuditId());
		GlobalErrorResponse errorResponse = new GlobalErrorResponse();

		if(data == null)
		{
		auditTrialRepository.save(audit);
		errorResponse.setDescription("audit details are created with successfully");
		errorResponse.setStatus(true);
		audiTrialResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<AuditTrialResponse>(audiTrialResponse, HttpStatus.CREATED);
		}
		
		errorResponse.setDescription("audit details are already exist..!");
		errorResponse.setStatus(false);
		audiTrialResponse.setErrorResponse(errorResponse);
		
		return new ResponseEntity<AuditTrialResponse>(audiTrialResponse, HttpStatus.CONFLICT);
	}	
	
}
