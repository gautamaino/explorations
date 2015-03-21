package com.ainosoft.client;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface PagingGridService extends RemoteService {
	PagingLoadResult<AddressSlim> getAddressList(PagingLoadConfig config);
}
