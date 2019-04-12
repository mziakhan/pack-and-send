package com.javarnd.pns.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.javarnd.pns.model.Vehicle;

@Repository
@Transactional
public class VehicleDaoImpl extends AbstractDao<Long, Vehicle> implements VehicleDao {

	@Override
	public void save(Vehicle vehicleDetail) {
		persist(vehicleDetail);
	}

	@Override
	public List<Vehicle> findAll() {
		return null;
	}

	@Override
	public void update(Vehicle vehicleDetails) {

	}

	@Override
	@CacheEvict(value = "vehicleDetails", allEntries = true)
	public void delete(Vehicle vehicleDetails) {
		delete(vehicleDetails);
	}

	@Override
	public Vehicle findById(long vehicleId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Cacheable("companyDetails")
	public List<Vehicle> findByCompanyId(long companyId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("companyDetail.companyId", companyId));
		return (List<Vehicle>) criteria.list();
	}

}
