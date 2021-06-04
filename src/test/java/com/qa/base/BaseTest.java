package com.qa.base;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseTest {
	
	protected HashMap<String,String> Strings=new HashMap<String,String>();
	JSONObject json;
	@Parameters({"deviceID"})
	@BeforeTest
	public void beforeTest(String deviceID) {
		
		DriverManager.initializeDriver(deviceID);
		
		
	
		
	}
	
	@AfterTest(alwaysRun=true)
	public void AfterTest() {
		
		DriverManager.getDriver().quit();
		
	}
}
