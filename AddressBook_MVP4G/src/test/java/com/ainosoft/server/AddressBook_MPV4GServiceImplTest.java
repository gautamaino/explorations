package com.ainosoft.server;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ainosoft.shared.AddressSlim;

public class AddressBook_MPV4GServiceImplTest {

	@Test
	public void testAddAddress() {
		AddressSlim slim = new AddressSlim("kunal", "dpRoad", "pune", "india",
				"411003", "maha");
		AddressBook_MPV4GServiceImpl impl = new AddressBook_MPV4GServiceImpl();
		assertTrue(impl.addAddress(slim));
	}

	

/*	@Test
	public void testShowAllAddresses() {
		AddressSlim slim=new AddressSlim("veeedang", "dubai Road", "dubai", "dubai", "411003", "dubai");
		AddressBook_MPV4GServiceImpl impl=new AddressBook_MPV4GServiceImpl();
		impl.addAddress(slim);
		
		assertTrue(!impl.showAllAddresses().isEmpty());
		//assertTrue(impl.find(slim).getName().equals("vedang"));
	}
*/
	/*@Test
	public void testDeleteAddress() {
		
	}
*/
	
	
}
