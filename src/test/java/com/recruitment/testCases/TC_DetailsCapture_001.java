package com.recruitment.testCases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.recruitment.pageObjects.DetailRequestedPage;
import com.recruitment.pageObjects.DetailsCapturedPage;
import com.recruitment.utilities.XLUtils;

public class TC_DetailsCapture_001  extends BaseClass  {
	@Test(dataProvider="DetailsCapturedData")
	public void DetailsCaptured(String emailID) throws IOException 
	{

		try {
			DetailsCapturedPage detailcap=new DetailsCapturedPage(driver);

			//Clicked on Candidate Tab

			detailcap.clickcandidate();
			logger.info("Automated :candidate Tab");
			Reporter.log("Automated :candidate Tab");
			
			//Clicked on Details Captured Stage

			detailcap.clickDetailCapturedStage();
			logger.info("Automated :Click on Details Captured Stage");
			Reporter.log("Automated :Click on Details Captured Stage");

			//Enter the Email Id in Search Bar

			detailcap.setSearchBox(emailID);
			logger.info("Automated :Data sent in search Bar");
			Reporter.log("Automated :Data sent in search Bar");

			//Validated search record exist or not and click on name to view basic details

		/*	DetailRequestedPage.foundEmailID(emailID);
			logger.info("Automated :Emaild exist or not and open basic details Page");
			Reporter.log("Automated :Emaild exist or not and open basic details Page");

			*/

		} catch (Exception e) {
			logger.info("Unable to Automate Details to be Captured Stage");
			Reporter.log("Unable to Automate Details to be Captured Stage");
		} 




	}


	@DataProvider(name="DetailsCapturedData")

	String [][] getData() throws IOException
	{

		String path=System.getProperty("user.dir")+"/src/test/java/com/recruitment/testData/SingleUser_DataFile.xlsx";
		int rownum=XLUtils.getRowCount(path, "DetailsCap");
		System.out.println("Rowcount:"+rownum);
		int colcount=XLUtils.getCellCount(path,"DetailsCap",1);
		System.out.println("Rowcount:"+colcount);
		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"DetailsCap", i,j);//1 0
			}

		}
		return logindata;
	}

	//Validate Addprofile




	

}
