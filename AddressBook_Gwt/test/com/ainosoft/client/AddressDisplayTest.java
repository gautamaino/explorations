package com.ainosoft.client;

import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.junit.client.GWTTestCase;

public class AddressDisplayTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.ainosoft.AddressBook_Gwt";
	}

	public void testAddressDisplay() {

		AddressBookSlim address = new AddressBookSlim("India", "Maharashtra",
				"Pune", "FC Road", "411001");
		AddressDisplay aDisply = new AddressDisplay(address);
		aDisply.createUi();
		assertTrue(aDisply.getStreetLb().getText().equals("FC Road"));
		assertTrue(aDisply.getStateLb().getText().equals("Maharashtra"));
		assertTrue(aDisply.getCityLb().getText().equals("Pune"));
		assertTrue(aDisply.getCountryLb().getText().equals("India"));
		assertTrue(aDisply.getZipLb().getText().equals("411001"));
		assertTrue(aDisply.getZipLb().getStylePrimaryName().equals("border"));
	}
}
