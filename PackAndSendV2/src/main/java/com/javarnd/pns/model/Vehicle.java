package com.javarnd.pns.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.javarnd.pns.util.DateUtility;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id")
	private long vehicleId;

	@Column(name = "type")
	private String vehicleType;

	@Column(name = "number")
	private String vehicleNumber;

	@Column(name = "registration_no")
	private String regNo;

	private String make;

	private String model;

	@Column(name = "mfg_date")
	private Date mfgDate;

	@Transient
	private String mfgDateStr;

	@OneToOne
	@JoinColumn(name = "company_id")
	private CompanyDetails companyDetail;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "VEHICLE_ASSIGNED_TO_DRIVER", joinColumns = @JoinColumn(name = "vehicle_id"), inverseJoinColumns = @JoinColumn(name = "driver_id"))
	private List<DriverDetail> availableDriverList;

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<DriverDetail> getAvailableDriverList() {
		return availableDriverList;
	}

	public void setAvailableDriverList(List<DriverDetail> availableDriverList) {
		this.availableDriverList = availableDriverList;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public CompanyDetails getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(CompanyDetails companyDetail) {
		this.companyDetail = companyDetail;
	}

	public String getMfgDateStr() {
		return mfgDateStr;
	}

	public void setMfgDateStr(String mfgDateStr) {
		this.mfgDateStr = mfgDateStr;
		if (mfgDateStr != null) {
			this.mfgDate = DateUtility.stringToSQLDate(mfgDateStr);
		}
	}

}
