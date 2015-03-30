package com.ainosoft.client;

import java.util.ArrayList;

import com.ainosoft.client.event.AddressBookEvent;
import com.ainosoft.client.event.AddressBookEventHandler;
import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BasePanel extends Composite implements AddressBookEventHandler {

	VerticalPanel vPanel = new VerticalPanel();
	
	HorizontalPanel containerPanel = new HorizontalPanel();

	Label l1 = new Label("MY ADDRESS BOOK");

	ArrayList<AddressBookSlim> alist = new ArrayList<AddressBookSlim>();

	public BasePanel() {
		vPanel.setStylePrimaryName("BasePanel");
		//vPanel.setHeight(Window.getClientHeight()+"px");
		containerPanel.setStylePrimaryName("ContainerPanel");
		l1.setStylePrimaryName("LabelStyle");
		initWidget(vPanel);
	}

	public void createBasePanel() {
		this.vPanel.add(l1);
		NavigatorPanel nPanel = new NavigatorPanel();
		nPanel.createNavigatorPanel();
		vPanel.add(nPanel);
	}

	@Override
	public void onAddressBookEvent(AddressBookEvent event) {
		if (event.getEventType() == AddressBookEvent.ADDADDRESS) {
			containerPanel.clear();
			AddAddress addr = new AddAddress();
			addr.createAddress();
			containerPanel.add(addr);
			vPanel.add(containerPanel);
		}

		else if (event.getEventType() == AddressBookEvent.VIEWADDRESS) {
			containerPanel.clear();
			DisplayPanel panel = new DisplayPanel();
			panel.createDisplayPanel();
			containerPanel.add(panel);
			vPanel.add(containerPanel);
		}

		else if (event.getEventType() == AddressBookEvent.EDITADDRESS) {
			containerPanel.clear();
			AddAddress addr = new AddAddress();
			addr.populateAddress((AddressBookSlim) event.getEventData());
			containerPanel.add(addr);
			vPanel.add(containerPanel);
		}
	}
	
	public VerticalPanel getvPanel() {
		return vPanel;
	}

	public void setvPanel(VerticalPanel vPanel) {
		this.vPanel = vPanel;
	}

	public Label getL1() {
		return l1;
	}

	public void setL1(Label l1) {
		this.l1 = l1;
	}

}