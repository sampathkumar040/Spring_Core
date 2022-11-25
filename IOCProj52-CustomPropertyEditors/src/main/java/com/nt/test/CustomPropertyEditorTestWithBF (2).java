package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.AmountDetails;
import com.nt.beans.IntrAmountCalculator;
import com.nt.editors.AmountDetailsEditor;

public class CustomPropertyEditorTestWithBF {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		IntrAmountCalculator calculator=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//add PropertyEditorRegistar to IOC Container
		factory.addPropertyEditorRegistrar(new MyPERegistar());
		//get bean
		calculator=factory.getBean("iac",IntrAmountCalculator.class);
		//invoke  method
		System.out.println("intr Amount::"+calculator.calcIntrAmount());
	}
	
	//Custom PropertyEditorRegistar that gives access PropertyEditorRegistry
	private static class MyPERegistar implements PropertyEditorRegistrar{

		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
		  registry.registerCustomEditor(AmountDetails.class,new AmountDetailsEditor());
		}//method
		
	}//class
}//class
