package com.recruitment.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.recruitment.reuseableMethods.ClickClass;
import com.recruitment.reuseableMethods.WaitUntillVisible;
import com.recruitment.testCases.BaseClass;

public class DetailsCapturedPage  extends BaseClass {
	static WebDriver ldriver;

	public DetailsCapturedPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[contains(text(),' Candidates')]")	
	public static WebElement tabCandidate;

	@FindBy(xpath = "//div[contains(text(),' Details Yet To Be Captured')]")	
	public static WebElement stageDetailscaptured;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	public WebElement txtboxSearchBar;

	@FindBy(xpath = "(//span[text()='Go'])[2]")
	public WebElement btnGo;

	@FindBy(xpath = "//table[@role='table']//tr[1]//td[2]")
	public static WebElement ColumnEmailID;

	//Click on Candidates tab 
	public void clickcandidate() throws IOException, InterruptedException {
		//Click on candidate
		ClickClass.clickButton(tabCandidate, "tabCandidate");
	}

	//Clicked on details to be Captured Stage

	public static void clickDetailCapturedStage() throws IOException, InterruptedException{
		Thread.sleep(2000);
		ClickClass.clickButton(stageDetailscaptured, "stageDetailscaptured");

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

				WebElement closeIcon=driver.findElement(By.xpath("(//mat-icon[text()='close'])[2]"));					
				WaitUntillVisible.explict_wait_till_visibilityOf(closeIcon);
			}
		} catch (Exception e) {
			captureScreen(driver,"searchValue");
			logger.info("Unable to enter searchValue or click on emp Name:"+searchValue);
			Reporter.log("Unable to enter searchValue or click on emp Name:"+searchValue);
			Assert.assertTrue(false);
		}

		try {
			WebElement empName=driver.findElement(By.xpath("//table[@role='table']//tr[1]//td[2]//preceding-sibling::td/div"));
			if (empName.isDisplayed()) {
				empName.click();			

				logger.info("Entered searchValue and clicked on Employee Name:"+searchValue);
				Reporter.log("Entered searchValue and clicked on Employee Name:"+searchValue);
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			captureScreen(driver,"searchValue");
			logger.info("Unable to enter searchValue or click on emp Name:"+searchValue);
			Reporter.log("Unable to enter searchValue or click on emp Name:"+searchValue);
			Assert.assertTrue(false);
		}
	}



	//validating searched record found or not

	public static void foundEmailID(String searchValue) throws IOException, InterruptedException {
		Thread.sleep(4000);


		//div[text()='No data to display']
		try {
			if (ColumnEmailID.isDisplayed()) {


				String actualvalueEmail=ColumnEmailID.getText();
				System.out.println("actualvalueEmail:"+actualvalueEmail);
				if(actualvalueEmail.contains(searchValue))
				{
					System.out.println("searchValue:"+searchValue);
					//Assert.assertTrue(true);
					//Click on Name
					Thread.sleep(2000);
					WebElement empName=driver.findElement(By.xpath("//table[@role='table']//tr[1]//td[2]//preceding-sibling::td/div"));
					//WaitUntillVisible.explict_wait_till_visibilityOf(empName);
					empName.click();			
					logger.info("Searched EMail ID Found and clicked on name"+searchValue);
					Reporter.log("Searched EMail ID Found and clicked on name"+searchValue);

				}
				else
				{
					logger.info("Searched EMail ID NOT FOUND"+searchValue);
					Reporter.log("earched EMail ID NOT FOUND:"+searchValue);
					captureScreen(driver,"SearchedEMailID");
					Assert.assertTrue(false);
				}


			}
		} catch (Exception e) {
			captureScreen(driver,"No data found");
			logger.info("No data Found"+searchValue);
			Reporter.log("No data found"+searchValue);
			Assert.assertTrue(false);
		}

	}




}
