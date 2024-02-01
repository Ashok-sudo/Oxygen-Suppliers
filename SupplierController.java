package com.oxygen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.oxygen.model.Supplier;
import com.oxygen.response.SupplierResponse;
import com.oxygen.service.SupplierService;

@RestController
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@GetMapping(value = "/supplierdetails")
	public ResponseEntity<SupplierResponse> getSupplierDetails() {

		return supplierService.getSupplierDetails();

	}

	@PostMapping(value = "/suppliersavedata")

	public ResponseEntity<SupplierResponse> createSupplierDetails(@RequestBody Supplier supplier) {

		return supplierService.createSupplierDetails(supplier);

	}

	@PutMapping(value = "/supplierupdatedetails")
	public ResponseEntity<SupplierResponse> updateSupplierDetails(@RequestBody Supplier supplier) {

		return supplierService.updateSupplierDetails(supplier);

	}

	@DeleteMapping(value = "/supplierdeletedetails/{supplierId}")
	public ResponseEntity<SupplierResponse> deleteSupplierDetails(@PathVariable("supplierId") int supplierId) {

		return supplierService.deleteSupplierDetails(supplierId);

	}

}
