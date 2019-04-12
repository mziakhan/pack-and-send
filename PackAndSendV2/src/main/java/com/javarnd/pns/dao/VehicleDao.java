package com.javarnd.pns.dao;

import java.util.List;

import com.javarnd.pns.model.Vehicle;

public interface VehicleDao {

	public void save(Vehicle vehicleDetail);
	
    public List<Vehicle> findAll();
    
    public void update(Vehicle vehicleDetails);
    
    public void delete (Vehicle vehicleDetails);
    
    public Vehicle findById(long vehicleId);
    
    public List<Vehicle>findByCompanyId(long companyId);
}
