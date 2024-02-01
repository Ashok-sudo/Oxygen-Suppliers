package com.oxygen.response;

import com.oxygen.model.AuditTrial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuditTrialResponse 
{
	AuditTrial data;
	GlobalErrorResponse errorResponse;

	
}
