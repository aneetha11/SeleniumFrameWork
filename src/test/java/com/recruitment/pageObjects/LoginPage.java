package com.recruitment.pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.recruitment.testCases.BaseClass;


public class LoginPage extends BaseClass {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	/*@FindBy(how = How.ID, using = "mat-input-0")
	@CacheLookup
	public WebElement txtUserName;

	@FindBy(id = "mat-input-1")
	public WebElement txtPassword;*/

	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement txtUserName;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//*[text()='Login']")
	public WebElement btnLogin;

	@FindBy(xpath = "//mat-icon[@mattooltip='User Profile']")
	public WebElement homeButton;


	public void setUserName(String uname) throws IOException {

		try {
			if (txtUserName.isDisplayed() && txtUserName.isEnabled()) {
				// SeleniumReusablies.highLightElement(userName);
				txtUserName.clear();
				txtUserName.sendKeys(uname);
				logger.info("Entered UserName:"+uname);
				Reporter.log("Entered UserName:"+uname);

			}
		} catch (Exception e) {

			captureScreen(driver,"enterUserName");
			logger.info("Unable to enter username:"+uname);
			Reporter.log("Entered UserName:"+uname);

		}
	}
	
	//Password methof for decoding password
	
		public void setPwd(String pwd) throws IOException {
			
			try {
				if (txtPassword.isDisplayed() && txtPassword.isEnabled()) {
					// SeleniumReusablies.highLightElement(password);
					txtPassword.clear();
					txtPassword.sendKeys(pwd);
					logger.info("Entered Password:"+pwd);
					Reporter.log("Entered Password:"+pwd);
				}
			} catch (Exception e) {
				logger.info("Unable to enter Password"+pwd);
				Reporter.log("Entered Password:"+pwd);
				captureScreen(driver,"enterPassword");
			}
		}

	
	
	
	

	//Password methof for decoding password
	
	public void setPassword(String pwd) throws IOException {
		String password = BaseClass.decodeString(pwd);
		try {
			if (txtPassword.isDisplayed() && txtPassword.isEnabled()) {
				// SeleniumReusablies.highLightElement(password);
				txtPassword.clear();
				txtPassword.sendKeys(password);
				logger.info("Entered Password:"+password);
				Reporter.log("Entered Password:"+password);
			}
		} catch (Exception e) {
			logger.info("Unable to enter Password"+password);
			Reporter.log("Entered Password:"+password);
			captureScreen(driver,"enterPassword");
		}
	}

	public void clickLogin() throws IOException {

		try {
			if (btnLogin.isDisplayed() && btnLogin.isEnabled()) {
				// SeleniumReusablies.highLightElement(loginBtng);
				btnLogin.click();
				logger.info("Clicked on login button");
				Reporter.log("Clicked on login button");

			}
		} catch (Exception e) {
			captureScreen(driver,"enterUserName");
			logger.info("Unable to Click on login button");
			Reporter.log("Unable to Click on login button");

		}

	}


	public void validateLogin() throws IOException {
		try{
			if (homeButton.isDisplayed() && homeButton.isEnabled()) {
				//boolean flagval=homeButton.isDisplayed();
				logger.info("Login test passed");
				Reporter.log("Login test passed");
			}
		}catch(Exception e) {
			logger.info("Login test failed");
			Reporter.log("Login test failed");
			captureScreen(driver,"loginTest");
	
		}

	}



}









