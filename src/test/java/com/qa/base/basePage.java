package com.qa.base;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class basePage {
	
	protected WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(),10);
	
	public basePage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this );
		
		
		
	}
	
}
