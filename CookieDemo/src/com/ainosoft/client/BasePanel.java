package com.ainosoft.client;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BasePanel extends Composite {
	public VerticalPanel vPanel = new VerticalPanel();
	public HorizontalPanel hPanel = new HorizontalPanel();
	public Label label = new Label("Enter A Text:");
	public Label label1 = new Label();
	public TextBox textbox= new TextBox();
	public Button button = new Button("send");
	String name;
	
	public BasePanel(){
		
		initWidget(vPanel);
	}
	
	public void createUI(){
		
		this.vPanel.add(new HTML("<br><br>"));
		
		hPanel.add(label);
		hPanel.add(textbox);
		hPanel.add(button);

		button.addClickHandler(new ClickHandler() {
	          public void onClick(ClickEvent event) {
	  
	        	  	name = textbox.getText();    	
	        	  	Window.alert(name);
	          }
	      });

		vPanel.add(hPanel);
		vPanel.setStylePrimaryName("basePanel");
		

		vPanel.setCellHorizontalAlignment(hPanel, HorizontalPanel.ALIGN_CENTER);
		
		createCookie(name);
	}
	
	
	public void createCookie(String str){
		
		boolean result=Cookies.isCookieEnabled();
		

		if(result==true){
			
			// get the cookie with name MyCookie
			String msg = Cookies.getCookie("MyCookie");

			// if null, there was no cookie
			if (msg == null) {

				Cookies.setCookie("MyCookie",str);
				msg = Cookies.getCookie("MyCookie");

				// display the cookie
				textbox.setText(msg);
			} else {
				
				str = str + "world.";
				Cookies.setCookie("MyCookie",str);
		
				// display the cookie
				textbox.setText(str);
			}

		
		
	}else{
			Window.alert("hello.");
			//displayPopupPanel("!!!Please Enable Cookie...");
		}
	}
/*	public void displayPopupPanel(String message){		
		popup.clear();
		popup.setAutoHideEnabled(true);
		dispLabel.setText(message);
		dispLabel.setStylePrimaryName("dispLabel");
		popup.setWidget(dispLabel);
		popup.setAnimationEnabled(true);
		popup.show();
	}*/	

}
