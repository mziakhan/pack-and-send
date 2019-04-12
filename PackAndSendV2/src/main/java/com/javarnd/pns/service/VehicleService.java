package com.javarnd.pns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.pns.dao.VehicleDao;
import com.javarnd.pns.model.Vehicle;

@Service
public class VehicleService {
	public void save(Vehicle vehicleDetails) {
		vDao.save(vehicleDetails);
	}

	public List<Vehicle> findAll() {
		return vDao.findAll();
	}

	public void update(Vehicle vehicleDetails) {
		vDao.update(vehicleDetails);
	}

	public void delete(Vehicle vehicleDetails) {
		vDao.delete(vehicleDetails);
	}

	public Vehicle findById(long vehicleId) {
		return null;
	}

	public List<Vehicle> findByCompanyId(long companyId) {
		return vDao.findByCompanyId(companyId);
	}

	@Autowired
	VehicleDao vDao;
}
