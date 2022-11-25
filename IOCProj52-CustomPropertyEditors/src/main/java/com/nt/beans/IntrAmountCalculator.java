package com.nt.beans;

public class IntrAmountCalculator {
	private AmountDetails details;
	
	public IntrAmountCalculator(AmountDetails details) {
		this.details=details;
	}
	
	public float calcIntrAmount(){
		return  (details.getpAmt()*details.getRate()*details.getTime())/100.0f;
	}

}
