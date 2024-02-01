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
@Table(name = "Patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Patient {
	@Id
	@Column(name = "patientId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int patientId;
	@Column(name = "pname")
	String pname;
	@Column(name = "pdob")
	String pdob;
	@Column(name = "paddress")
	String paddress;
	@Column(name = "pnumber")
	String pnumber;
	@Column(name = "p_emergency_contact_number")
	String p_emergency_contact_number;

}
