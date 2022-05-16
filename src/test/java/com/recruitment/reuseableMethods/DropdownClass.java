package com.recruitment.reuseableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import com.recruitment.testCases.BaseClass;

public class DropdownClass extends BaseClass{

	public static void dropdown(WebElement dropdownfield,List dropdownvalues,String reqvalue,String methodName) throws InterruptedException, IOException {

		try {
			if(dropdownfield.isDisplayed()&&dropdownfield.isEnabled())
			{
				//Clickedon dropdown
				//JavascriptExecutor executor = (JavascriptExecutor)driver;
				//executor.executeScript("arguments[0].click();", dropdownfield);

				System.out.println("Entered dropdown method");
				Reporter.log("Clicked on dropdown Arrow",true);
				logger.info("Clicked on dropdown Arrow");
				Thread.sleep(1000);
				dropdownfield.click();
			
				//Automate list of items in dropdown
				List<WebElement> fp_dropdownValues=dropdownvalues;
				Reporter.log("Size of dropdown items is: "+fp_dropdownValues.size(),true);
				logger.info("Size of dropdown items is: "+fp_dropdownValues.size());
				Reporter.log(".\n");
				logger.info(".\n");

				for (WebElement dropdownValue : fp_dropdownValues) {

					//System.out.println("dropdown values are "+dropdownValue.getText());
					if(dropdownValue.isEnabled() && dropdownValue.isDisplayed())
					{
						Reporter.log("DropdownItems are displayed and Enabled",true);
						logger.info("DropdownItems are displayed and Enabled");
						if(dropdownValue.getText().equalsIgnoreCase(reqvalue)) {
							dropdownValue.click();

							//	Thread.sleep(2000);
							//System.out.println("clicked on dropdown item "+value + "\n" );

							Reporter.log("MATCHED:Clicked on Required dropdown item = "+reqvalue,true);
							logger.info("MATCHED:Clicked on Required dropdown item = "+reqvalue);
							Reporter.log(".\n");

							System.out.println();

							break;
						}//if inner

						else { 

							//  System.out.println("Dropdown item MISMATCH with Required Item "+value);
							//value
							Reporter.log("MISMATCH:Dropdown item MISMATCH with Required Item = "+dropdownValue.getText(),true);
							System.out.println("required value:"+reqvalue);
							Reporter.log(".\n");
							logger.info("MISMATCH:Dropdown item MISMATCH with Required Item = "+dropdownValue.getText());
							logger.info(".\n");


						}//else inner

					}//if outer
					else
					{
						//System.out.println("dropdown item is not clickable or not diapalyed");
						//Reporter.log("DropDown item is not clickable or not Enabled");
						//captureScreen(driver, "dropdown1");

					}//else outer
				}//for

			}//if

			else
			{
				//System.out.println("dropdown item is not clickable or not diapalyed");
				Reporter.log("DropDown Arrow not clickable or not Enabled",true);
				logger.info("DropDown Arrow not clickable or not Enabled");
				captureScreen(driver, methodName);

			}//else outer
		}//try
		catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("Not Able to automate dropdown Screenshot taken");
			Reporter.log("Not Able to automate dropdown Screenshot taken",true);
			captureScreen(driver, methodName);
		}
	}


	public static void dropdownJavascript(WebElement dropdownfield,List dropdownvalues,String reqvalue,String methodName) throws InterruptedException, IOException {

		try {
			if(dropdownfield.isDisplayed()&&dropdownfield.isEnabled())
			{
				//Clickedon dropdown
				System.out.println("Entered dropdown method");
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", dropdownfield);
				Reporter.log("Clicked on dropdown Arrow",true);
				logger.info("Clicked on dropdown Arrow");
				Thread.sleep(2000);
				//dropdownfield.click();

				//Automate list of items in dropdown
				List<WebElement> fp_dropdownValues=dropdownvalues;
				Reporter.log("Size of dropdown items is: "+fp_dropdownValues.size(),true);
				logger.info("Size of dropdown items is: "+fp_dropdownValues.size());
				Reporter.log(".\n");
				logger.info(".\n");

				for (WebElement dropdownValue : fp_dropdownValues) {

					//System.out.println("dropdown values are "+dropdownValue.getText());
					if(dropdownValue.isEnabled() && dropdownValue.isDisplayed())
					{
						Reporter.log("DropdownItems are displayed and Enabled",true);
						logger.info("DropdownItems are displayed and Enabled");
						if(dropdownValue.getText().equalsIgnoreCase(reqvalue)) {
							//dropdownValue.click();

							executor.executeScript("arguments[0].click();", dropdownValue);
							Thread.sleep(2000);
							//System.out.println("clicked on dropdown item "+value + "\n" );

							Reporter.log("MATCHED:Clicked on Required dropdown item = "+reqvalue,true);
							logger.info("MATCHED:Clicked on Required dropdown item = "+reqvalue);
							Reporter.log(".\n");

							System.out.println();break;
						}//if inner

						else { 

							//  System.out.println("Dropdown item MISMATCH with Required Item "+value);
							//value
							Reporter.log("MISMATCH:Dropdown item MISMATCH with Required Item = "+dropdownValue.getText(),true);
							System.out.println("required value:"+reqvalue);
							Reporter.log(".\n");
							logger.info("MISMATCH:Dropdown item MISMATCH with Required Item = "+dropdownValue.getText());
							logger.info(".\n");
						}//else inner

					}//if outer
					else
					{
						//System.out.println("dropdown item is not clickable or not diapalyed");
						//Reporter.log("DropDown item is not clickable or not Enabled");
						//captureScreen(driver, "dropdown1");

					}//else outer
				}//for

			}//if

			else
			{
				//System.out.println("dropdown item is not clickable or not diapalyed");
				Reporter.log("DropDown Arrow not clickable or not Enabled",true);
				logger.info("DropDown Arrow not clickable or not Enabled");
				captureScreen(driver, methodName);

			}//else outer
		}//try
		catch (Exception e) {
			System.out.println(e.getMessage());
			logger.info("Not Able to automate dropdown Screenshot taken");
			Reporter.log("Not Able to automate dropdown Screenshot taken",true);
			captureScreen(driver, methodName);
		}

	}









}//Base class





















