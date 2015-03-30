package com.ainosoft.client;

import java.util.ArrayList;

import com.ainosoft.server.GreetingService;
import com.ainosoft.server.GreetingServiceAsync;
import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddAddress extends Composite {
	private VerticalPanel vPanel = new VerticalPanel();
	//private VerticalPanel vPanel1 = new VerticalPanel();

	//private HorizontalPanel hPanel = new HorizontalPanel();

	private Label l1 = new Label("Country");
	private Label l2 = new Label("State");
	private Label l3 = new Label("City");
	private Label l4 = new Label("Street");
	private Label l5 = new Label("Zip");

	private TextBox t1 = new TextBox();
	private TextBox t2 = new TextBox();
	private TextBox t3 = new TextBox();
	private TextBox t4 = new TextBox();
	private TextBox t5 = new TextBox();

	Button btn1 = new Button("Save Address");
	

	ArrayList<AddressBookSlim> aList = new ArrayList<AddressBookSlim>();
	public AddAddress() {
		
		vPanel.setStylePrimaryName("AddAddressPage");
		btn1.setStylePrimaryName("SaveButton");
		initWidget(vPanel);
	}

	private class btn1ClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			AddressBookSlim abook = new AddressBookSlim(t1.getText(), t2.getText(),
					t3.getText(), t4.getText(), t5.getText());

			GreetingServiceAsync greetAsync = GWT.create(GreetingService.class);
			greetAsync.AddAddress(abook,new AsyncCallback<Boolean>() {
				
				@Override
				public void onSuccess(Boolean result) {
					Window.alert("Success");
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					Window.alert(""+caught);
					
				}
			});
			
			aList.add(abook);
		}
	}

	public ArrayList<AddressBookSlim> getAddresslist() {
		return aList;
	}

	public void createAddress() {
		this.vPanel.add(l1);
		this.vPanel.add(t1);

		this.vPanel.add(l2);
		this.vPanel.add(t2);
	
		this.vPanel.add(l3);
		this.vPanel.add(t3);
	
		this.vPanel.add(l4);
		this.vPanel.add(t4);

		this.vPanel.add(l5);
		this.vPanel.add(t5);

		this.vPanel.add(btn1);
		btn1.addClickHandler(new btn1ClickHandler());
	}

	public void populateAddress(final AddressBookSlim abook) {
		this.vPanel.add(l1);
		this.vPanel.add(t1);
		t1.setText(abook.getCountry());
	
		this.vPanel.add(l2);
		this.vPanel.add(t2);
		t2.setText(abook.getState());
	
		this.vPanel.add(l3);
		this.vPanel.add(t3);
		t3.setText(abook.getCity());
	
		this.vPanel.add(l4);
		this.vPanel.add(t4);
		t4.setText(abook.getStreet());
	
		this.vPanel.add(l5);
		this.vPanel.add(t5);
		t5.setText(abook.getZip());

		//aList.remove(abook);
		this.vPanel.add(btn1);
		btn1.addClickHandler(new  ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				AddressBookSlim addressSlim=new AddressBookSlim(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText());
				addressSlim.setId(abook.getId());
				GreetingServiceAsync greetAsync = GWT.create(GreetingService.class);
				greetAsync.updateAddress(addressSlim,new AsyncCallback<Void>() {
			
					
					@Override
					public void onFailure(Throwable caught) {
						Window.alert(""+caught);
						
					}

					@Override
					public void onSuccess(Void result) {
					Window.alert("Address Updated");
						
					}
				});
				
				}
			
		});
	/*	this.hPanel.add(vPanel1);
		this.vPanel.add(hPanel);
	*/}
}