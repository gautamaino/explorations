package com.ainosoft.server;

import java.util.ArrayList;

import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	

	void AddAddress(AddressBookSlim addressslim, AsyncCallback<Boolean> callback);

	void ViewAddress(AsyncCallback<ArrayList<AddressBookSlim>> callback);

	void updateAddress(AddressBookSlim addressSlim, AsyncCallback<Void> callback);

}
