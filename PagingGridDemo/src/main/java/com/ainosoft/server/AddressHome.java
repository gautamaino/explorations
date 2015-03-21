package com.ainosoft.server;

// Generated 6 Mar, 2015 10:55:02 AM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ainosoft.server.converters.PojoToSlim;
import com.ainosoft.shared.AddressSlim;

/**
 * Home object for domain model class Address.
 * 
 * @see com.ainosoft.server.Address
 * @author Hibernate Tools
 */
public class AddressHome {

	private static final Log log = LogFactory.getLog(AddressHome.class);
	private Session session;

	public AddressHome(Session sess) {
		this.session = sess;
	}

	public void persist(Address transientInstance) {
		log.debug("persisting Address instance");
		try {
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Address persistentInstance) {
		log.debug("deleting Address instance");
		try {
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Address merge(Address detachedInstance) {
		log.debug("merging Address instance");
		try {
			session.beginTransaction();
			Address result = (Address) session.merge(detachedInstance);
			session.getTransaction().commit();
			session.close();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Address findById(int id) {
		log.debug("getting Address instance with id: " + id);
		try {
			session.beginTransaction();
			Address instance = (Address) session
					.get("com.ainosoft.Address", id);
			session.getTransaction().commit();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public void update(Address address) {

		try {
			session.beginTransaction();
			session.saveOrUpdate(address);
			session.getTransaction().commit();
			session.close();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<AddressSlim> getAddressList(int offset, int limit) {
		List<AddressSlim> list = new ArrayList<AddressSlim>();

		Query q = session.createQuery("from Address");
		q.setFirstResult(offset);
		q.setMaxResults(limit);
		List<Address> l = q.list();
		for (Address a : l) {
			PojoToSlim con = new PojoToSlim(a);
			list.add(con.pojotoslim());
		}
		return list;
	}

	public int getAddressListCount() {
		List<AddressSlim> list = new ArrayList<AddressSlim>();

		Query q = session.createQuery("from Address");

		List<Address> l = q.list();
		for (Address a : l) {
			PojoToSlim con = new PojoToSlim(a);
			list.add(con.pojotoslim());
		}
		return list.size();
	}

}
