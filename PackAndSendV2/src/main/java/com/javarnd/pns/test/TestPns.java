package com.javarnd.pns.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.javarnd.cip.util.DateUtility;
import com.javarnd.pns.model.CompanyDetails;
import com.javarnd.pns.model.DriverDetail;
import com.javarnd.pns.model.Vehicle;
import com.javarnd.pns.service.CompanyDetailService;
import com.javarnd.pns.service.DriverDetailService;
import com.javarnd.pns.service.VehicleService;

public class TestPns {
	public static void main(String[] args) throws IOException {
		CompanyDetailService cdService=new CompanyDetailService();
		CompanyDetails cd=new CompanyDetails();
		List<DriverDetail>ddList=new ArrayList<>();
		DriverDetail driver=new DriverDetail();
		DriverDetailService dds=new DriverDetailService();
		Vehicle vehicle=new Vehicle();
		VehicleService vService=new VehicleService();
		List<Vehicle> vList=new ArrayList<>();
		
		
		BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Consigner or Consignee?");
//		
//		String type=kb.next();
//		csetCompanyType(type);
		
//		System.out.println("Company Name:");
//		String cname=kb.nextLine();
//		cd.setCompanyName(cname);
//		
//		System.out.println("Company contact:");
//		String contact=kb.nextLine();
//		cd.setContactNo(contact);
//		
//		System.out.println("Company email:");
//		String email=kb.nextLine();
//		cd.setEmail(email);
//		
//		System.out.println("Company pan:");
//		String panNo=kb.nextLine();
//		cd.setPanNo(panNo);
//		
//		System.out.println("Company website:");
//		String website=kb.nextLine();
//		cd.setWebsite(website);
//		
//		cdService.save(cd);
		
//		List<CompanyDetails> cDetail=cdService.findAll();
//		System.out.println("Choose Company: ");
//		for (CompanyDetails companyDetails : cDetail) {
//			System.out.println(companyDetails.getCompanyId() +"."+ companyDetails.getCompanyName() +"");
//		}
		
//		System.out.println("Enter name:");
//		String cname=kb.nextLine();
//		driver.setName(cname);
//		
//		System.out.println("Enter Company Id");
//		long companyId=kb.nextLong();
//		cd.setCompanyId(companyId);
//		
//
//		System.out.println("Enter License:");
//		String license=kb.next();
//		driver.setLicenseNo(license);
//		
//		System.out.println("Enter Contact");	
//		String contact=kb.nextLine();
//		driver.setContactNo(contact);
//		
//		ddList.add(driver);
//		cd.setDriverList(ddList);
//		driver.setCompanyDetail(cd);
//		dds.save(driver);
//		cdService.save(cd);
		System.out.println("Enter Company Id");
		long companyId=Long.parseLong(kb.readLine());
		cd.setCompanyId(companyId);
		
		System.out.println("Enter Type:");
		String type=kb.readLine();
		vehicle.setVehicleType(type);
		
		System.out.println("Enter model:");
		String model=kb.readLine();
		vehicle.setModel(model);
		
		System.out.println("Vehicle Make:");
		String make=kb.readLine();
		vehicle.setMake(make);

		System.out.println("Enter Vehicle no:");
		String vehicleNo=kb.readLine();
		vehicle.setVehicleNumber(vehicleNo);
		
		System.out.println("Enter Registration No");	
		String regNo=kb.readLine();
		vehicle.setRegNo(regNo);
		
		System.out.println("Manufacture Date");
		String mfgDate=kb.readLine();
//		vehicle.setManufactured(DateUtility.stringToSQLDate(mfgDate));

		vehicle.setCompanyDetail(cd);
		vService.save(vehicle);
		
		System.out.println("saved");
	}
}
