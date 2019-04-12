package com.javarnd.pns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.pns.dao.DriverDetailDao;
import com.javarnd.pns.model.DriverDetail;

@Service
public class DriverDetailService {
	public void save(DriverDetail driverDetails) throws Exception {
		ddDao.save(driverDetails);
	}

	public List<DriverDetail> findAll() throws Exception {
		return ddDao.findAll();
	}

	public void update(DriverDetail driverDetails) throws Exception {
		ddDao.update(driverDetails);
	}

	public void delete(DriverDetail driverDetails) throws Exception {
		ddDao.delete(driverDetails);
	}

	@Autowired
	DriverDetailDao ddDao;
}
