package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.AmountDetails;
import com.nt.beans.IntrAmountCalculator;
import com.nt.editors.AmountDetailsEditor;

public class CustomPropertyEditorTestWithBF3 {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		IntrAmountCalculator calculator=null;
		CustomEditorConfigurer configurer=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get accesss to CustomEditorConfigurer
		configurer=factory.getBean("cec",CustomEditorConfigurer.class);
		configurer.postProcessBeanFactory(factory);
		
		//get bean
		calculator=factory.getBean("iac",IntrAmountCalculator.class);
		//invoke  method
		System.out.println("intr Amount::"+calculator.calcIntrAmount());
	}//main
	
	
}//class
