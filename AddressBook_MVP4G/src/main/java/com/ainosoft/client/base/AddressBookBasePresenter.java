package com.ainosoft.client.base;

import com.ainosoft.client.event.AddressBookEventBus;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = AddressBookBaseView.class)
public class AddressBookBasePresenter extends
		BasePresenter<AddressBookBaseView, AddressBookEventBus> 
		 {

	public void onStart() {
        view.createUi();
		eventBus.getNavigator();

	}

	public void onSetNavigator(IsWidget nav) {
		view.addNavigator(nav);
	}

	public void onSetForm(IsWidget form) {
		view.addForm(form);
	}

	public void onSetListPanel(IsWidget list) {
		view.addList(list);

	}

}
