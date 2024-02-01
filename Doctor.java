package com.oxygen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Doctor {
	@Id
	@Column(name = "doctorId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int doctorId;
	@Column(name = "dname")
	String dname;
	@Column(name = "dspecialization")
	String dspecialization;
	@Column(name = "dnumber")
	String dnumber;

}
