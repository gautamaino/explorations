package com.ainosoft.server;

import java.util.ArrayList;

import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	
	boolean AddAddress(AddressBookSlim addressslim)throws IllegalArgumentException;

	ArrayList<AddressBookSlim> ViewAddress();
	
	void updateAddress(AddressBookSlim addressSlim)throws IllegalArgumentException;
}
