package com.ainosoft.server.converters;

import com.ainosoft.server.Address;
import com.ainosoft.shared.AddressSlim;

public class PojoToSlim {

	Address address;

	public PojoToSlim(Address ret) {
		address = ret;

	}

	public AddressSlim pojotoslim() {
		if (address.getIdAddress() > 0) {
			AddressSlim slim = new AddressSlim(address.getName(),
					address.getStreet(), address.getCity(),
					address.getCountry(), address.getZip(), address.getState());
			slim.setId(address.getIdAddress());
			return slim;
		} else {
			AddressSlim slim = new AddressSlim(address.getName(),
					address.getStreet(), address.getCity(),
					address.getCountry(), address.getZip(), address.getState());
			return slim;
		}

	}
}
