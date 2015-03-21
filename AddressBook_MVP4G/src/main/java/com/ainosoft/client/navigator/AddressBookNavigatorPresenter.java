package com.ainosoft.client.navigator;

import com.ainosoft.client.event.AddressBookEventBus;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = AddressBookNavigatorView.class)
public class AddressBookNavigatorPresenter extends
		BasePresenter<AddressBookNavigatorView, AddressBookEventBus> {

	public void onGetNavigator() {
		view.createUI();
		eventBus.setNavigator(view);
	}

	@Override
	public void bind() {
		view.getAddAddr().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent paramClickEvent) {
				eventBus.getForm();

			}
		});

		view.getViewAddr().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent paramClickEvent) {
				eventBus.getListPanel();

			}
		});

	}
}
