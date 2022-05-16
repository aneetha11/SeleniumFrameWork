package com.recruitment.reuseableMethods;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.recruitment.testCases.BaseClass;

public class Scroll_VisiblilityofEle extends BaseClass{

	public static void KeysPgDown(WebElement element,String methodName) throws IOException {
		try {
			//scroll down

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			//This will scroll the page till the element is found		
			js1.executeScript("arguments[0].scrollIntoView();", element);
			logger.info("Element is scrollable");
			Reporter.log("Element is scrollable");
			return;


		}catch(Exception e) {
			e.printStackTrace();
			logger.info("Element is not scrollable");
			Reporter.log("Element is not scrollable");
			captureScreen(driver, methodName);
		}
	}




}




