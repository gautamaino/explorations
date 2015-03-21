package com.ainosoft.server.converters;

import com.ainosoft.server.Address;
import com.ainosoft.shared.AddressSlim;

public class SlimToPojo {

	AddressSlim slim;

	public SlimToPojo(AddressSlim inslim) {
		this.slim = inslim;
	}

	public Address slimtopojo() {
		if (slim.getId() > 0) {
			Address address = new Address(slim.getCountry(), slim.getState(),
					slim.getCity(), slim.getStreet(), slim.getZip(),
					slim.getName());
			address.setIdAddress(slim.getId());
			return address;
		} else {
			Address address = new Address(slim.getCountry(), slim.getState(),
					slim.getCity(), slim.getStreet(), slim.getZip(),
					slim.getName());
			return address;
		}
	}
}
