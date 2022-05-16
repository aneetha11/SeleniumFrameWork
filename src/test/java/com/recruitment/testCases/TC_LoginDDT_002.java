package com.recruitment.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.recruitment.pageObjects.LoginPage;
import com.recruitment.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
try {
			
		//	driver.get(baseURL);
			logger.info("URL is opened");Thread.sleep(2000);
			
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setUserName(user);
			logger.info("Automated username");
			Reporter.log("Automated username");

			lp.setPwd(pwd);
			logger.info("Automated password");
			Reporter.log("Automated password");
			//Thread.sleep(2000);

			lp.clickLogin();
			logger.info("Automated Login Button");
			Reporter.log("Automated Login Button");
			//Thread.sleep(2000);

		//	SeleniumReuseable.implictyWait(100);

			lp.validateLogin();
			logger.info("Automated- Login TestCase");
			Reporter.log("Automated- Login TestCase");
			//Thread.sleep(2000);

			//SeleniumReuseable.implictyWait(100);

		} catch (Exception e) {
			logger.info("Unable to Automate Login Testcase");
			Reporter.log("Unable to Automate Login Testcase");
		} 
	}
		
	 
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		//String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		//String path="D:\\Users\\aneetha_entoor\\eclipse-workspace\\RecruitmentProject\\src\\test\\java\\com\\recruitment\\testData\\RP_DataFile.xlsx";
		
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/recruitment/testData/RP_DataFile.xlsx";
		int rownum=XLUtils.getRowCount(path, "Login");
		System.out.println("Rowcount:"+rownum);
		int colcount=XLUtils.getCellCount(path,"Login",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Login", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}
