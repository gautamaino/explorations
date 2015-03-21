package com.ainosoft.client.navigator;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddressBookNavigatorView extends Composite  {

	private Anchor addAddr;
	private Anchor viewAddr;
	private VerticalPanel vPanel;
	
	public AddressBookNavigatorView() {
		
		vPanel = new VerticalPanel();
		addAddr= new Anchor("Add Address");
		viewAddr= new Anchor("View All Addresses");
		initWidget(vPanel);
	}
	
	public VerticalPanel getvPanel() {
		return vPanel;
	}

	public Anchor getAddAddr() {
		return addAddr;
	}

	public void setAddAddr(Anchor addAddr) {
		this.addAddr = addAddr;
	}

	public Anchor getViewAddr() {
		return viewAddr;
	}

	public void setViewAddr(Anchor viewAddr) {
		this.viewAddr = viewAddr;
	}
	
	public void setvPanel(VerticalPanel vPanel) {
		this.vPanel = vPanel;
	}

	

	

	public void createUI() {
		vPanel.add(addAddr);
        vPanel.add(viewAddr);
}
}
