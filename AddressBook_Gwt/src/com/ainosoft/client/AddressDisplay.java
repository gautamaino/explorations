package com.ainosoft.client;

import com.ainosoft.client.event.AddressBookEvent;
import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class AddressDisplay extends HorizontalPanel {
	private Label streetLb;
	private Label countryLb;
	private Label cityLb;
	private Label stateLb;
	private Label zipLb;
	private Anchor hp;
	private AddressBookSlim addressBook;

	public AddressDisplay(AddressBookSlim addressBook) {
		this.addressBook = addressBook;
	}

	public void createUi() {
		streetLb = new Label(addressBook.getStreet());
		streetLb.setStylePrimaryName("border");
		add(streetLb);

		countryLb = new Label(addressBook.getCountry());
		countryLb.setStylePrimaryName("border");
		add(countryLb);

		cityLb = new Label(addressBook.getCity());
		cityLb.setStylePrimaryName("border");
		add(cityLb);

		stateLb = new Label(addressBook.getState());
		stateLb.setStylePrimaryName("border");
		add(stateLb);

		zipLb = new Label(addressBook.getZip());
		zipLb.setStylePrimaryName("border");
		add(zipLb);

		hp = new Anchor("Edit");
		hp.setStylePrimaryName("border");
		add(hp);
		hp.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				AddressBookEvent abEvent = new AddressBookEvent(
						AddressBookEvent.EDITADDRESS, addressBook, null);
				AddressBook_Gwt.EVENTBUS.fireEvent(abEvent);
			}
		});
	}

	public Label getStreetLb() {
		return streetLb;
	}

	public void setStreetLb(Label streetLb) {
		this.streetLb = streetLb;
	}

	public Label getCountryLb() {
		return countryLb;
	}

	public void setCountryLb(Label countryLb) {
		this.countryLb = countryLb;
	}

	public Label getCityLb() {
		return cityLb;
	}

	public void setCityLb(Label cityLb) {
		this.cityLb = cityLb;
	}

	public Label getStateLb() {
		return stateLb;
	}

	public void setStateLb(Label stateLb) {
		this.stateLb = stateLb;
	}

	public Label getZipLb() {
		return zipLb;
	}

	public void setZipLb(Label zipLb) {
		this.zipLb = zipLb;
	}

	public Anchor getHp() {
		return hp;
	}

	public void setHp(Anchor hp) {
		this.hp = hp;
	}
}