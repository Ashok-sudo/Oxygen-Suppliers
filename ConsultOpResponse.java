package com.oxygen.response;

import com.oxygen.model.ConsultOp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsultOpResponse {
	ConsultOp data;
	GlobalErrorResponse errorResponse;

}
