package com.recruitment.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.recruitment.reuseableMethods.ClickClass;
import com.recruitment.reuseableMethods.DropdownClass;
import com.recruitment.reuseableMethods.SendKeysClass;
import com.recruitment.reuseableMethods.WaitUntillVisible;
import com.recruitment.testCases.BaseClass;

public class DetailRequestedPage extends BaseClass {

	static WebDriver ldriver;

	public DetailRequestedPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "//div[contains(text(),' Candidates')]")	
	public static WebElement tabCandidate;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	public WebElement txtboxSearchBar;

	@FindBy(xpath = "(//span[text()='Go'])[2]")
	public WebElement btnGo;

	@FindBy(xpath = "//table[@role='table']//tr[1]//td[2]")
	public static WebElement ColumnEmailID;

	@FindBy(xpath = "//table[@role='table']//tr[1]//td[10]//mat-icon")
	public static WebElement actionIcon;

	@FindBy(xpath = "//button[@role='menuitem']")
	public static List<WebElement> actionItems;

	@FindBy(xpath = "//span[text()='Sent']")
	public static WebElement btnSent;

	@FindBy(xpath ="//span[text()='Ok']")
	public static WebElement btnOk;

	@FindBy(xpath ="//span[text()='Re-send']")
	public static WebElement btnResend;

	@FindBy(xpath ="//span[text()='Reject']")
	public static WebElement btnReject;

	@FindBy(xpath = "//div[contains(text(),' Details Yet To Be Requested')]")
	public static WebElement stageDetailsRequested;

	@FindBy(xpath = "//div[contains(text(),' Details Yet To Be Captured')]")	
	public static WebElement stageDetailscaptured;

	@FindBy(xpath = "//h1[contains(text(),'Confirmation')]")	
	public static WebElement popuptxtConfirmation;

	//Validate using contirmation Message

	//validating searched record found or not

	public static void confirmation() throws IOException {
		WaitUntillVisible.explict_wait_till_visibilityOf(popuptxtConfirmation);
		String actualvalueEmail=popuptxtConfirmation.getText();

		if(actualvalueEmail.contains("Confirmation"))
		{
			Assert.assertTrue(true);
			logger.info("Confirmation Pop up Displayed"+actualvalueEmail);
			Reporter.log("Confirmation Pop up Displayed"+actualvalueEmail);

		}
		else
		{
			logger.info("Confirmation Pop up NOT Displayed"+actualvalueEmail);
			Reporter.log("Confirmation Pop up NOT Displayed"+actualvalueEmail);
			captureScreen(driver,"ConfirmationPopUp");
			Assert.assertTrue(false);
		}

	}

	//Automate Resource Dropdown	

	public static void dropdownAction(String actionOption) throws InterruptedException, IOException {

		String option=actionOption;  
		switch(option){    

		case "Sent Test Link": 

			DropdownClass.dropdown(actionIcon, actionItems, option, "Action Items");
			Thread.sleep(2000);
			confirmation();
			Thread.sleep(2000);
			ClickClass.clickButton(btnSent, "SentButton");

			break;    

		case "Test not required": 
			DropdownClass.dropdown(actionIcon, actionItems, option, "Action Items");
			Thread.sleep(2000);
			confirmation();
			Thread.sleep(2000);
			ClickClass.clickButton(btnOk, "btnOk");
			break;     

		case "Re-Send Form": 
			DropdownClass.dropdown(actionIcon, actionItems, option, "Action Items");
			Thread.sleep(2000);
			confirmation();
			Thread.sleep(2000);
			ClickClass.clickButton(btnResend, "btnResend");
			break;  

		case "Reject Candidate": 
			DropdownClass.dropdown(actionIcon, actionItems, option, "Action Items");
			Thread.sleep(2000);
			confirmation();
			Thread.sleep(2000);
			ClickClass.clickButton(btnReject, "btnReject");
			break; 
	 

		default: 

			Reporter.log("Not able to Automate Details Requested action Items");
			logger.info("Not able to Automate Details Requested action Items");

			break;  
		}    

	}   



	//Click on Candidates tab and then Details to be Requested Stage

	public void clickDetailsRequested() throws IOException, InterruptedException {

		//Click on candidate
		ClickClass.clickButton(tabCandidate, "tabCandidate");
		Thread.sleep(2000);
		ClickClass.clickButton(stageDetailsRequested, "stageDetailsRequested");

	}

	//Enter the candidate Email Id in search bar

	public void setSearchBox(String searchValue) throws IOException {
		try {

			WaitUntillVisible.explict_wait_till_visibilityOf(txtboxSearchBar);
			if (txtboxSearchBar.isDisplayed() && txtboxSearchBar.isEnabled()) {
				// SeleniumReusablies.highLightElement(userName);
				txtboxSearchBar.clear();
				txtboxSearchBar.sendKeys(searchValue);
				ClickClass.clickButton(btnGo, "btnGo");
				
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			captureScreen(driver,"searchValue");
			logger.info("Unable to enter searchValue:"+searchValue);
			Reporter.log("Unable to enter searchValue:"+searchValue);
			Assert.assertTrue(false);
		}
	}

	//validating searched record found or not

	public static void foundEmailID(String searchValue) throws IOException {
		try {
		WaitUntillVisible.explict_wait_till_visibilityOf(ColumnEmailID);
		String actualvalueEmail=ColumnEmailID.getText();

		if(actualvalueEmail.contains(searchValue))
		{
			Assert.assertTrue(true);
			logger.info("Searched EMail ID Found"+searchValue);
			Reporter.log("Searched EMail ID Found"+searchValue);

		}} catch (Exception e) {
			logger.info("Searched EMail ID NOT FOUND"+searchValue);
			Reporter.log("Searched EMail ID NOT FOUND:"+searchValue);
			captureScreen(driver,"SearchedEMailID");
			Assert.assertTrue(false);
		}
		

	}

	//Automate action Icon by selecting sent test link/resend Email by getting data from from Excel

	public static void dropdownActionItems(String value,String methodName) throws InterruptedException, IOException {

		DropdownClass.dropdown(actionIcon, actionItems, value, methodName);
		Thread.sleep(2000);
		ClickClass.clickButton(btnSent, "SentButton");

	}



	//Validate Details to be requested Stage-Profile should move to details to be captured stage

	public static void clickDetailCapturedStage(String searchValue) throws IOException{

		ClickClass.clickButton(stageDetailscaptured, "stageDetailscaptured");
		foundEmailID(searchValue);

	}

}