package com.maktab.Q2.model.dao;

import com.maktab.Q2.core.dao.BaseDaoImpl;
import com.maktab.Q2.model.Address;
import org.hibernate.SessionFactory;

public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDAO {

    public AddressDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    public String getEntityName() {
        return "Address";
    }

}
