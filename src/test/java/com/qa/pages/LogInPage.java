package com.qa.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.basePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LogInPage extends basePage{
	
	
	@AndroidFindBy(accessibility="test-Username")
	@iOSXCUITFindBy(accessibility="test-Username")
	MobileElement txtfld_UserName;
	
	
	@AndroidFindBy(accessibility="test-Password")
	@iOSXCUITFindBy(accessibility="test-Password")
	MobileElement txtfld_Password;
	
	@AndroidFindBy(accessibility="test-LOGIN")
	@iOSXCUITFindBy(accessibility="test-LOGIN")
	MobileElement btn_LogIn;
	
	
	
	public LogInPage enterUserName(String userName) {
		
	 wait.until(ExpectedConditions.visibilityOf(txtfld_UserName));
	 txtfld_UserName.clear();
	 txtfld_UserName.sendKeys(userName);
		
		return this;
	}
	
	
	public LogInPage enterPassword(String password) {
		
		 wait.until(ExpectedConditions.visibilityOf(txtfld_Password));
		 txtfld_Password.clear();
		 txtfld_Password.sendKeys(password);
			
			return this;
		}
	
	
	public void clickLogin() {
		
		 wait.until(ExpectedConditions.visibilityOf(btn_LogIn));
		 btn_LogIn.click();
			
			
		}
	

}
