package ru.itis.inform.DAOs;

import ru.itis.inform.models.rieltoryModel.Address;

/**
 * Created by Natalia on 05.11.16.
 */
public interface AddressDAO {

    Address getAddress(int id);
    public int save (Address address);
    public int findAddress(Address address);
}

