package com.recruitment.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.recruitment.pageObjects.HomePage;
import com.recruitment.pageObjects.IndexPage;
import com.recruitment.pageObjects.LoginPg;
import com.recruitment.utilities.Log;



public class TC_Login_02 extends BaseClass {

	@Test
	public void loginTest() throws Throwable {
		LoginPg lp=new LoginPg(driver);
		
		IndexPage indexpage = new IndexPage(driver);
		indexpage.clickOnSignIn();
		
		Log.startTestCase("loginTest");
		
		lp.login(username, password);
			
		String actualURL=HomePage.getCurrURL();
		String expectedURL="https://en.wikipedia.org/wiki/Main_Page";

		Log.info("Verifying if user is able to login");
	//	Assert.assertEquals(actualURL, expectedURL);
		
		if(actualURL.equals("https://en.wikipedia.org/wiki/Main_Page"))
		{
			Assert.assertTrue(true);
			Log.info("LoginTest- passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("LoginTest-failed");
		}
	
		Log.endTestCase("loginTest");
		
		
		
		/*
		Log.info("user is going to click on SignIn");
	

		Log.info("Enter Username and Password");

		lp.setUserName(username);
		logger.info("Entered username");

		lp.setPassword(password);
		logger.info("Entered password");

		lp.clickSubmit(); 

		String actualURL=HomePage.getCurrURL();
		String expectedURL="https://en.wikipedia.org/wiki/Main_Page";

		Log.info("Verifying if user is able to login");
	//	Assert.assertEquals(actualURL, expectedURL);
		
		if(actualURL.equals("https://en.wikipedia.org/wiki/Main_Page"))
		{
			Assert.assertTrue(true);
			Log.info("LoginTest- passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("LoginTest-failed");
		}
	
		Log.endTestCase("loginTest");*/

	}

}




	
	
	
	
	


/*	IndexPage indexPage= new IndexPage(driver);
	LoginPg lp=new LoginPg(driver);

	

	@Test(groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd) throws Throwable {
		
		
		IndexPage.clickOnSignIn();
		
	}}
	/*	lp.login(username, password);
	
		
		String actualURL=HomePage.getCurrURL();
		String expectedURL="https://en.wikipedia.org/wiki/Main_Page";

		Log.info("Verifying if user is able to login");
	//	Assert.assertEquals(actualURL, expectedURL);
		
		if(actualURL.equals("https://en.wikipedia.org/wiki/Main_Page"))
		{
			Assert.assertTrue(true);
			Log.info("LoginTest- passed");
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			Log.info("LoginTest-failed");
		}
	
		Log.endTestCase("loginTest");

	}
		
		
		
	}
/*	public void loginTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}
*/


