package com.oxygen.response;

import java.util.List;

import com.oxygen.model.Doctor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ConsultDoctorForOxygenRequestResponse {

	
	Doctor doctorDetails;
	List<O2RequestDetailsResponse> O2RequestsDetails;
	
	
}
