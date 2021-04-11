package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.AddressEntity;

import java.util.List;

public interface AddressDao {
    AddressEntity insert(AddressEntity addressEntity);

    AddressEntity get(AddressEntity addressEntity);

    AddressEntity update(AddressEntity addressEntity);

    List<AddressEntity> getAll();

    void delete(AddressEntity addressEntity);
}
