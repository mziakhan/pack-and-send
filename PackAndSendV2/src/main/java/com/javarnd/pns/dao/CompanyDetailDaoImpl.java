package com.javarnd.pns.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javarnd.pns.model.CompanyDetails;

@Repository
@Transactional
public class CompanyDetailDaoImpl extends AbstractDao<Long, CompanyDetails> implements CompanyDetailDao {

	@Override
	public void save(CompanyDetails compDetails) {
		persist(compDetails);
	}

	@SuppressWarnings("unchecked")
	@Cacheable("companyDetails")
	@Override
	public List<CompanyDetails> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<CompanyDetails>) criteria.list();
	}
//	@Override
//	public List<CompanyDetails> findAll() {
//		Query query = createEntityQuery();
//		return (List<CompanyDetails>) query.list();
//	}

	@Override
	public void update(CompanyDetails compDetails) {
		CompanyDetails existedCompany = findById(compDetails.getCompanyId());
		if (existedCompany != null) {
		}
	}

	@Override
	@CacheEvict(value = "companyDetails", allEntries = true)
	public void delete(CompanyDetails compDetails) {
		delete(compDetails);
	}

	@Override
	public CompanyDetails findById(long companyId) {
		return getByKey(companyId);
	}

}
