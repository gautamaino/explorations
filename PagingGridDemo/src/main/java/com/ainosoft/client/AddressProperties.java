package com.ainosoft.client;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

@RemoteServiceRelativePath("greet")
public interface AddressProperties extends PropertyAccess<AddressSlim> {
	ValueProvider<AddressSlim, String> getName();

	ValueProvider<AddressSlim, String> getStreet();

	ValueProvider<AddressSlim, String> getCity();

	ValueProvider<AddressSlim, Integer> getId();
}
