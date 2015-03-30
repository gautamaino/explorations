package com.ainosoft.server;

// Generated 6 Mar, 2015 4:43:31 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ainosoft.shared.AddressBookSlim;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Address.
 * 
 * @see .Address
 * @author Hibernate Tools
 */
public class AddressDao {

	private static final Log log = LogFactory.getLog(AddressDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	private Session session;

	protected SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}

	public ArrayList<AddressBookSlim> loadAddressBook() {
		
		Converter converter=new Converter();
		
		log.debug("Loading Address Book instance");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			ArrayList<AddressBookSlim> listabook = new ArrayList<AddressBookSlim>();
			Query query = session.createQuery("from AddressPojo");
			List<AddressPojo> list = query.list();
			for (Object obj : list) {				
				if (obj instanceof AddressPojo) {
					
					AddressBookSlim addressSlim=converter.getSlimFromPojo((AddressPojo) obj);
					listabook.add(addressSlim);
				}
			}
			session.close();
		
			return listabook;
		} catch (RuntimeException re) {
			log.error("Loading Address Book instance failed", re);
			throw re;
		}
	}
	

	public AddressBookSlim saveAddress(AddressBookSlim transientInstance) {
		AddressBookSlim addressSlim=null;
		log.debug("persisting Address instance");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Converter converter=new Converter();
			AddressPojo addressPojo=converter.getPojoFromSlim(transientInstance);
			
			AddressPojo retAddressPojo = (AddressPojo) session.merge(addressPojo);
			
			 addressSlim=converter.getSlimFromPojo(retAddressPojo);
			 
			session.getTransaction().commit();
			session.close();

			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return addressSlim;
		
	}

	public AddressPojo findById(int id) {
		log.debug("getting Address instance with id: " + id);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			AddressPojo instance = (AddressPojo) session.get("Address", id);
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

	public void delete(AddressPojo persistentInstance) {
		log.debug("deleting Address instance");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void updateAddress(AddressBookSlim addressSlim) {
		log.debug("attaching dirty Address instance");
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			Converter converter=new Converter();
			AddressPojo addressPojo=converter.getPojoFromSlim(addressSlim);
			
			session.update(addressPojo);
			session.getTransaction().commit();
			session.close();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AddressPojo instance) {
		log.debug("attaching clean Address instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public AddressPojo merge(AddressPojo detachedInstance) {
		log.debug("merging Address instance");
		try {
			AddressPojo result = (AddressPojo) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public List<AddressPojo> findByExample(AddressPojo instance) {
		log.debug("finding Address instance by example");
		try {
			List<AddressPojo> results = (List<AddressPojo>) sessionFactory
					.getCurrentSession().createCriteria("Address")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}