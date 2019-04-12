package com.javarnd.pns.dao;

import java.util.List;

import com.javarnd.pns.model.DriverDetail;

public interface DriverDetailDao {
	
	public void save(DriverDetail driverDetails);
	
    public List<DriverDetail> findAll();
    
    public void update(DriverDetail driverDetails);
    
    public void delete (DriverDetail driverDetails);
}
