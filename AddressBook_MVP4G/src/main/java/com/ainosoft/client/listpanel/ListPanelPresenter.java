package com.ainosoft.client.listpanel;



import java.util.List;

import com.ainosoft.client.AddressBook_MPV4GService;
import com.ainosoft.client.AddressBook_MPV4GServiceAsync;
import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = ListPanelView.class)
public class ListPanelPresenter extends BasePresenter<ListPanelView, AddressBookEventBus>  {

	
	
	public void onGetListPanel(){
		AddressBook_MPV4GServiceAsync abService = GWT.create(AddressBook_MPV4GService.class);
		abService.showAllAddresses(new AsyncCallback<List<AddressSlim>>() {
			
			@Override
			public void onSuccess(List<AddressSlim> result) {
				int rowIndex = 1;
				view.populateFlex();
				for(AddressSlim addrSlim : result){
					eventBus.getAddressDisplayer(addrSlim,rowIndex++);
					
				}
				
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				String msg = "Error in Fetching list from Database : \n"+caught.getMessage();
				view.displayPopupPanel(msg);
			}
		});
		
		
		
		eventBus.setListPanel(view);
	}
	
	public void onSetAddressDisplayer(IsWidget aDisplayer,int rowIndex){
		view.addDisplayer(aDisplayer,rowIndex);
	}
}
