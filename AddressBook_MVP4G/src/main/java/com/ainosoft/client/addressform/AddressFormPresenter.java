package com.ainosoft.client.addressform;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.ainosoft.client.AddressBook_MPV4GService;
import com.ainosoft.client.AddressBook_MPV4GServiceAsync;
import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.logging.client.ConsoleLogHandler;
import com.google.gwt.logging.client.PopupLogHandler;
import com.google.gwt.logging.client.SystemLogHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = AddressFormView.class)
public class AddressFormPresenter extends BasePresenter<AddressFormView, AddressBookEventBus> {

	private Button saveBtn;
	private Button updatebtn;
	private AddressSlim addressSlim;
	private AddressBook_MPV4GServiceAsync service = GWT
			.create(AddressBook_MPV4GService.class);
	private static Logger childLogger = Logger.getLogger("ParentLogger.Child");
	private static Logger parentLogger = Logger.getLogger("ParentLogger");
	private static Logger rootLogger = Logger.getLogger("");
	public void onGetForm(){
        view.createUI();
		eventBus.setForm(view);
	}
	
	public void onGetPopForm(AddressSlim slim) {
		if(slim.getId()>0)
        	view.populateAdd(slim);
		    eventBus.setForm(view);
	}
	
	@Override
	public void bind() {
		saveBtn=view.getSaveBtn();
		saveBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addressSlim = new AddressSlim();
				addressSlim.setName(view.getNameText().getText());
				addressSlim.setCity(view.getCityText().getText());
				addressSlim.setCountry(view.getCountryText().getText());
				addressSlim.setState(view.getStateText().getText());
				addressSlim.setStreet(view.getStreetText().getText());
				addressSlim.setZip(view.getZipText().getText());
				if(view.getNameText().getText()=="" 
						|| view.getCityText().getText()=="" 
						||view.getCountryText().getText()==""
						|| view.getStateText().getText()==""
						|| view.getStreetText().getText()==""
						|| view.getZipText().getText()==""){
					LogRecord record=new LogRecord(Level.WARNING, "Please Fill All The Attributes ");
					PopupLogHandler pop=new PopupLogHandler();
					pop.publish(record);
					rootLogger.addHandler(pop);
					
				}
				else{
				service.addAddress(addressSlim, new AsyncCallback<Boolean>() {

					@Override
					public void onSuccess(Boolean result) {

						Window.alert("Saved");
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						

					}
				});}

			}
		});
		
		updatebtn=view.getUpdateBtn();
		updatebtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {

				addressSlim = new AddressSlim();
				addressSlim.setId(view.getAddressslim().getId()); 
				addressSlim.setName(view.getNameText().getText());
				addressSlim.setCity(view.getCityText().getText());
				addressSlim.setCountry(view.getCountryText().getText());
				addressSlim.setState(view.getStateText().getText());
				addressSlim.setStreet(view.getStreetText().getText());
				addressSlim.setZip(view.getZipText().getText());
				service.addAddress(addressSlim, new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						
					}

					@Override
					public void onSuccess(Boolean arg0) {
						Window.alert("Updated");
						
					}
				});
				
			}
		});
		
	}
}
