package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.AddressDao;
import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.entities.AddressEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDaoImpl extends GenericDao implements AddressDao {

	@Override
	public AddressEntity insert(AddressEntity addressEntity) {
		entityManager.persist(addressEntity);
		return addressEntity;
	}

	@Override
	public AddressEntity get(AddressEntity addressEntity) {
		return addressEntity;
	}

	@Override
	public AddressEntity update(AddressEntity addressEntity) {
		entityManager.merge(addressEntity);
		return addressEntity;
	}

	public void delete(AddressEntity addressEntity) {
		entityManager.remove(entityManager.merge(addressEntity));
	}

	@Override
	public List<AddressEntity> getAll() {
		List<AddressEntity> addresses = entityManager.createQuery("from AddressEntity", AddressEntity.class).getResultList();
		return addresses;
	}
}
