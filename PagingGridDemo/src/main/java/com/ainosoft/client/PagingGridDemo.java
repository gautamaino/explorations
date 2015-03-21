package com.ainosoft.client;

import java.util.ArrayList;
import java.util.List;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.client.loader.RpcProxy;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;

public class PagingGridDemo implements IsWidget, EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(this);
	}

	@Override
	public Widget asWidget() {
		final PagingGridServiceAsync service = GWT
				.create(PagingGridService.class);

		RpcProxy<PagingLoadConfig, PagingLoadResult<AddressSlim>> proxy = new RpcProxy<PagingLoadConfig, PagingLoadResult<AddressSlim>>() {

			@Override
			public void load(PagingLoadConfig loadConfig,
					AsyncCallback<PagingLoadResult<AddressSlim>> callback) {
				service.getAddressList(loadConfig, callback);

			}
		};

		final AddressProperties props = GWT.create(AddressProperties.class);

		ListStore<AddressSlim> store = new ListStore<AddressSlim>(
				new ModelKeyProvider<AddressSlim>() {
					@Override
					public String getKey(AddressSlim item) {
						return "" + item.getId();
					}
				});

		final PagingLoader<PagingLoadConfig, PagingLoadResult<AddressSlim>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<AddressSlim>>(
				proxy);
		loader.setRemoteSort(true);
		loader.addLoadHandler(new LoadResultListStoreBinding<PagingLoadConfig, AddressSlim, PagingLoadResult<AddressSlim>>(
				store));

		final PagingToolBar toolBar = new PagingToolBar(6);
		
		toolBar.getElement().getStyle().setProperty("borderBottom", "none");
		toolBar.bind(loader);

		ColumnConfig<AddressSlim, Integer> id = new ColumnConfig<AddressSlim, Integer>(
				props.getId(), 150, "Id");
		ColumnConfig<AddressSlim, String> name = new ColumnConfig<AddressSlim, String>(
				props.getName(), 150, "Name");
		ColumnConfig<AddressSlim, String> street = new ColumnConfig<AddressSlim, String>(
				props.getStreet(), 150, "Street");
		ColumnConfig<AddressSlim, String> city = new ColumnConfig<AddressSlim, String>(
				props.getCity(), 150, "City");

		List<ColumnConfig<AddressSlim, ?>> list = new ArrayList<ColumnConfig<AddressSlim, ?>>();
		list.add(id);
		list.add(name);
		list.add(street);
		list.add(city);

		ColumnModel<AddressSlim> cm = new ColumnModel<AddressSlim>(list);

		Grid<AddressSlim> grid = new Grid<AddressSlim>(store, cm) {
			@Override
			protected void onAfterFirstAttach() {
				super.onAfterFirstAttach();
				Scheduler.get().scheduleDeferred(new ScheduledCommand() {

					@Override
					public void execute() {
						loader.load();

					}
				});
			}
		};

		grid.getView().setForceFit(true);
		grid.setLoadMask(true);

		grid.setLoader(loader);
		// grid.setColumnReordering(true);

		FramedPanel fPanel = new FramedPanel();
		fPanel.setCollapsible(true);
		fPanel.setHeadingText("Address Book");
		fPanel.setPixelSize(500, 400);
		fPanel.addStyleName("margin-10");

		VerticalLayoutContainer con = new VerticalLayoutContainer();
		con.setBorders(true);
		con.add(grid, new VerticalLayoutData(1, 1));
		con.add(toolBar, new VerticalLayoutData(1, -1));
		fPanel.setWidget(con);

		return fPanel;
	}
}
