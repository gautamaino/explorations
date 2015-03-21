package com.ainosoft.client;


import java.util.List;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface AddressBook_MPV4GService extends RemoteService {
	
	public Boolean addAddress(AddressSlim a) throws IllegalArgumentException;
	
	public  List<AddressSlim> showAllAddresses();
	
	public Boolean deleteAddress(AddressSlim del);
}

