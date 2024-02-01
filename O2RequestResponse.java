package com.oxygen.response;

import java.util.List;

import com.oxygen.model.O2Request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class O2RequestResponse {
	List<O2Request> data;
	GlobalErrorResponse errorResponse;

}
