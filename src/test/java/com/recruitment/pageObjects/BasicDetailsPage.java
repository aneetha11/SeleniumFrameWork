package com.recruitment.pageObjects;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.recruitment.reuseableMethods.ClickClass;
import com.recruitment.reuseableMethods.DropdownClass;
import com.recruitment.reuseableMethods.SendKeysClass;
import com.recruitment.reuseableMethods.WaitUntillVisible;
import com.recruitment.testCases.BaseClass;

public class BasicDetailsPage extends BaseClass {
	static WebDriver ldriver;

	public BasicDetailsPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[contains(text(),' Candidates')]")	
	public static WebElement tabCandidate;

	@FindBy(xpath = "//div[contains(text(),' Details Yet To Be Captured')]")	
	public static WebElement stageDetailscaptured;

	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-2']/label/span[1]")	
	public static WebElement radioApplyEarlier;
	

	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-3']/label/span[1]")	
	public static WebElement radioApplyEarlierNo;
	
	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-5']/label/span[1]")	
	public static WebElement radioKnowAnyone;

	@FindBy(xpath = "(//input[@formcontrolname='knows_person_name'])[1]")	
	public static WebElement txtEmpName;

	@FindBy(xpath = "(//input[@formcontrolname='knows_person_id'])[1]")	
	public static WebElement txtEmpID;

	@FindBy(xpath = "(//span[text()='Validate Employee ID'])[1]")	
	public static WebElement validateID;

	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-8']/label/span[1]")
	public static WebElement radioExp;

	@FindBy(xpath = "(//input[@formcontrolname='overall_experience_years'])[1]")
	public static WebElement txtYear;

	@FindBy(xpath = "(//input[@formcontrolname='overall_experience_months'])[1]")
	public static WebElement txtMonth;

	@FindBy(xpath = "//mat-radio-button[@id='mat-radio-9']/label/span[1]")
	public static WebElement radioExpNo;

	@FindBy(xpath = "//input[@id='mat-input-12']")
	public static WebElement ddownCollege;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']/div/mat-option/span")
	public static List<WebElement> ddownCollegeItems;

	@FindBy(xpath = "(//input[@formcontrolname='branch'])[1]")
	public static WebElement ddownBranch;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']/div/mat-option/span")
	public static List<WebElement> ddownBranchItems;

	@FindBy(xpath = "(//mat-select[@formcontrolname='start_date'])[1]")
	public static WebElement ddownstartDate;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane']/div/div/mat-option/span")
	public static List<WebElement> ddownstartDateItems;

	@FindBy(xpath = "(//mat-select[@formcontrolname='end_date'])[1]")
	public static WebElement ddownEndDate;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane']/div/div/mat-option/span")
	public static List<WebElement> ddownEndDateItem;
	
	@FindBy(xpath = "(//mat-select[@formcontrolname='grade_type'])[1]")
	public static WebElement ddownCollegeGrade;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane']/div/div/mat-option/span")
	public static List<WebElement> ddownCollegeGradeItems;
	
	@FindBy(xpath = "(//input[@formcontrolname='cgpa'])[1]")
	public static WebElement txtCollegePercent;


	@FindBy(xpath = "(//input[@formcontrolname='name'])[1]")
	public static WebElement ddownCompany;
	
	@FindBy(xpath = "//div[@class='cdk-overlay-container']/div/div/div/mat-option/span")
	public static List<WebElement> ddownCompanyItems;

	@FindBy(xpath = "(//input[@formcontrolname='designation'])[1]")
	public static WebElement ddownDesignation;

	@FindBy(xpath = "//div[@class='cdk-overlay-container']/div/div/div/mat-option/span")
	public static List<WebElement> ddownDesignItems;

	@FindBy(xpath = "(//input[@formcontrolname='country'])[1]")
	public static WebElement ddownCountry;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']/div/mat-option/span")
	public static List<WebElement> ddownCountryItems;

	@FindBy(xpath = "(//input[@formcontrolname='state'])[1]")
	public static WebElement ddownState;

	@FindBy(xpath = "//div[@class='cdk-overlay-pane mat-autocomplete-panel-above']/div/mat-option/span")
	public static List<WebElement> ddownStateItems;

