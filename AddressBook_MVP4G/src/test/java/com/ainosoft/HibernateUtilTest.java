package com.ainosoft;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ainosoft.server.hibernate.util.HibernateUtil;


public class HibernateUtilTest {

	@Test
	public void testGetSessionFactory() {
		assertTrue(HibernateUtil.getSessionFactory() != null);
	}

}