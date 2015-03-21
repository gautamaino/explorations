package com.ainosoft.client.addressdisplayer;


import com.ainosoft.client.AddressBook_MPV4GService;
import com.ainosoft.client.AddressBook_MPV4GServiceAsync;
import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = AddressDisplayerView.class, multiple = true)
public class AddressDisplayerPresenter extends BasePresenter<AddressDisplayerView, AddressBookEventBus>{

	@Override
	public void bind(){
		view.getDelete().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				AddressBook_MPV4GServiceAsync abService = GWT.create(AddressBook_MPV4GService.class);
				abService.deleteAddress(view.getAddrSlim(), new AsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean result) {
						String msg = "Address Deleted Successfully with Id = "+view.getAddrSlim().getId();
						view.displayPopupPanel(msg);
						view.clear();
					}
					
					@Override
					public void onFailure(Throwable caught) {
						String msg = "Address Not Deleted"+caught.getMessage();
						view.displayPopupPanel(msg);
					}
				});
				
			}
		});
		
		view.getEdit().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				eventBus.getPopForm(view.getAddrSlim());
				
			}
		});
	}
	
	public void onGetAddressDisplayer(AddressSlim addrSlim,int rowIndex){
		view.createUI(addrSlim);
		eventBus.setAddressDisplayer(view,rowIndex);
	}


}
 