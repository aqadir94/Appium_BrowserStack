package com.qa.test;

import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.DriverManager;
import com.qa.pages.LogInPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

public class logInTest extends BaseTest {
	
	@Test
	public void test() throws InterruptedException {
		
		LogInPage l1= new LogInPage();
		
		l1.enterUserName("standard_user");
		l1.enterPassword("secret_sauce");
		l1.clickLogin();
		Thread.sleep(3000);
		
		DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
				+"scrollable(true)).scrollIntoView(new UiSelector().text(\"Sauce Labs Fleece Jacket\"))"));
		
		System.out.println(DriverManager.getDriver().toString());
	}
	
	
}
