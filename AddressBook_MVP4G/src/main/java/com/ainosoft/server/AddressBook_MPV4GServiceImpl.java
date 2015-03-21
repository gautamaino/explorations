package com.ainosoft.server;

import java.util.List;

import org.hibernate.Session;

import com.ainosoft.client.AddressBook_MPV4GService;
import com.ainosoft.server.converters.PojoToSlim;
import com.ainosoft.server.converters.SlimToPojo;
import com.ainosoft.server.hibernate.util.HibernateUtil;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AddressBook_MPV4GServiceImpl extends RemoteServiceServlet implements AddressBook_MPV4GService {

	@Override
	public Boolean addAddress(AddressSlim a) throws IllegalArgumentException {
       try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		SlimToPojo converter = new SlimToPojo(a);
		AddressHome saver = new AddressHome(session);
		Address savethis = converter.slimtopojo();
        saver.update(savethis);
        }catch (Exception e) {
		  e.printStackTrace();
	   }
       return true;
	}

	@Override
	public List<AddressSlim> showAllAddresses() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		AddressHome getter = new AddressHome(session);
		return getter.getAddressList();

	}

	@Override
	public Boolean deleteAddress(AddressSlim del) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		AddressHome getter = new AddressHome(session);
		SlimToPojo pojo = new SlimToPojo(del);
		getter.delete(pojo.slimtopojo());
        return true;
	}
	
	public AddressSlim find(AddressSlim slim){
		Session session = HibernateUtil.getSessionFactory().openSession();
		AddressHome getter = new AddressHome(session);
		SlimToPojo pojo = new SlimToPojo(slim);
		Address ret=getter.findById(pojo.slimtopojo().getIdAddress());
		PojoToSlim retpojo=new PojoToSlim(ret);
		return retpojo.pojotoslim();
	}

}
