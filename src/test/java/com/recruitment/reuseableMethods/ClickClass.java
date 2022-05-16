package com.recruitment.reuseableMethods;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.recruitment.testCases.BaseClass;
import com.recruitment.utilities.Log;

public class ClickClass extends BaseClass{

	public static void clickButton(WebElement element,String methodName) throws IOException {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
		
				element.click();
				Log.info("Able to click:"+methodName);
				
			}
		} catch (Exception e) {
			captureScreen(driver,methodName);
			Log.info("Not Able to click:"+methodName);
			//Assert.assertTrue(false);

		}

	}



}
