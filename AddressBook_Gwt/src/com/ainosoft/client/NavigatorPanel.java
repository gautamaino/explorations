package com.ainosoft.client;

import java.util.ArrayList;

import com.ainosoft.client.event.AddressBookEvent;
import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NavigatorPanel extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	@SuppressWarnings("unused")
	private HorizontalPanel hPanel = new HorizontalPanel();

	@SuppressWarnings("unused")
	private ArrayList<AddressBookSlim> alist = new ArrayList<AddressBookSlim>();

	public NavigatorPanel() {
		vPanel.setStylePrimaryName("NavigatorPanel");
		initWidget(vPanel);
	}

	public void createNavigatorPanel() {

		Button btn1 = new Button("Add Address");
		Button btn2 = new Button("Show Address");
		vPanel.add(btn1);
		vPanel.add(btn2);
		btn1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {

				AddressBookEvent abEvent = new AddressBookEvent(
						AddressBookEvent.ADDADDRESS, null, null);
				AddressBook_Gwt.EVENTBUS.fireEvent(abEvent);
			}
		});

		btn2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				AddressBookEvent abEvent = new AddressBookEvent(
						AddressBookEvent.VIEWADDRESS, null, null);
				AddressBook_Gwt.EVENTBUS.fireEvent(abEvent);
			}
		});
	}
}