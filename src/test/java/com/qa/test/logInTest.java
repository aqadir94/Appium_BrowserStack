package com.qa.test;

import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.DriverManager;
import com.qa.pages.LogInPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class logInTest extends BaseTest {
	
	@Test
	public void test() {
		
		LogInPage l1= new LogInPage();
		
		l1.enterUserName("standard_user");
		l1.enterPassword("secret_sauce");
		l1.clickLogin();
		
		
	}
	
	
}
