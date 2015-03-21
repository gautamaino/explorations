package com.ainosoft.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;
 
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class addressbook_mvp4g implements EntryPoint {
	/**
	 * First method call. Which will start the MVP4G framework
	 * and the load the Base widget 
	 */
	
	
	@Override
	public void onModuleLoad() {
		
		Mvp4gModule module = (Mvp4gModule)GWT.create( Mvp4gModule.class );
		module.createAndStartModule();
		RootPanel.get().add( (Widget)module.getStartView());
	    RootPanel.get().setStylePrimaryName("basic");
	}
}