	@FindBy(xpath = "(//input[@formcontrolname='city'])[1]")
	public static WebElement ddownCity;




	//Click on Candidates tab 
	public static void clickcandidate() throws IOException, InterruptedException {
		//Click on candidate
		Thread.sleep(3000);
		ClickClass.clickButton(tabCandidate, "tabCandidate");
	}

	//Clicked on details to be Captured Stage

	public static void clickDetailCapturedStage() throws IOException, InterruptedException{
		Thread.sleep(2000);
		ClickClass.clickButton(stageDetailscaptured, "stageDetailscaptured");

	}

	//click on candidate name in Grid

	public static void clickname() throws IOException, InterruptedException{
		Thread.sleep(2000);

		driver.findElement(By.xpath("//table[@role='table']//tr[10]//td[1]")).click();

	}

	//Switch to window as Basic details opened in another window we have to switch

	public static void switchWindow() throws IOException, InterruptedException{

		Thread.sleep(3000);
		Set<String> windows=driver.getWindowHandles();
		System.out.println("total win"+windows.size());

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
	}


	public static void clickApplyEarlier() throws IOException, InterruptedException{
		//WebElement candidate=driver.findElement(By.xpath("(//span[contains(text(),'Candidate overview')])[1]"));
		//WaitUntillVisible.explict_wait_till_visibilityOf(candidate);

		ClickClass.clickButton(radioApplyEarlier, "radioApplyEarlier");

	}
	
	public static void clickApplyEarlierNO() throws IOException, InterruptedException{
		//WebElement candidate=driver.findElement(By.xpath("(//span[contains(text(),'Candidate overview')])[1]"));
	//	WaitUntillVisible.explict_wait_till_visibilityOf(candidate);

		ClickClass.clickButton(radioApplyEarlierNo, "radioApplyEarlierNo");

	}

	public static void clickKnowAnyone() throws IOException, InterruptedException{
		//ClickClass.clickButton(radioKnowAnyone, "radioKnowAnyone");
		radioKnowAnyone.click();
		txtEmpID.sendKeys("21689");Thread.sleep(3000);
		validateID.click();

	}

	public static void clickExpYes() throws IOException, InterruptedException{
		ClickClass.clickButton(radioExp, "radioExp");
	//	SendKeysClass.sendKeysMethod(txtYear, "5", "txtYear");
		txtYear.sendKeys("5");
		txtMonth.sendKeys("5");

	}

	public static void clickExpNo() throws IOException, InterruptedException{
		ClickClass.clickButton(radioExpNo, "radioExpNo");

	}
	
