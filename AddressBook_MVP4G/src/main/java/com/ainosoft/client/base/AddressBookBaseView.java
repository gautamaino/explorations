package com.ainosoft.client.base;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddressBookBaseView extends Composite implements
	IsWidget {


	private VerticalPanel basePanel;
	private HorizontalPanel headerPanel;
	private HorizontalPanel middlePanel;
	private HorizontalPanel footerPanel;
	private HorizontalPanel savedisplay;
    private HorizontalPanel navpanel;
	private Label lable; 
	
	public AddressBookBaseView() {

		basePanel = new VerticalPanel();
		headerPanel = new HorizontalPanel();
        middlePanel = new HorizontalPanel();
        footerPanel = new HorizontalPanel();
        savedisplay = new HorizontalPanel();
        navpanel=new HorizontalPanel();
        lable=new Label("Address Book");
        
        initWidget(basePanel);

	}
	
	public VerticalPanel getBasePanel() {
		return basePanel;
	}

	public void setBasePanel(VerticalPanel basePanel) {
		this.basePanel = basePanel;
	}

	public HorizontalPanel getHeaderPanel() {
		return headerPanel;
	}

	public void setHeaderPanel(HorizontalPanel headerPanel) {
		this.headerPanel = headerPanel;
	}

	public HorizontalPanel getMiddlePanel() {
		return middlePanel;
	}

	public void setMiddlePanel(HorizontalPanel middlePanel) {
		this.middlePanel = middlePanel;
	}

	public HorizontalPanel getFooterPanel() {
		return footerPanel;
	}

	public void setFooterPanel(HorizontalPanel footerPanel) {
		this.footerPanel = footerPanel;
	}

	public HorizontalPanel getSavedisplay() {
		return savedisplay;
	}

	public void setSavedisplay(HorizontalPanel savedisplay) {
		this.savedisplay = savedisplay;
	}

	public void addNavigator(IsWidget nav) {
		getNavpanel().clear();
	 this.getNavpanel().add(nav);	
		
	}

	public void addForm(IsWidget form) {
		getSavedisplay().clear();
		getSavedisplay().add(form);
		
	}

	public void addList(IsWidget list) {
		getSavedisplay().clear(); 
	   getSavedisplay().add(list);
		
	}
	
	public HorizontalPanel getNavpanel() {
		return navpanel;
	}

	public void setNavpanel(HorizontalPanel navpanel) {
		this.navpanel = navpanel;
	}
	
	public void createUi(){
        basePanel.setStylePrimaryName("panel");
		basePanel.add(lable);
	    middlePanel.add(navpanel);
	    middlePanel.add(savedisplay); 
		basePanel.add(middlePanel);
	}

	

}
