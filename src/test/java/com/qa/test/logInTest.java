package com.qa.test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.DriverManager;
import com.qa.pages.LogInPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class logInTest extends BaseTest {
	
	@Test
	public void test() throws InterruptedException {
		
		LogInPage l1= new LogInPage();
		
		l1.enterUserName("standard_user");
		l1.enterPassword("secret_sauce");
		l1.clickLogin();
		Thread.sleep(3000);
		
		//DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
				//+"scrollable(true)).scrollIntoView(new UiSelector().text(\"Sauce Labs Fleece Jacket\"))"));
		
		
		MobileElement element = (MobileElement)DriverManager.getDriver().findElement(By.id("Sauce Labs Fleece Jacket"));
		
		String elementID = element.getId();
		  HashMap<String, String> scrollObject = new HashMap<String, String>();
		  scrollObject.put("element", elementID);
//		  scrollObject.put("direction", "down");
//		  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//		  scrollObject.put("name", "test-ADD TO CART");
		  scrollObject.put("toVisible", "sdfnjksdnfkld");  //the value here doesn't matter
		  DriverManager.getDriver().executeScript("mobile:scroll", scrollObject);

	}
	
	
}
