package com.ainosoft.server;

import java.util.List;

import org.hibernate.Session;

import com.ainosoft.client.PagingGridService;
import com.ainosoft.server.hibernate.util.HibernateUtil;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PagingGridServiceImpl extends RemoteServiceServlet implements
		PagingGridService {

	@Override
	public PagingLoadResult<AddressSlim> getAddressList(PagingLoadConfig config) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			AddressHome getter = new AddressHome(session);
			List<AddressSlim> list = getter.getAddressList(config.getOffset(),
					config.getLimit());

			PagingLoadResult<AddressSlim> result = new PagingLoadResultBean<AddressSlim>(
					list, getter.getAddressListCount(), config.getOffset());

			return result;
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}

		return null;
	}
}
