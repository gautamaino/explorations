package com.ainosoft.server;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ainosoft.server.AddressDao;
import com.ainosoft.shared.AddressBookSlim;

public class AddressDaoTest {

	@Test
	public void saveAddressTest() {
	
		AddressDao dao=new AddressDao();
		
		AddressBookSlim addressSlim=new AddressBookSlim("India","maharashtra","pune","paud road","411038");
		
		AddressBookSlim retAddress = dao.saveAddress(addressSlim);
		
		assertTrue(retAddress.getCountry().equals("India"));
		assertTrue(retAddress.getState().equals("maharashtra"));
		assertTrue(retAddress.getCity().equals("pune"));
		assertTrue(retAddress.getStreet().equals("paud road"));
		assertTrue(retAddress.getZip().equals("411038"));
	}

	@Test
	public void updateAddressTest() {
		
		AddressDao dao=new AddressDao();
		
		AddressBookSlim addressSlim=new AddressBookSlim("India","maharashtra","pune","paud road","411039");
		
		AddressBookSlim retAddress = dao.saveAddress(addressSlim);
		
		retAddress.setCity("Nashik");
		
		dao.updateAddress(retAddress);
		
		assertTrue(retAddress.getCity().equals("Nashik"));

	}
	
	@Test
	public void loadAddressBookTest() {
	
		AddressDao dao=new AddressDao();
		AddressBookSlim addressSlim1=new AddressBookSlim("India","maharashtra","pune","paud road","411038");
		AddressBookSlim addressSlim2=new AddressBookSlim("India1","maharashtra1","pune1","paud road1","411039");
		AddressBookSlim addressSlim3=new AddressBookSlim("India2","maharashtra2","pune2","paud road2","411040");
		
		dao.saveAddress(addressSlim1);
		dao.saveAddress(addressSlim2);
		dao.saveAddress(addressSlim3);

		 ArrayList<AddressBookSlim> list=dao.loadAddressBook();
		 assertTrue(list.size()==3);
	}
	
}
