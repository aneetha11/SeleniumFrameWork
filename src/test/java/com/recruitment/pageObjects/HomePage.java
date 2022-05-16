/**
 * 
 */
package com.recruitment.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.recruitment.testCases.BaseClass;
import com.recruitment.utilities.Log;




/**
 * @author Hitendra
 *
 */
public class HomePage extends BaseClass {
	
	
	
	public HomePage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public static String getCurrURL() throws Throwable {
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}
	

	public boolean getTotalLinks()
	{
		
		 boolean flag = false;
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 int totalLinks=links.size();
		 Log.info("The toal links in page are"+totalLinks);
		 try {
			 
	    	  for (WebElement link : links) {	
	    		
	    			//	WebDriverWait wait = new WebDriverWait(driver,10);
	    				//wait.until(ExpectedConditions.visibilityOf(link));
	    				if(link.isEnabled() && link.isDisplayed())
					{
						flag=true;
						logger.info("DropdownItems are displayed and Enabled");
					} else {
						flag=false;
						logger.info("DropdownItems NOT DISPLAYED/ENABLED");	
					}
	    	  }
		 }catch (Exception e) {							
					logger.info("exeception-DropdownItems NOT DISPLAYED/ENABLED");	
					flag=false;
				}
	    	  return flag;
		 }
	

	
}
