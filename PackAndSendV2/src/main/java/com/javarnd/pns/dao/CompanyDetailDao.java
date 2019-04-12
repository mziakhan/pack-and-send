package com.javarnd.pns.dao;

import java.util.List;

import com.javarnd.pns.model.CompanyDetails;

public interface CompanyDetailDao {
	public void save(CompanyDetails compDetails);
	
    public List<CompanyDetails> findAll();
    
    public CompanyDetails findById(long companyId);
    
    public void update(CompanyDetails compDetails);
    
    public void delete (CompanyDetails compDetails);
}
