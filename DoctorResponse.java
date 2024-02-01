package com.oxygen.response;

import java.util.List;

import com.oxygen.model.Doctor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class DoctorResponse {

	List<Doctor> data;
	GlobalErrorResponse errorResponse;

	

}
