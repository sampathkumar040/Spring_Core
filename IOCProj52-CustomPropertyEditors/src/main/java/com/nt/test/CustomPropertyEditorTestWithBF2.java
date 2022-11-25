package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.AmountDetails;
import com.nt.beans.IntrAmountCalculator;
import com.nt.editors.AmountDetailsEditor;

public class CustomPropertyEditorTestWithBF2 {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		IntrAmountCalculator calculator=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//add PropertyEditorRegistar to IOC Container
		factory.addPropertyEditorRegistrar(registry->{
			registry.registerCustomEditor(AmountDetails.class,new AmountDetailsEditor());
		});
		//get bean
		calculator=factory.getBean("iac",IntrAmountCalculator.class);
		//invoke  method
		System.out.println("intr Amount::"+calculator.calcIntrAmount());
	}//main
	
	
}//class
