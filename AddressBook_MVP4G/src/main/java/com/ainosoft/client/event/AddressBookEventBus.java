package com.ainosoft.client.event;


import com.ainosoft.client.addressdisplayer.AddressDisplayerPresenter;
import com.ainosoft.client.addressform.AddressFormPresenter;
import com.ainosoft.client.base.AddressBookBasePresenter;
import com.ainosoft.client.listpanel.ListPanelPresenter;
import com.ainosoft.client.navigator.AddressBookNavigatorPresenter;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;


@Events(startPresenter = AddressBookBasePresenter.class, historyOnStart = true)
public interface AddressBookEventBus extends EventBusWithLookup {

	@Start
	@Event(handlers = {AddressBookBasePresenter.class})
	void start();

	@Event(handlers = AddressBookBasePresenter.class)
	void setNavigator(IsWidget nav);
	
	@Event(handlers = AddressBookNavigatorPresenter.class)
	void getNavigator();
	
	@Event(handlers=AddressFormPresenter.class)
	void getForm();
	
	@Event(handlers=AddressBookBasePresenter.class)
	void setForm(IsWidget form);
	
	@Event(handlers = ListPanelPresenter.class)
	void getListPanel();
	
	@Event(handlers = AddressBookBasePresenter.class)
	void setListPanel(IsWidget addrForm);

	@Event(generate = AddressDisplayerPresenter.class )
	void getAddressDisplayer(AddressSlim addrSlim, int rowIndex);

	@Event(handlers = ListPanelPresenter.class)
	void setAddressDisplayer(IsWidget addressDisplayer, int rowIndex);
	
	@Event(handlers=AddressFormPresenter.class)
	void getPopForm(AddressSlim slim);
	
	
	
}
