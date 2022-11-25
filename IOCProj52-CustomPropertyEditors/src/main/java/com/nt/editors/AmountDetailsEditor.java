package com.nt.editors;

import java.beans.PropertyEditorSupport;

import com.nt.beans.AmountDetails;

public class AmountDetailsEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int amt=0,rate=0,time=0;
		AmountDetails details=null;
		amt=Integer.parseInt(text.substring(0,text.indexOf(',')));
		time=Integer.parseInt(text.substring(text.indexOf(',')+1,text.lastIndexOf(',')));
		rate=Integer.parseInt(text.substring(text.lastIndexOf(',')+1,text.length()));
		//create Dependent class obj
		details=new AmountDetails(amt, rate, time);
		//set Dependent class obj to target class obj property
		setValue(details);
	}
	
}
