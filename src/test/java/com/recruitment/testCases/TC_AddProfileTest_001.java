package com.recruitment.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.recruitment.pageObjects.AddProfilePage;

import com.recruitment.utilities.XLUtils;



public class TC_AddProfileTest_001 extends BaseClass  {

	@Test(dataProvider="AddProfileData")
	public void AddProfileTest(String firstN,String middleN,String lastN,String email,String mobile,String domain,String role,String resumeSourceOption,String sourceDropdownValue,String resumeSourceTextVal,String selectFormToEmail,String recruiterN) throws IOException 
	{

		try {
			AddProfilePage ap=new AddProfilePage(driver);

			ap.clickAddProfile();
			logger.info("Automated Addprofile Button");
			Reporter.log("Automated Addprofile Button");

			ap.setFirstName(firstN);
			logger.info("Automated FirstName");
			Reporter.log("Automated FirstName");

			ap.setMiddleName(middleN);
			logger.info("Automated MiddleName");
			Reporter.log("Automated MiddleName");

			ap.setLastName(lastN);
			logger.info("Automated LastName");
			Reporter.log("Automated LastName");

			ap.setEmailId(email);
			logger.info("Automated EmailId");
			Reporter.log("Automated EmailId");

			ap.setMobileno(mobile);
			logger.info("Automated mobile");
			Reporter.log("Automated mobile");
			Thread.sleep(5000);


			AddProfilePage.dropdownDomain(domain, "Domain");
			logger.info("Automated Domain");
			Reporter.log("Automated Domain");

			AddProfilePage.dropdownRole(role, "Role");
			logger.info("Automated Role");
			Reporter.log("Automated Role");

			AddProfilePage.dropdownResumeSource(resumeSourceOption, sourceDropdownValue,resumeSourceTextVal, "Source Resume");
			logger.info("Automated dropdownResumeSource");
			Reporter.log("Automated dropdownResumeSource");

			AddProfilePage.dropdownselectFormToEmail(selectFormToEmail, "selectFormToEmail");
			logger.info("Automated selectFormToEmail");
			Reporter.log("Automated selectFormToEmail");

			AddProfilePage.dropdownRecruiterName(recruiterN, "RecruiterName");
			System.out.println("Recruitername from excel:"+recruiterN);
			logger.info("Automated RecruiterName");
			Reporter.log("Automated RecruiterName");

			//automate Addprofile
			AddProfilePage.clickSubmitOk();
			logger.info("Automated submit");
			Reporter.log("Automated submit");
			System.out.println("test11");

			//Automated New profiles and duplicate profiles

			AddProfilePage.clickOkCreateUpdate();
			logger.info("Automated New Porifles or updated old profiles");
			Reporter.log("Automated New Porifles or updated old profiles");

		} catch (Exception e) {
			logger.info("Unable to Automate AddProfile Testcase");
			Reporter.log("Unable to Automate AddProfile Testcase");
		} 


		//Validate 
		AddProfilePage.validateAddprofile();
		logger.info("Automated :Validated Addprofile");
		Reporter.log("Automated :Validated Addprofile");
	}


	@DataProvider(name="AddProfileData")

	String [][] getData() throws IOException
	{

		//String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		//String path="C:\\Users\\aneetha_entoor\\eclipse-workspace\\RecruitmentProject\\src\\test\\java\\com\\recruitment\\testData\\SingleUser_DataFile.xlsx";

		String path=System.getProperty("user.dir")+"/src/test/java/com/recruitment/testData/SingleUser_DataFile.xlsx";
		int rownum=XLUtils.getRowCount(path, "AddProfile");
		System.out.println("Rowcount:"+rownum);
		int colcount=XLUtils.getCellCount(path,"AddProfile",1);
		System.out.println("Rowcount:"+colcount);
		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"AddProfile", i,j);//1 0
			}

		}
		return logindata;
	}

	//Validate Addprofile




}
