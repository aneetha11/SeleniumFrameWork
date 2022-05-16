package com.recruitment.reuseableMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.recruitment.testCases.BaseClass;


public class WaitUntillVisible extends BaseClass{
	
	
	
	public static  void explict_wait_till_visibilityOf(WebElement element) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 60);
			//			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			System.out.println(element + "Element not present");

		}
	}

	
	
	
	
}
