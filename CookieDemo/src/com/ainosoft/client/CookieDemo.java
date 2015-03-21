package com.ainosoft.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CookieDemo implements EntryPoint {
	
	
	public TextBox nameField = new TextBox();
	public PopupPanel popup = new PopupPanel();
	public Label dispLabel = new Label();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		boolean result=Cookies.isCookieEnabled();
		
		if(result==true){
			
			// get the cookie with name MyCookie
			String msg = Cookies.getCookie("MyCookie");

			// if null, there was no cookie
			if (msg == null) {

				Cookies.setCookie("MyCookie", "Hello");
				msg = Cookies.getCookie("MyCookie");

			} else {
				
				msg = msg + "world.";
				Cookies.setCookie("MyCookie",msg);
			}

		// display the cookie
		nameField.setText(msg);
		RootPanel.get("nameFieldContainer").add(nameField);
	}else{
		
			displayPopupPanel("!!!Please Enable Cookie...");
		}
	}
	public void displayPopupPanel(String message){		
		popup.clear();
		popup.setAutoHideEnabled(true);
		dispLabel.setText(message);
		dispLabel.setStylePrimaryName("dispLabel");
		popup.setWidget(dispLabel);
		popup.setAnimationEnabled(true);
		popup.show();
	}	
}
