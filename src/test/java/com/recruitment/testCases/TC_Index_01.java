package com.recruitment.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import com.recruitment.pageObjects.IndexPage;
import com.recruitment.pageObjects.LoginPage;
import com.recruitment.utilities.Log;
public class TC_Index_01 extends BaseClass
{
	IndexPage indexpage;
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		indexpage= new IndexPage(driver);
		boolean result=indexpage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle=indexpage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "Wikipedia, the free encyclopedia");
		Log.endTestCase("verifyTitle");
	}
	
	
	
	/*@Test
	public void signTest() throws IOException, InterruptedException 
	{

		IndexPage indexpage = new IndexPage(driver);
	//	IndexPage.clickOnSignIn();
	
	}*/
}

/*	lp.setUserName(username);
			logger.info("Automated username");
			Reporter.log("Automated username");

			lp.setPassword(password);
			logger.info("Automated password");
			Reporter.log("Automated password");

			lp.clickLogin();
			logger.info("Automated Login Button");
			Reporter.log("Automated Login Button");

		//	SeleniumReuseable.implictyWait(100);

			lp.validateLogin();
			logger.info("Automated- Login TestCase");
			Reporter.log("Automated- Login TestCase");

			//SeleniumReuseable.implictyWait(100);

		} catch (Exception e) {
			logger.info("Unable to Automate Login Testcase");
			Reporter.log("Unable to Automate Login Testcase");
		} 
	}*/
