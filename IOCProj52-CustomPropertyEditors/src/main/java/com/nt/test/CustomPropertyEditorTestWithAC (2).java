package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.IntrAmountCalculator;

public class CustomPropertyEditorTestWithAC {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrAmountCalculator calculator=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		calculator=ctx.getBean("iac",IntrAmountCalculator.class);
		//invoke  method
		System.out.println("intr Amount::"+calculator.calcIntrAmount());
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
