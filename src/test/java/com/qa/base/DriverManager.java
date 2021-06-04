package com.qa.base;

import java.net.URL;
import java.util.function.Function;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonParser;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
      
public class DriverManager {

	private static ThreadLocal <AppiumDriver> driver=new ThreadLocal <AppiumDriver>();
	
	
	public static void  setDriver(AppiumDriver driver1) {
		
		
		driver.set(driver1);
		
	}
	
	public static AppiumDriver getDriver(){
		
		return driver.get();
		
	}
	
	
  public static  void initializeDriver(String deviceID, String OS) {
	  String userDir;
	  FileInputStream fis = null;
	  JSONTokener jt;
	  JSONObject deviceData;
	  
	  
	  String userName = System.getenv("BROWSERSTACK_USERNAME");
	  String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	 // String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
	  String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
	  //String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
	  String app = System.getenv("BROWSERSTACK_APP_ID");
	  
	  
	  
	  try {
	   userDir=System.getProperty("user.dir");
	
		 fis=new FileInputStream(userDir+File.separator+"src"+File.separator+"test"+File.separator+"java"+File.separator
					+"resources"+File.separator+"devices.json");
	
	   jt=new JSONTokener(fis);
		 deviceData=new JSONObject(jt).getJSONObject(deviceID);
		 System.out.println(deviceData.get("deviceName"));
      DesiredCapabilities caps = new DesiredCapabilities();
      
      // Set your access credentials
      caps.setCapability("browserstack.user", userName);
      caps.setCapability("browserstack.key", accessKey);
      
      // Set URL of the application under test
      
      
      // Specify device and os_version for testing
      caps.setCapability("device", deviceData.get("deviceName"));
      caps.setCapability("os_version", deviceData.get("osVersion"));
        
      // Set other BrowserStack capabilities
      caps.setCapability("project", "First Java Project");
      caps.setCapability("build", buildName);
      caps.setCapability("name", "first_test");
        
      
      // Initialise the remote Webdriver using BrowserStack remote URL
      // and desired capabilities defined above
       
      if(deviceData.get("os").toString().contains("Android")) {
    	  caps.setCapability("app", app);
			setDriver( new AndroidDriver(
			    new URL("http://hub.browserstack.com/wd/hub"), caps));
		
        
      }
      
      else if (deviceData.get("os").toString().contains("iOS")){
    	  caps.setCapability("app", "bs://558b3741b28f1b69a755386b64eb1343de7d03ee");
    		setDriver( new IOSDriver(
    			    new URL("http://hub.browserstack.com/wd/hub"), caps));
    	  
      }
      
      else {
    	  
    	  System.out.println("Invalid OS specified / not supported");
    	  
      }
   
	  }
	  
	  catch(Exception e) {
		  
		 e.printStackTrace(); 
	  }
	  
	  finally {
		  
		  try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
    	
        
        
      // Invoke driver.quit() after the test is done to indicate that the test is completed.
      
    
    }
      
  }