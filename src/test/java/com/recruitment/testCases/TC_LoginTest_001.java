package com.recruitment.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.recruitment.pageObjects.LoginPage;
public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException 
	{
		try {
				
			
			LoginPage lp=new LoginPage(driver);
		
			lp.setUserName(username);
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
	}
}