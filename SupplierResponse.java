package com.oxygen.response;

import java.util.List;

import com.oxygen.model.Supplier;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class SupplierResponse {

	List<Supplier> data;
	GlobalErrorResponse errorResponse;
}
