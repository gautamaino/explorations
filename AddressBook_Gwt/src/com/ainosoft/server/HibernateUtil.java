package com.ainosoft.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

	private static SessionFactory sessionfactory;
	private static Configuration configuration = null;
	private static Logger logger = Logger.getLogger(HibernateUtil.class
			.getName());
	static {
		try {
			configuration = new Configuration().configure("/hibernate.cfg.xml");
		} catch (final Throwable e) {
			HibernateUtil.logger.log(Level.SEVERE, "Exception occured", e);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (HibernateUtil.sessionfactory != null)
			return HibernateUtil.sessionfactory;

		HibernateUtil.sessionfactory = HibernateUtil.configuration
				.buildSessionFactory();
		return HibernateUtil.sessionfactory;
	}
}