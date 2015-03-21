package com.ainosoft.client.addressform;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddressFormView extends Composite {


	public AddressSlim getAddressslim() {
		return addressslim;
	}

	public void setAddressslim(AddressSlim addressslim) {
		this.addressslim = addressslim;
	}

	private VerticalPanel vPanel;
	private HorizontalPanel namePanel;
	private HorizontalPanel streetPanel;
	private HorizontalPanel cityPanel;
	private HorizontalPanel countryPanel;
	private HorizontalPanel zipPanel;
	private HorizontalPanel statePanel;
	private HorizontalPanel savePanel;
	private HorizontalPanel updatePanel;
	
	private TextBox nameText;
	private TextBox streetText;
	private TextBox cityText;
	private TextBox stateText;
	private TextBox countryText;
	private TextBox zipText;

	private Label nameLabel;
	private Label countryLabel;
	private Label stateLabel;
	private Label cityLabel;
	private Label streetLabel;
	private Label zipLabel;

	private Button saveBtn;
    private Button updateBtn;
	
	private AddressSlim addressslim;

	public AddressFormView() {

		vPanel = new VerticalPanel();
		namePanel = new HorizontalPanel();
		streetPanel = new HorizontalPanel();
		cityPanel = new HorizontalPanel();
		countryPanel = new HorizontalPanel();
		zipPanel = new HorizontalPanel();
		savePanel = new HorizontalPanel();
	    statePanel = new HorizontalPanel();
        updatePanel=new HorizontalPanel(); 
		
	    nameText = new TextBox();
		streetText = new TextBox();
		cityText = new TextBox();
		countryText = new TextBox();
		zipText = new TextBox();
		stateText = new TextBox();

		nameLabel = new Label("Name:	");
		streetLabel = new Label("Street:	");
		cityLabel = new Label("City:	");
		countryLabel = new Label("Country:	");
		zipLabel = new Label("Zip:	");
		stateLabel = new Label("State:	");
		saveBtn = new Button("Save");
        updateBtn=new Button("Update");
		
		initWidget(vPanel);

	}

	public Button getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(Button saveBtn) {
		this.saveBtn = saveBtn;
	}


	public Button getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(Button updateBtn) {
		this.updateBtn = updateBtn;
	}
	public TextBox getNameText() {
		return nameText;
	}

	public void setNameText(TextBox nameText) {
		this.nameText = nameText;
	}

	public TextBox getStreetText() {
		return streetText;
	}

	public void setStreetText(TextBox streetText) {
		this.streetText = streetText;
	}

	public TextBox getCityText() {
		return cityText;
	}

	public void setCityText(TextBox cityText) {
		this.cityText = cityText;
	}

	public TextBox getStateText() {
		return stateText;
	}

	public void setStateText(TextBox stateText) {
		this.stateText = stateText;
	}

	public TextBox getCountryText() {
		return countryText;
	}

	public void setCountryText(TextBox countryText) {
		this.countryText = countryText;
	}

	public TextBox getZipText() {
		return zipText;
	}

	public void setZipText(TextBox zipText) {
		this.zipText = zipText;
	}

	public VerticalPanel getvPanel() {
		return vPanel;
	}

	public void setvPanel(VerticalPanel vPanel) {
		this.vPanel = vPanel;
	}

	public void createUI() {

		
		nameText.setText("");
		nameText.setStylePrimaryName("nameBox");
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		vPanel.add(namePanel);

		streetText.setText("");
		streetText.setStylePrimaryName("streetBox");
		streetPanel.add(streetLabel);
		streetPanel.add(streetText);
		vPanel.add(streetPanel);

		cityText.setText("");
		cityText.setStylePrimaryName("cityBox");
		cityPanel.add(cityLabel);
		cityPanel.add(cityText);
		vPanel.add(cityPanel);

		countryText.setText("");
		countryText.setStylePrimaryName("countryBox");
		countryPanel.add(countryLabel);
		countryPanel.add(countryText);
		vPanel.add(countryPanel);

		zipText.setText("");
		zipText.setStylePrimaryName("zipBox");
		zipPanel.add(zipLabel);
		zipPanel.add(zipText);
		vPanel.add(zipPanel);

		stateText.setText("");
		stateText.setStylePrimaryName("stateBox");
		statePanel.add(stateLabel);
		statePanel.add(stateText);
		vPanel.add(statePanel);
		
		saveBtn.setVisible(true);
		
		updateBtn.setVisible(false);
		
        vPanel.add(savePanel);
		savePanel.add(saveBtn);

	}

	public void populateAdd(final AddressSlim address) {
		
		if(address.getId()>0){
		setAddressslim(address);
		nameText.setText("");
		nameText.setStylePrimaryName("nameBox");
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		vPanel.add(namePanel);

		streetText.setText("");
		streetText.setStylePrimaryName("streetBox");
		streetPanel.add(streetLabel);
		streetPanel.add(streetText);
		vPanel.add(streetPanel);

		cityText.setText("");
		cityText.setStylePrimaryName("cityBox");
		cityPanel.add(cityLabel);
		cityPanel.add(cityText);
		vPanel.add(cityPanel);

		countryText.setText("");
		countryText.setStylePrimaryName("countryBox");
		countryPanel.add(countryLabel);
		countryPanel.add(countryText);
		vPanel.add(countryPanel);

		zipText.setText("");
		zipText.setStylePrimaryName("zipBox");
		zipPanel.add(zipLabel);
		zipPanel.add(zipText);
		vPanel.add(zipPanel);

		stateText.setText("");
		stateText.setStylePrimaryName("stateBox");
		statePanel.add(stateLabel);
		statePanel.add(stateText);
		vPanel.add(statePanel);
		
		saveBtn.setVisible(false);
		updateBtn.setVisible(true);
		
        vPanel.add(updatePanel);
		updatePanel.add(updateBtn);

		nameText.setText(address.getName());
		cityText.setText(address.getCity());
		countryText.setText(address.getCountry());
		stateText.setText(address.getState());
		streetText.setText(address.getStreet());
		zipText.setText(address.getZip());
		}
		else{
			createUI();
		}
	}
	

}
