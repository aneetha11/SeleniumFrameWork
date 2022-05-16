package com.recruitment.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.recruitment.reuseableMethods.ClickClass;
import com.recruitment.reuseableMethods.SendKeysClass;
import com.recruitment.testCases.BaseClass;
import com.recruitment.utilities.Log;

public class LoginPg extends BaseClass{
	
	WebDriver ldriver;

	public LoginPg(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="wpName1")
	private WebElement userName;
	
	@FindBy(id="wpPassword1")
	private WebElement password;

	@FindBy(id="wpLoginAttempt")
	private WebElement logInBtn;
	
	@FindBy(xpath ="//span[text()='Log out']")
	private WebElement logoutBtn;
	
	public void login(String uname, String pwd) throws IOException  {
	//	action.scrollByVisibilityOfElement(getDriver(), userName);
		SendKeysClass.sendKeysMethod(userName, uname, "userName");
	//	userName.sendKeys(uname);
	//	Log.info("Entered Username");
		SendKeysClass.sendKeysMethod(password, pwd, "password");
	//	password.sendKeys(pwd);
	//	Log.info("Entered Password");
	//	signInBtn.click();
		ClickClass.clickButton(logInBtn, "logInBtn");
		
	}
	
	public void setUserName(String uname)
	{		
		userName.sendKeys(uname);
		Log.info("Entered Username");
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
		Log.info("Entered Password");
	}
	
	
	public void logOut() throws IOException
	{
		//logoutBtn.click();
		
		ClickClass.clickButton(logoutBtn, "logoutBtn");
		Log.info("Clicked on LogOut");
	}	
	
	
	
	
	
}
