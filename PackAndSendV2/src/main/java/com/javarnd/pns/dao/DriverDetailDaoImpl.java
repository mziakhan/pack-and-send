package com.javarnd.pns.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.pns.model.DriverDetail;
@Repository
@Transactional
public class DriverDetailDaoImpl extends AbstractDao<Long,DriverDetail> implements DriverDetailDao{

	@Override
	public void save(DriverDetail driverDetails) {
			persist(driverDetails);
	}

	@Override
	public List<DriverDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DriverDetail driverDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DriverDetail driverDetails) {
		// TODO Auto-generated method stub
		
	}

}
