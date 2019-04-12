package com.javarnd.pns.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class DriverDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="driver_id")
	private long id;
	
	private String name;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="license_no")
	private String licenseNo;
	
	@ManyToMany(mappedBy="availableDriverList",cascade=CascadeType.ALL)
	private List<Vehicle> asignedVehicle;
	
	@ManyToOne
	@JoinColumn(name="company_id")
//	@Transient
	private CompanyDetails companyDetail;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public List<Vehicle> getAsignedVehicle() {
		return asignedVehicle;
	}

	public void setAsignedVehicle(List<Vehicle> asignedVehicle) {
		this.asignedVehicle = asignedVehicle;
	}

	public CompanyDetails getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(CompanyDetails companyDetail) {
		this.companyDetail = companyDetail;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


}
