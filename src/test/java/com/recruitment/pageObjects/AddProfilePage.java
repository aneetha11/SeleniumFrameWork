package com.recruitment.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.recruitment.reuseableMethods.ClickClass;
import com.recruitment.reuseableMethods.DropdownClass;
import com.recruitment.reuseableMethods.Scroll_VisiblilityofEle;
import com.recruitment.reuseableMethods.SendKeysClass;
import com.recruitment.reuseableMethods.ValidateClass;
import com.recruitment.testCases.BaseClass;

public class AddProfilePage extends BaseClass {

	static WebDriver ldriver;

	public AddProfilePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}


	@FindBy(xpath = "(//span[text()='Add Profile'])[2]")
	public WebElement btnAddProfile;

	@FindBy(xpath = "//input[@formcontrolname='first_name']")
	public WebElement txtFirstName;

	@FindBy(xpath = "//input[@formcontrolname='middle_name']")
	public WebElement txtMiddleName;

	@FindBy(xpath = "//input[@formcontrolname='last_name']")
	public WebElement txtLastName;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	public WebElement txtEmailID;

	@FindBy(xpath = "//input[@formcontrolname='mobile_number']")
	public WebElement txtMobileNumber;

	//@FindBy(xpath = "//mat-select[@id='mat-select-4']")
	//@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c91-19']")
	@FindBy(xpath = "//mat-select[@placeholder='Domain']")
	public static WebElement dropdownDomain;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane']/div/div/mat-option/span")
	public static List<WebElement> dropdownDomainItems;

	@FindBy(xpath = "//mat-select[@placeholder='Role']")
	//@FindBy(xpath = "//div[@class='mat-select-arrow ng-tns-c91-21']")
	public static WebElement dropdownRole;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane']/div/div/mat-optgroup/mat-option/span")
	public static List<WebElement> dropdownRoleItems;

	@FindBy(xpath = "//mat-select[@placeholder='Select from Options']")
	//@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c91-25']")
	public static WebElement dropdownselectFormToEmail;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane']/div/div/mat-option/span")
	public static List<WebElement> dropdownselectFormToEmailItems;


	//@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c91-27']")
	//@FindBy(xpath = "//mat-select[@placeholder='Resume Source']]//following-sibling::mat-form-field/div/div/div[3]/mat-select/div/div[2]")
	@FindBy(xpath = "//mat-select[@placeholder='Select Recruiter name']")
	public static WebElement dropdownRecruiterName;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane']/div/div/mat-option/span")
	public static List<WebElement> dropdownRecruiterNameItems;


	@FindBy(xpath = "//span[@class='mat-checkbox-label']")
	public static WebElement chkboxOtherSource;

	@FindBy(xpath = "//input[@placeholder='Resume Source']")
	public static WebElement txtResumeSource;


	@FindBy(xpath = "//span[text()='Resume Source']")
	//@FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c91-23']")			
	public static WebElement dropdownResumeSourced;

	@FindBy(xpath = "//div[@id='cdk-overlay-3']/div/div/mat-option/span")
	public static List<WebElement> dropdownResumeSourceItems;

	@FindBy(xpath = "//input[@formcontrolname='other_source_data']")
	public static WebElement txtReferalValue;

	@FindBy(xpath ="//span[text()='Submit']")
	public static WebElement btnSubmit;

	@FindBy(xpath ="//span[text()='Ok']")
	public static WebElement btnSubmitOk;

	@FindBy(xpath = "//div[text()='Profile has been added successfully']")
	public static WebElement txtValidationMsg;


	@FindBy(xpath ="//span[text()='Ok']")
	public static WebElement btnOK;

	@FindBy(xpath ="//span[text()='Create New Candidate Form']")
	public static WebElement btnNewCandidate;

	@FindBy(xpath = "//span[text()='Update Existed Form']")
	public static WebElement btnUpdateExisting;

	@FindBy(xpath = "//strong[text()='Name']")
	public static WebElement gridtxtName;


	//Validate Addprofile

	public static void validateAddprofile()  {
	
		try {
			if(gridtxtName.isDisplayed()) { 
			logger.info("Successfully Validated:Addprofile");
			Reporter.log("Successfully Validated:Addprofile ");
			}    
		} catch (Exception e) {
			logger.info("Unsuccessful:Addprofile validation Failed");
			Reporter.log("Unsuccessful:Addprofile validation Failed");
			
		}
				
	}

	//Automate submit
	//Code for submit and ok
	public static void clickSubmitOk() throws InterruptedException, IOException {

		ClickClass.clickButton(btnSubmit, "Submit");
		Thread.sleep(2000);
		ClickClass.clickButton(btnSubmitOk, "Ok");
	}


	public static void clickOkCreateUpdate() throws InterruptedException, IOException {
		try {
			if(btnOK.isDisplayed()) { 
				Thread.sleep(2000);
				System.out.println("This is a New Profile: " +btnOK.isDisplayed()); 
				btnOK.click();
				//Thread.sleep(2000);

				logger.info("Automated This is a New Profile: ");
				Reporter.log("Automated This is a New Profile: ");
			}    
		} catch (Exception e) {
			Thread.sleep(2000);
			//	btnNewCandidate.click();
			btnUpdateExisting.click();
			Thread.sleep(1000);
			btnOK.click();
			//	Thread.sleep(3000);
			logger.info("It is a duplicate profile :clicked on Create New Profile/Update existing profile:");
			Reporter.log("It is a duplicate profile :clicked on Create New Profile/Update existing profile:");
			//	Assert.assertTrue(false);
		}
	} 

	//Automate Resource Dropdown	

	public static void dropdownResumeSource(String rsOption,String rsDdownVal,String rsReferalVal,String methodName) throws InterruptedException, IOException {

		String option=rsOption;  
		switch(option){    

		case "Other Source": 

			ClickClass.clickButton(chkboxOtherSource, "Other Source");
			SendKeysClass.sendKeysMethod(txtResumeSource, rsReferalVal, "Source Name");
			break;    

		case "Referral option": 
			System.out.println("SourceName:"+rsDdownVal);
			System.out.println("SourceName:"+rsReferalVal);
			DropdownClass.dropdown(dropdownResumeSourced, dropdownDomainItems, rsDdownVal, methodName); 
			SendKeysClass.sendKeysMethod(txtReferalValue, rsReferalVal, "Referral Name");		
			break;  

		case "Resume Source": 
			DropdownClass.dropdown(dropdownResumeSourced, dropdownDomainItems, rsDdownVal, methodName); 
			break;   

		default: 

			Reporter.log("Not able to Automate Sourced Resume");
			logger.info("Not able to Automate Sourced Resume");

			break;  
		}    

	}   

	//Click on Add Profile

	public void clickAddProfile() throws IOException {

		try {
			Thread.sleep(5000);
			if (btnAddProfile.isDisplayed() && btnAddProfile.isEnabled()) {
				// SeleniumReusablies.highLightElement(loginBtng);
				btnAddProfile.click();
				logger.info("Clicked on Addprofile button");
				Reporter.log("Clicked on Addprofile button");

			}
		} catch (Exception e) {
			captureScreen(driver,"btnAddProfile");
			logger.info("Unable to Click on Addprofile button");
			Reporter.log("Unable to Click on Addprofile button");
			//Assert.assertTrue(false);

		}

	}

	//Enter first name

	public void setFirstName(String fname) throws IOException {

		try {
			if (txtFirstName.isDisplayed() && txtFirstName.isEnabled()) {
				// SeleniumReusablies.highLightElement(userName);
				txtFirstName.clear();
				txtFirstName.sendKeys(fname);
				logger.info("Entered FirstName:"+fname);
				Reporter.log("Entered FirstName:"+fname);

			}
		} catch (Exception e) {

			captureScreen(driver,"enterFirstName");
			logger.info("Unable to enter FirstName:"+fname);
			Reporter.log("Unable to enter FirstName:"+fname);
			//	Assert.assertTrue(false);

		}
	}


	//Enter middle name

	public void setMiddleName(String mname) throws IOException {

		try {
			if (txtMiddleName.isDisplayed() && txtMiddleName.isEnabled()) {
				// SeleniumReusablies.highLightElement(userName);
				txtMiddleName.clear();
				txtMiddleName.sendKeys(mname);
				logger.info("Entered MiddleName:"+mname);
				Reporter.log("Entered MiddleName:"+mname);

			}
		} catch (Exception e) {

			captureScreen(driver,"enterMiddleName");
			logger.info("Unable to enter MiddleName:"+mname);
			Reporter.log("Unable to enter MiddleName:"+mname);
			//	Assert.assertTrue(false);
		}
	}
	//Enter last Name

	public void setLastName(String lname) throws IOException {
		try {
			if (txtLastName.isDisplayed() && txtLastName.isEnabled()) {
				// SeleniumReusablies.highLightElement(userName);
				txtLastName.clear();
				txtLastName.sendKeys(lname);
				logger.info("Entered LastName:"+lname);
				Reporter.log("Entered LastName:"+lname);

			}
		} catch (Exception e) {

			captureScreen(driver,"enterLastName");
			logger.info("Unable to enter LastName:"+lname);
			Reporter.log("Unable to enter LastName:"+lname);
			//	Assert.assertTrue(false);

		}
	}

	//Enter Email ID

	public void setEmailId(String eid) throws IOException {
		try {
			if (txtEmailID.isDisplayed() && txtEmailID.isEnabled()) {
				// SeleniumReusablies.highLightElement(userName);
				txtEmailID.clear();
				txtEmailID.sendKeys(eid);
				logger.info("Entered EmailID:"+eid);
				Reporter.log("Entered EmailID:"+eid);
			}
		} catch (Exception e) {
			captureScreen(driver,"enterEmailID");
			logger.info("Unable to enter txtEmailID:"+eid);
			Reporter.log("Unable to enter txtEmailID:"+eid);
			//	Assert.assertTrue(false);
		}
	}

	//Enter Mobile Number
	public void setMobileno(String mno) throws IOException {
		try {
			if (txtMobileNumber.isDisplayed() && txtMobileNumber.isEnabled()) {
				// SeleniumReusablies.highLightElement(userName);
				txtMobileNumber.clear();
				txtMobileNumber.sendKeys(mno);
				logger.info("Entered Mobile Number:"+mno);
				Reporter.log("Entered Mobile Number:"+mno);

			}
		} catch (Exception e) {

			captureScreen(driver,"enterMobileNumber");
			logger.info("Unable to enter Mobile Number:"+mno);
			Reporter.log("Unable to enter Mobile Number:"+mno);
			//	Assert.assertTrue(false);

		}
	}
	//Code for Domain dropdown
	public static void dropdownDomain(String value,String methodName) throws InterruptedException, IOException {

		DropdownClass.dropdown(dropdownDomain, dropdownDomainItems, value, methodName);

	}

	//Code for Role dropdown
	public static void dropdownRole(String value,String methodName) throws InterruptedException, IOException {

		DropdownClass.dropdown(dropdownRole, dropdownRoleItems, value, methodName);

	}

	//Code for Select form to email dropdown
	public static void dropdownselectFormToEmail(String value,String methodName) throws InterruptedException, IOException {

		DropdownClass.dropdown(dropdownselectFormToEmail, dropdownselectFormToEmailItems, value, methodName);

	}

	//Code for RecruiterName dropdown
	public static void dropdownRecruiterName(String value,String methodName) throws InterruptedException, IOException {
		System.out.println("Recruiter name from pagerobj:"+value);
		Scroll_VisiblilityofEle.KeysPgDown(dropdownRecruiterName, methodName);
		DropdownClass.dropdownJavascript(dropdownRecruiterName, dropdownRecruiterNameItems, value, methodName);

	}


}