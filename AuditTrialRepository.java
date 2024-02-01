package com.oxygen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxygen.model.AuditTrial;

@Repository
public interface AuditTrialRepository extends JpaRepository<AuditTrial, Integer> {

	AuditTrial findById(int auditId);

}
