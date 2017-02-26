package ru.itis.inform.dao;

import ru.itis.inform.models.rieltoryModel.Address;

/**
 * Created by Natalia on 05.11.16.
 */
public interface AddressDAO extends BaseDao<Address> {

    public int findAddress(Address address);
}

