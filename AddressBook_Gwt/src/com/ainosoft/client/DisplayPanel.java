package com.ainosoft.client;

import java.util.ArrayList;
import java.util.List;

import com.ainosoft.server.GreetingService;
import com.ainosoft.server.GreetingServiceAsync;
import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;

public class DisplayPanel extends Composite {

	List<AddressBookSlim> addressList = new ArrayList<AddressBookSlim>();

	AddressBookSlim address1 = new AddressBookSlim();

	private FlexTable table = new FlexTable();

	public DisplayPanel() {
		
		table.setStylePrimaryName("FlexStyle");
		table.setBorderWidth(1);
		table.setCellPadding(2);
		table.setCellSpacing(5);
		initWidget(table);
	}

	public void createDisplayPanel() {
		table.clear();
		GreetingServiceAsync greetAsync = GWT.create(GreetingService.class);
		greetAsync.ViewAddress(new AsyncCallback<ArrayList<AddressBookSlim>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("" + caught);

			}

			@Override
			public void onSuccess(ArrayList<AddressBookSlim> result) {
				Window.alert("SUCCESS VIEW");

				for (int i= 0; i< result.size(); i++) {
					AddressDisplay ad = new AddressDisplay(result.get(i));
					ad.createUi();
					table.setWidget(i, 0, ad);
				}

			}
		});
	}
}