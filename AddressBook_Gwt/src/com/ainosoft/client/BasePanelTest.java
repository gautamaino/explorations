package com.ainosoft.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

public class BasePanelTest extends GWTTestCase {

	public void testBAsePanel() {
		
		BasePanel bPanel=new BasePanel();
		assertTrue(bPanel.getvPanel().getStylePrimaryName().equals("BasePanel"));
		assertTrue(bPanel.getL1().getStylePrimaryName().equals("LabelStyle"));
		
	}

	@Override
	public String getModuleName() {
		return "com.ainosoft.AddressBook_Gwt";
	}

}
