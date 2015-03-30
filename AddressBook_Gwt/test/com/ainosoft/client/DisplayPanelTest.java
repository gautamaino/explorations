package com.ainosoft.client;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gwt.junit.client.GWTTestCase;

public class DisplayPanelTest extends GWTTestCase {

	public void testCreateDisplayPanel() {
	
		DisplayPanel dPanel=new DisplayPanel();
		assertEquals("FlexStyle",dPanel.getStylePrimaryName());
	}

	@Override
	public String getModuleName() {
		return "com.ainosoft.AddressBook_Gwt";
	}

}
