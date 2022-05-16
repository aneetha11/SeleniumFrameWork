package com.recruitment.testCases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.recruitment.pageObjects.BasicDetailsPage;
import com.recruitment.pageObjects.DetailsCapturedPage;

public class TC_BasicDetails_001 extends BaseClass  {
	@Test
	public void BasicDetails() throws IOException, InterruptedException, ParseException 
	{


		BasicDetailsPage basicDet=new BasicDetailsPage(driver);
/*
		//Clicked on Candidate Tab

		BasicDetailsPage.clickcandidate();
		logger.info("Automated :candidate Tab");
		Reporter.log("Automated :candidate Tab");

		//Clicked on Details Captured Stage

		BasicDetailsPage.clickDetailCapturedStage();
		logger.info("Automated :Click on Details Captured Stage");
		Reporter.log("Automated :Click on Details Captured Stage");

		//Clicked on candidate Profile

		BasicDetailsPage.clickname();
		logger.info("Automated :Click on candidate Profile");
		Reporter.log("Automated :Click on candidate Profile");
*/
		//Clicked on candidate Profile

		BasicDetailsPage.switchWindow();
		logger.info("Automated :Switch to Basic details Tab");
		Reporter.log("Automated :Switch to Basic details Tab");

		
		//Automate Basic details-Applied Earlier

		BasicDetailsPage.clickApplyEarlierNO();
		logger.info("Automated :Click on Radio Button Applied Earlier");
		Reporter.log("Automated :Click on Radio Button Applied Earlier");
		
		

		
		
		//Automate Basic details-Know Anyone in Merilytics

		BasicDetailsPage.clickKnowAnyone();
		logger.info("Automated :Click on Radio Button Know Anyone");
		Reporter.log("Automated :Click on Radio Button Know Anyone");

		//Automate Basic details-Experience

		BasicDetailsPage.clickExpYes();
		logger.info("Automated :Click on Radio button Experience Yes and enter exp");
		Reporter.log("Automated :Click on Radio button Experience Yes and enter exp");

		/*
		
		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.scrollTillCompany();
		logger.info("Automated :Scroll till Visibility Of Compay");
		Reporter.log("Automated :Scroll till Visibility Of Compay");

		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectCompany();
		logger.info("Automated :Comapany Dropdown");
		Reporter.log("Automated :Comapany Dropdown");


		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectDesignation();
		logger.info("Automated :Designation Dropdown");
		Reporter.log("Automated :Designation Dropdown");

		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectCountry();
		logger.info("Automated :Country DropDown");
		Reporter.log("Automated :Country DropDown");


		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectState();
		logger.info("Automated :State DropDown");
		Reporter.log("Automated :State DropDown");


		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectCity();
		logger.info("Automated :City Dropdown");
		Reporter.log("Automated :City Dropdown");
		 

		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectCollege();
		logger.info("Automated :College Dropdown");
		Reporter.log("Automated :College Dropdown");


		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectBranch();
		logger.info("Automated :Branch Dropdown");
		Reporter.log("Automated :Branch Dropdown");


		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectCollegeStrDate();
		logger.info("Automated :College Start Date");
		Reporter.log("Automated :College Start Date");


		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectCollegeEndDate();
		logger.info("Automated :College EndDate");
		Reporter.log("Automated :College EndDate");

		//Automate Scroll till visibility of Company Name

		BasicDetailsPage.selectCollegeGrade();
		logger.info("Automated :Grade/Percentage Dropdown/Fields");
		Reporter.log("Automated :Grade/Percentage Dropdown/Fields");

*/


	}
}