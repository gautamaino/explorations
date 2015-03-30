package com.ainosoft.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddressBookEvent extends GwtEvent<AddressBookEventHandler> {

	protected int eventType;
	protected Object eventData = null;

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public Object getEventData() {
		return eventData;
	}

	public void setEventData(Object eventData) {
		this.eventData = eventData;
	}

	public Object getEventSource() {
		return eventSource;
	}

	public void setEventSource(Object eventSource) {
		this.eventSource = eventSource;
	}

	protected Object eventSource = null;
	public static Type<AddressBookEventHandler> TYPE = new Type<AddressBookEventHandler>();

	public static final int ADDADDRESS = 1;
	public static final int VIEWADDRESS = 2;
	public static final int EDITADDRESS = 3;

	public AddressBookEvent() {

	}

	public AddressBookEvent(int type, Object data, Object eventSource) {
		this.eventType = type;
		this.eventData = data;
		this.eventSource = eventSource;

	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddressBookEventHandler> getAssociatedType() {

		return TYPE;
	}

	@Override
	protected void dispatch(AddressBookEventHandler handler) {

		handler.onAddressBookEvent(this);
	}
}