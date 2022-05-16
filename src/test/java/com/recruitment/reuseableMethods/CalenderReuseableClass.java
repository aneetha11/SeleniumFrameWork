package com.recruitment.reuseableMethods;

import java.awt.Robot;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.recruitment.testCases.BaseClass;


public class CalenderReuseableClass extends BaseClass{

	static Actions act=new Actions(driver);
	public static void calender(WebElement date_Icon,WebElement currentMMYYYY,String date,List AllDates,String day) throws InterruptedException, ParseException, IOException
	{
		try
		{
			//Validate date icon is present or not
			if(date_Icon.isDisplayed()&&date_Icon.isEnabled())
			{
				WebDriverWait wait = new WebDriverWait(driver, 7000);
				WaitUntillVisible.explict_wait_till_visibilityOf(date_Icon);
					
				//Click on Date Icon
				date_Icon.click();
				System.out.println("Clicked on Start Date");
				Reporter.log("Clicked on Date Icon",true);
				logger.info("Clicked on Start Date");

				
				WaitUntillVisible.explict_wait_till_visibilityOf(currentMMYYYY);
				
				String currDatestr=currentMMYYYY.getText();
				System.out.println("current date"+currDatestr);

				Date setDate =new SimpleDateFormat("dd/MM/yyyy").parse(date);
				System.out.println("Setdate is:"+setDate);
				logger.info("Setdate is:"+setDate);

				Date currdate =new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
				System.out.println("Current Date is:"+currdate);
				logger.info("Current Date is:"+currdate);

				DateTime current_month=new DateTime(currdate).withDayOfMonth(1);

				System.out.println("sys Current month and year:"+current_month);

				WaitUntillVisible.explict_wait_till_visibilityOf(currentMMYYYY);
				
				currentMMYYYY.click();
				logger.info("Clicked on current month and year");
				System.out.println("Clicked on current month and year");
				Reporter.log("Clicked on current month and year",true);

				int monthDiff= Months.monthsBetween(new DateTime(currdate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();
				System.out.println("test monthdiff");
				System.out.println("month diff is:"+monthDiff);



				boolean isFuture=true;
				System.out.println("isfuture is true click next");



				if(monthDiff<0) {
					isFuture=false;
					System.out.println("isfuture is true click previous");
					monthDiff = -1 * (monthDiff);
					System.out.println("multiply by -1"+monthDiff);
				}



				for (int i=0;i<monthDiff;i++)
				{
					if(isFuture) {

						act.sendKeys(Keys.ARROW_RIGHT).build().perform();
						System.out.println("next button");
						

					}
					else
					{
						act.sendKeys(Keys.ARROW_LEFT).build().perform();
						System.out.println("back button ");
						
					}

				}//for


Thread.sleep(2000);
				act.sendKeys(Keys.ENTER).build().perform();
				logger.info("Clicked on current Month");
		

				java.util.List<WebElement> dropdownValues=AllDates; 
				
				Thread.sleep(2000);
				for (WebElement dropdownValue : dropdownValues) {
				
					System.out.println("Size is:"+dropdownValues.size());
					WaitUntillVisible.explict_wait_till_visibilityOf(dropdownValue);
				
					if(dropdownValue.getText().equalsIgnoreCase(day)) {
					
						String curr_date=dropdownValue.getText();
						//if(curr_date == day) {
							
						Thread.sleep(2000);
						//dropdownValue.click(); 
						act.doubleClick(dropdownValue).build().perform();

				

						System.out.println("clicked on date: "+curr_date);
						Reporter.log("clicked on date: "+curr_date,true);
						Reporter.log("Automated Date",true);
						Reporter.log(".\n");
						break;
					} //if
					
					else { 
				//	logger.info("Not clicked on required date,Screenshot Taken");
					//Reporter.log("Not clicked on required date,Screenshot Taken");
					//captureScreen(driver, "Calander_date");
					}

				}//for

			}//if
		}//try 
		catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("Not clicked on required date,Screenshot Taken");
			Reporter.log("Not clicked on required date,Screenshot Taken");
			captureScreen(driver, "Calender:");
					
		}

	}

}
