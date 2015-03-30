package com.ainosoft.server;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ainosoft.shared.AddressBookSlim;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	public boolean AddAddress(AddressBookSlim addressslim)
			throws IllegalArgumentException {

		AddressDao addressDao = new AddressDao();
		addressDao.saveAddress(addressslim);
		return true;
	}

	@Override
	public ArrayList<AddressBookSlim> ViewAddress() {
		AddressDao addressDao = new AddressDao();

		ArrayList<AddressBookSlim> aSlim = addressDao.loadAddressBook();
		return aSlim;
	}

	@Override
	public void updateAddress(AddressBookSlim addressSlim)
			throws IllegalArgumentException {

		AddressDao addressDao = new AddressDao();
		
		addressDao.updateAddress(addressSlim);

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		  AddressDao addressDao = new AddressDao();
		  Document document = new Document();
		    try{
		    	 
		        response.setContentType("application/pdf");
		        PdfWriter.getInstance(document, response.getOutputStream());
		        document.open();
		      
		        document.add(new Paragraph("Helloooooo Pratik"));
		        document.add(new Paragraph("Custom pdf is generated"));

		       document.add(new Paragraph("Country   "+"State   "+"City   "+"City  "+"Street   "+"Zip  "));        
		ArrayList<AddressBookSlim> aSlim = addressDao.loadAddressBook();
				for(AddressBookSlim address : aSlim){
					 document.add(new Paragraph(address.getCountry()+"   "+address.getState()+"   "+address.getCity()+"   "+address.getStreet()+"   "+address.getZip()));
					
				}
		        
		        document.close();
		    }catch(Exception e){
		        e.printStackTrace();
		    }
		   
		   
		 
		    
	}

}
