package com.oxygen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oxygen.model.ConsultOp;

@Repository
public interface ConsultOpRepository extends JpaRepository<ConsultOp, Integer> {
	List<ConsultOp> findAll();

	ConsultOp findById(int consultId);

	List<ConsultOp> findByDoctorId(int doctorId);
}
