package com.ainosoft.client.listpanel;


import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class ListPanelView extends Composite{

	private FlexTable table;
	private Label name;
	private Label street;
	private Label city;
	private Label country;
	private Label zip;
	private Label state;
	private Label action;
	private FlexTable headerFlex;
	
	
	
	public ListPanelView() {
		table = new FlexTable();
		headerFlex = new FlexTable();
		name = new Label();
		street = new Label();
		city = new Label();
		country = new Label();
		zip = new Label();
		state=new Label();
		action = new Label();
	
		table.clear();
		initWidget(table);
		table.setBorderWidth(2);
	}
	
	
	public void populateFlex() {
		name.setText("Name");
		name.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 0, name);
		
		street.setText("Street");
		street.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 1,street);
		
		city.setText("City");
		city.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 2,city);
		
		country.setText("Country");
		country.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 3,country);
		
		zip.setText("Zip");
		zip.setStylePrimaryName("borderTitle");
		headerFlex.setWidget(0, 4,zip);
		
		
		state.setText("State");
		headerFlex.setWidget(0, 5, state);
		
		action.setText("Action");
		action.setStylePrimaryName("actionTitle");
		headerFlex.setWidget(0, 6,action);
		
		table.setWidget(0, 0, headerFlex);
		
	}

	


	public FlexTable getTable() {
		return table;
	}


	public void setTable(FlexTable table) {
		this.table = table;
	}


	public void displayPopupPanel(String msg) {
		PopupPanel popUpPanel = new PopupPanel(true);
		Label dispLabel = new Label(msg);
		dispLabel.setStylePrimaryName("dispLabel");
		popUpPanel.setWidget(dispLabel);
		popUpPanel.setAnimationEnabled(true);
		popUpPanel.setPopupPosition((Window.getClientWidth() - getOffsetWidth())/2 + 50 , (Window.getClientHeight() - getOffsetHeight())/2 -100);
		popUpPanel.setStylePrimaryName("popUpPanel");
		popUpPanel.show();
	}


	public void addDisplayer(IsWidget aDisplayer, int rowIndex) {
		try{
			table.setWidget(rowIndex, 0, aDisplayer);
			
		}
		catch(Exception e){
			throw e;
		}
		
	}

}
