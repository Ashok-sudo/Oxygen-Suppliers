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
@Table(name = "Supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Supplier {

	@Id
	@Column(name = "supplierId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int supplierId;
	@Column(name = "sname")
	String sname;
	@Column(name = "saddress")
	String saddress;
	@Column(name="stock")
	int stock;
	
	

}
