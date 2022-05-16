package com.recruitment.reuseableMethods;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.recruitment.testCases.BaseClass;

public class ValidateClass extends BaseClass{
	
	public static void validateMethod(WebElement icon,String methodname) throws IOException {
		try{
			if (icon.isDisplayed() && icon.isEnabled()) {
				//boolean flagval=homeButton.isDisplayed();
				logger.info("Successfully Validated:"+methodname);
				Reporter.log("Successfully Validated:"+methodname);
			}
		}catch(Exception e) {
			logger.info("UNSuccessfull Validation:"+methodname);
			Reporter.log("UNSuccessfull Validation:"+methodname);
			captureScreen(driver,methodname);
	
		}

	}

}
