package JavaConcepts;


 
	import java.util.concurrent.TimeUnit; 
	import org.openqa.selenium.By; 
	import org.openqa.selenium.WebDriver; 
	import org.openqa.selenium.WebElement; 
	import org.openqa.selenium.firefox.FirefoxDriver; 
	public class IsDisplayedDemo {
	
	public static void main(String[] args) 
	{ 
	// Create an object of FirefoxDriver class. 
	    // WebDriver driver = new FirefoxDriver(); 
		
		System.setProperty("webdriver.gecko.driver", "D:\\Users\\aneetha_entoor\\eclipse-workspace\\RecruitmentProject\\Drivers\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		System.out.println("firefox launched successfully");
		
		
		

	// Launch the Firefox browser and open URL. 
	     String URL = "https://www.google.com"; 
	     driver.get(URL); 

	// Maximize browser window. 
	     driver.manage().window().maximize(); 

	// Delay for specified amount of time to load page. 
	     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 

	// Check that “Google Search box” is displayed or not. If Search box is displayed, it will return true. 
	     WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']")); 
	     
	    if(searchBox.isDisplayed()) { 
	       System.out.println("Search box is visible. Return: " +searchBox.isDisplayed()); 
	    } 
	    else { 
	       System.out.println("Search box is not visible. Return: " +searchBox.isDisplayed()); 
	    } 
	// Check that "Google Search button" is displayed or not. 
	     WebElement searchButton = driver.findElement(By.xpath("//input[@class='gNO89b']")); 
	   
	    if(searchButton.isDisplayed()) { 
	       System.out.println("Search button is visible. Return: " +searchButton.isDisplayed()); 
	    } 
	   else { 
	      System.out.println("Search button is not visible. Return: " +searchButton.isDisplayed()); 
	    } 
	driver.close(); 
	 } 
	
	
	
	
	
	
}
