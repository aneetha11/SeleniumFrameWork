package com.recruitment.testCases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.recruitment.pageObjects.AddProfilePage;
import com.recruitment.pageObjects.DetailRequestedPage;
import com.recruitment.utilities.XLUtils;

public class TC_DetailsReqDDT_002 extends BaseClass  {
	@Test(dataProvider="DetailsRequestedData")
	public void DetailsRequested(String emailID,String actionvalue) throws IOException 
	{

		try {
			DetailRequestedPage detailreq=new DetailRequestedPage(driver);

			//Clicked on Details requested Stage

			detailreq.clickDetailsRequested();
			logger.info("Automated :Click on Details requested Stage");
			Reporter.log("Automated :Click on Details requested Stage");

			//Enter the Email Id in Search Bar

			detailreq.setSearchBox(emailID);
			logger.info("Automated :Data sent in search Bar");
			Reporter.log("Automated :Data sent in search Bar");

			//Validated search record displayed or existed or not

			DetailRequestedPage.foundEmailID(emailID);
			logger.info("Automated :Emaild exist or not");
			Reporter.log("Automated :Emaild exist or not");

			//Clicked on requested action Item by User

			DetailRequestedPage.dropdownAction(actionvalue);

			logger.info("Automated :Action Items required by User");
			Reporter.log("Automated :Action Items required by User");


		} catch (Exception e) {
			logger.info("Unable to Automate Details to be Requested Stage");
			Reporter.log("Unable to Automate Details to be Requested Stage");
		} 




	}


	@DataProvider(name="DetailsRequestedData")

	String [][] getData() throws IOException
	{

		String path=System.getProperty("user.dir")+"/src/test/java/com/recruitment/testData/RP_DataFile.xlsx";
		int rownum=XLUtils.getRowCount(path, "DetailsReq");
		System.out.println("Rowcount:"+rownum);
		int colcount=XLUtils.getCellCount(path,"DetailsReq",1);
		System.out.println("Rowcount:"+colcount);
		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"DetailsReq", i,j);//1 0
			}

		}
		return logindata;
	}

	//Validate Addprofile




}