	//Scroll till visibility of company Name
	public static void scrollTillCompany() throws IOException, InterruptedException{

		WebElement dropdown1=driver.findElement(By.xpath("(//input[@formcontrolname='name'])[1]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", dropdown1);
	//	Thread.sleep(2000);

	}
	

	//Select data in Company dropdown
		public static void selectCompany() throws IOException, InterruptedException {
			
			
			dropdownVisibility(ddownCompany, ddownCompanyItems, "amazon india", "Company");
		}
		
		//Select data in Designation dropdown
		public static void selectDesignation() throws IOException, InterruptedException {
			dropdownVisibility(ddownDesignation, ddownDesignItems, "Associate", "Designation");
		}
	
		//Select data in Country dropdown
		public static void selectCountry() throws IOException, InterruptedException {
			DropdownClass.dropdown(ddownCountry, ddownCountryItems, "India", "Country");
		}

		//Select data in State dropdown
		public static void selectState() throws IOException, InterruptedException {
			DropdownClass.dropdown(ddownState, ddownStateItems, "Andhra pradesh", "State");
		}

		//Enter data in city dropdown
		public static void selectCity() throws IOException, InterruptedException {
			//Click on candidate
			SendKeysClass.sendKeysMethod(ddownCity, "autocity", "ddownCity");

		}


		//Scroll till visibility of college Name
		public static void scrollTillCollege() throws IOException, InterruptedException{

			WebElement dropdown1=driver.findElement(By.xpath("//input[@id='mat-input-12']"));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", dropdown1);
	//		Thread.sleep(2000);

		}
		
		
	//Select data in college dropdown
	public static void selectCollege() throws IOException, InterruptedException {
		DropdownClass.dropdown(ddownCollege, ddownCollegeItems, "IIM, Ahmedabad", "College");
	}

	//Select data in Branch dropdown
	public static void selectBranch() throws IOException, InterruptedException {
		DropdownClass.dropdown(ddownBranch, ddownBranchItems, "Computer Science Engineering", "BranchName");
	}


	//Select date in college start date
	public static void selectCollegeStrDate() throws IOException, InterruptedException {
		DropdownClass.dropdown(ddownstartDate, ddownstartDateItems, "2004", "StartDate");
	}

	//Select date in college end date
	public static void selectCollegeEndDate() throws IOException, InterruptedException {
		DropdownClass.dropdown(ddownEndDate, ddownEndDateItem, "2008", "EndDate");
	}

	//Select date in college end date
		public static void selectCollegeGrade() throws IOException, InterruptedException {
			DropdownClass.dropdown(ddownCollegeGrade, ddownCollegeGradeItems, "Percentage (%)", "Percentage (%)");
			Thread.sleep(3000);
			SendKeysClass.sendKeysMethod(txtCollegePercent, "80.5", "PercentageValue");
		}
		
		
		public static void dropdownVisibility(WebElement dropdownfield,List dropdownvalues,String reqvalue,String methodName) throws InterruptedException, IOException {

			try {
				if(dropdownfield.isDisplayed()&&dropdownfield.isEnabled())
				{
					//Clickedon dropdown
					//JavascriptExecutor executor = (JavascriptExecutor)driver;
					//executor.executeScript("arguments[0].click();", dropdownfield);

					System.out.println("Entered dropdown method");
					Reporter.log("Clicked on dropdown Arrow",true);
					logger.info("Clicked on dropdown Arrow");
				//	Thread.sleep(1000);
					dropdownfield.click();
					
					Thread.sleep(2000);
					WebElement dropdown1=driver.findElement(By.xpath("//div[@class='cdk-overlay-container']/div/div/div/mat-option[1]/span[1]"));
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", dropdown1);
				
					
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

		
		
		public static void calender() throws InterruptedException, ParseException, IOException
		{
			try
			{
				//Validate date icon is present or not
driver.findElement(By.xpath("//mat-datepicker-toggle[@data-mat-calendar='mat-datepicker-6']/button/span")).click();
			/*	if(date_Icon.isDisplayed()&&date_Icon.isEnabled())
				{
					WebDriverWait wait = new WebDriverWait(driver, 7000);
					WaitUntillVisible.explict_wait_till_visibilityOf(date_Icon);*/
						
					//Click on Date Icon
					//date_Icon.click();
					System.out.println("Clicked on Start Date");
					Reporter.log("Clicked on Date Icon",true);
					logger.info("Clicked on Start Date");

					WebElement currentMMYYYY=driver.findElement(By.xpath("//button[@aria-label='Choose date']/span/span"));
					WaitUntillVisible.explict_wait_till_visibilityOf(currentMMYYYY);
					
					String currDatestr=currentMMYYYY.getText();
					System.out.println("current date"+currDatestr);

					String date="02/01/2021";
					Date setDate =new SimpleDateFormat("dd/MM/yyyy").parse(date);
					System.out.println("Setdate is:"+setDate);
					logger.info("Setdate is:"+setDate);

					Date currdate =new SimpleDateFormat("MMMM yyyy").parse(currDatestr);
					System.out.println("Current Date is:"+currdate);
					logger.info("Current Date is:"+currdate);

					DateTime current_month=new DateTime(currdate).withDayOfMonth(1);

					System.out.println("sys Current month and year:"+current_month);

					
				
		
				}//try
				catch (Exception e) {
					System.out.println(e.getMessage());
					logger.info("Not Able to automate dropdown Screenshot taken");
					Reporter.log("Not Able to automate dropdown Screenshot taken",true);
				//	captureScreen(driver, methodName);
				}
		
		}	
		
	
}
	