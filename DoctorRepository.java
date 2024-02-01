package com.oxygen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	List<Doctor> findAll();

	Doctor findById(int doctorid);

	Doctor findByDoctorId(int doctorId);

}
