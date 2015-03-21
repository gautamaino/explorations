package com.ainosoft.server;

import com.ainosoft.client.AddressProperties;
import com.ainosoft.shared.AddressSlim;
import com.sencha.gxt.core.client.ValueProvider;

public class AddressPropertiesImpl implements AddressProperties {

	@Override
	public ValueProvider<AddressSlim, String> getName() {
		ValueProvider<AddressSlim, String> vp = new ValueProvider<AddressSlim, String>() {

			@Override
			public void setValue(AddressSlim object, String value) {
				value = object.getName();
			}

			@Override
			public String getValue(AddressSlim object) {
				return object.getName();
			}

			@Override
			public String getPath() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return vp;
	}

	@Override
	public ValueProvider<AddressSlim, String> getStreet() {
		ValueProvider<AddressSlim, String> vp = new ValueProvider<AddressSlim, String>() {

			@Override
			public void setValue(AddressSlim object, String value) {
				value = object.getStreet();
			}

			@Override
			public String getValue(AddressSlim object) {
				return object.getStreet();
			}

			@Override
			public String getPath() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return vp;
	}

	@Override
	public ValueProvider<AddressSlim, String> getCity() {
		ValueProvider<AddressSlim, String> vp = new ValueProvider<AddressSlim, String>() {

			@Override
			public void setValue(AddressSlim object, String value) {
				value = object.getCity();
			}

			@Override
			public String getValue(AddressSlim object) {
				return object.getCity();
			}

			@Override
			public String getPath() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return vp;
	}

	@Override
	public ValueProvider<AddressSlim, Integer> getId() {
		ValueProvider<AddressSlim, Integer> vp = new ValueProvider<AddressSlim, Integer>() {

			@Override
			public void setValue(AddressSlim object, Integer value) {
				value = object.getId();
			}

			@Override
			public Integer getValue(AddressSlim object) {
				return object.getId();
			}

			@Override
			public String getPath() {
				// TODO Auto-generated method stub
				return null;
			}

		};
		return vp;
	}

}
