package selenium.TestNG.Examples;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidationsCheck {
	
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
	
	
	@Test
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
		
		/*
		 * if(actual_URl.equals(expected_URL) == true) {
		 * 
		 * System.out.println("URL is passed"); } else {
		 * System.out.println("Url is failed"); }
		 */
		
		Assert.assertEquals(actual_URl, expected_URL);
		
		//is element present -- true or false
		boolean google_search_button = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@aria-label='Google Search']")) != null;
		Assert.assertTrue(google_search_button, "Element is found");
	}
	
	@AfterTest
	public void closebrowser() {
		
		driver.close();
		driver.quit();
		
	}
	

}
