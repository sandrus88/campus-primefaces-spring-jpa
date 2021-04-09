package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.AddressEntity;

public interface AddressDao {
	AddressEntity insert(AddressEntity addressEntity);
	AddressEntity get(AddressEntity addressEntity);
	AddressEntity update(AddressEntity addressEntity);
	void delete(AddressEntity addressEntity);
}
