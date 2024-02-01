package com.oxygen.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.oxygen.model.Supplier;
import com.oxygen.repository.SupplierRepository;
import com.oxygen.response.GlobalErrorResponse;
import com.oxygen.response.SupplierResponse;

@Service
public class SupplierService {

	@Autowired
	SupplierRepository supplierRepository;

	public ResponseEntity<SupplierResponse> getSupplierDetails() {

		SupplierResponse supplierResponse = new SupplierResponse();
		List<Supplier> data = supplierRepository.findAll();
		supplierResponse.setData(data);
		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("List of suppliers data");
		supplierResponse.setErrorResponse(errorResponse);

		return new ResponseEntity<SupplierResponse>(supplierResponse, HttpStatus.OK);

	}

	public ResponseEntity<SupplierResponse> createSupplierDetails(Supplier supplier) {

		SupplierResponse supplierResponse = new SupplierResponse();
		Supplier data = supplierRepository.findById(supplier.getSupplierId());

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();

		if (data == null) {
			supplierRepository.save(supplier);
			errorResponse.setStatus(true);
			errorResponse.setDescription("supplier data created successfully");
			supplierResponse.setErrorResponse(errorResponse);
			return new ResponseEntity<SupplierResponse>(supplierResponse, HttpStatus.CREATED);
		}

		errorResponse.setStatus(false);
		errorResponse.setDescription("supplier id's are already exist");
		supplierResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<SupplierResponse>(supplierResponse, HttpStatus.CONFLICT);

	}

	public ResponseEntity<SupplierResponse> updateSupplierDetails(Supplier supplier) {

		SupplierResponse supplierResponse = new SupplierResponse();
		List<Supplier> data = new ArrayList<Supplier>();
		supplierRepository.save(supplier);
		data.add(supplier);
		supplierResponse.setData(data);
		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("supplier details with id" + supplier.getSupplierId() + " is updated");
		supplierResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<SupplierResponse>(supplierResponse, HttpStatus.OK);

	}

	public ResponseEntity<SupplierResponse> deleteSupplierDetails(int supplierId) {

		SupplierResponse supplierResponse = new SupplierResponse();
		supplierRepository.deleteById(supplierId);

		GlobalErrorResponse errorResponse = new GlobalErrorResponse();
		errorResponse.setStatus(true);
		errorResponse.setDescription("supplier details with id" + supplierId + "is deleted");
		supplierResponse.setErrorResponse(errorResponse);
		return new ResponseEntity<SupplierResponse>(supplierResponse, HttpStatus.OK);
	}

}
