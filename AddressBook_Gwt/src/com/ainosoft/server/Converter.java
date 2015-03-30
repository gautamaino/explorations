package com.ainosoft.server;

import com.ainosoft.shared.AddressBookSlim;

public class Converter {

	public AddressPojo getPojoFromSlim(AddressBookSlim address) {

		AddressPojo addrPojo = new AddressPojo();
		if (address.getId() > 0) {
			addrPojo.setId(address.getId());
			addrPojo.setCity(address.getCity());
			addrPojo.setCountry(address.getCountry());
			addrPojo.setState(address.getState());
			addrPojo.setStreet(address.getStreet());
			addrPojo.setZip(address.getZip());
		}
		else{
			
			addrPojo.setCity(address.getCity());
			addrPojo.setCountry(address.getCountry());
			addrPojo.setState(address.getState());
			addrPojo.setStreet(address.getStreet());
			addrPojo.setZip(address.getZip());
		}
		return addrPojo;
	}

	public AddressBookSlim getSlimFromPojo(AddressPojo address) {

		AddressBookSlim addrSlim = new AddressBookSlim();
		if (address.getId() > 0) {
			addrSlim.setCity(address.getCity());
			addrSlim.setCountry(address.getCountry());
			addrSlim.setState(address.getState());
			addrSlim.setStreet(address.getStreet());
			addrSlim.setZip(address.getZip());
			addrSlim.setId(address.getId());
		} else {
			addrSlim.setCity(address.getCity());
			addrSlim.setCountry(address.getCountry());
			addrSlim.setState(address.getState());
			addrSlim.setStreet(address.getStreet());
			addrSlim.setZip(address.getZip());
		}
		return addrSlim;
	}
}
