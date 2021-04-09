package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.AddressDao;
import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.entities.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends GenericDao implements AddressDao {

	@Override
	public AddressEntity insert(AddressEntity addressEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(addressEntity);
		entityManager.getTransaction().commit();
		return addressEntity;
	}

	@Override
	public AddressEntity get(AddressEntity addressEntity) {
		return addressEntity;
	}

	@Override
	public AddressEntity update(AddressEntity addressEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(addressEntity);
		entityManager.getTransaction().commit();
		return addressEntity;
	}
	
	public void delete(AddressEntity addressEntity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(addressEntity));
		entityManager.getTransaction().commit();
	}
}
