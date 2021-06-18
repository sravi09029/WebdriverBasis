package selenium.TestNG.Examples;

import static org.testng.Assert.assertFalse;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(cumListeners.Listeners.class)

public class DependenciesExample {
	
	
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	
	@BeforeTest
	public void openbrowser() {
		
		if (browser.equals("chrome") == true) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox") == true) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("IE") == true) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
	}
	
	@Test(priority = 3,dependsOnMethods = "demo", alwaysRun = true) //alwaysRun = true is a soft dependiences
	public void validatestitles() {
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		String actual_title =  driver.getTitle();
		System.out.println(actual_title);
		String expected_title = "Google";
		/*
		 * if(actual_title.equals(expected_title) == true ) {
		 * 
		 * System.out.println("Test is passed"); } else {
		 * 
		 * System.out.println("Test is failed"); }
		 */
		
		Assert.assertEquals(actual_title, expected_title);
		
		String actual_URl = driver.getCurrentUrl();
		System.out.println(actual_URl);
		
		String expected_URL = "https://www.google.com/";
		
		//soft assertions using in this case multiple failures are  getting if any case failed cases
		SoftAssert softassert = new SoftAssert();
		
		/*
		 * if(actual_URl.equals(expected_URL) == true) {
		 * 
		 * System.out.println("URL is passed"); } else {
		 * System.out.println("Url is failed"); }
		 */
		/*
		 * System.out.println("validating the titlle");
		 * softassert.assertEquals(actual_URl, expected_URL);
		 * 
		 * //validating the img System.out.println("Validating img");
		 * softassert.assertEquals(true, false);
		 * 
		 * //validating text box presence softassert.assertEquals(true, false);
		 */
		//is element present -- true or false
		boolean google_search_button = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@aria-label='Google Search']")) != null;
		softassert.assertTrue(google_search_button, "Element is found");
		
		softassert.assertAll();
	
	}
	
	@Test(priority = 2,dependsOnMethods = "method")
	public void demo() {
		
		System.out.println("Test method is created");
		Assert.assertEquals(true, false);
		
	}
	
	@Test(priority = 1)
	public void method() {
		
		System.out.println("Method is created");
		Assert.assertEquals(true, false);
	}
	
	@Test(priority = 4, dependsOnMethods = {"demo","validatestitles"}) //Multiple dependiences are addedd
	public void method1() {
		
		System.out.println("Method1 is created");
	}
	
	
	@AfterTest
	public void closebrowser() {
		
		driver.close();
		driver.quit();
		
	}
	
	
	
	
	

}
