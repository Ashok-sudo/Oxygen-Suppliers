package com.oxygen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.model.O2Request;

@Repository
public interface O2RequestRepository extends JpaRepository<O2Request, Integer> {

	List<O2Request> findAll();

	O2Request findById(int o2requestId);

	List<O2Request> findByDoctorId(int doctorId);

}
