package com.ainosoft.client;

import com.ainosoft.client.event.AddressBookEvent;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class AddressBook_Gwt implements EntryPoint {

	public static EventBus EVENTBUS = GWT.create(SimpleEventBus.class);

	public void onModuleLoad() {
		BasePanel panel = new BasePanel();
		panel.createBasePanel();
		EVENTBUS.addHandler(AddressBookEvent.TYPE, panel);
		RootPanel.get().add(panel);
	}
}