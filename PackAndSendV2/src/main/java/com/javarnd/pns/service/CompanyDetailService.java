package com.javarnd.pns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javarnd.pns.dao.CompanyDetailDao;
import com.javarnd.pns.model.CompanyDetails;
@Service
public class CompanyDetailService {
	
	public void save(CompanyDetails compDetails)throws Exception {
		cdDao.save(compDetails);
	}

	public List<CompanyDetails> findAll()throws Exception {
		return cdDao.findAll();
	}

	public CompanyDetails findById(long countryId)throws Exception {
		return cdDao.findById(countryId);
	}

	public void update(CompanyDetails compDetails)throws Exception {
		cdDao.update(compDetails);
	}

	public void delete(CompanyDetails compDetails)throws Exception {
		cdDao.delete(compDetails);
	}
	
	@Autowired
	CompanyDetailDao cdDao;

}
