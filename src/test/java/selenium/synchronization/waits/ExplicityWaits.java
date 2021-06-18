package selenium.synchronization.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicityWaits {
	
	 public static String browser = "chrome";
	 public static WebDriver driver;

	public static void main(String[] args) {
		
		
		if(browser.equals("chrome") == true) {
			
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		} else if(browser.equals("firefox") == true) {
			
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		} else if(browser.equals("IE") == true) {
			
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		}
		
		driver.get("https://www.ajio.com//?gclid=Cj0KCQjwnueFBhChARIsAPu3YkQEitg8cONSaHEdT6y7uG0VWuAWyqiRq4kaIFifDx9e1fI_zeQBa1gaAprDEALw_wcB");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		System.out.println(driver.getTitle().length());
		String exp_title = driver.getTitle();
		System.out.println(exp_title);
		
		String act_title = "AJIO | Online Shopping Site in India for Fashion & Lifestyle - AJIO";
		
		if(exp_title.equals(act_title)  == true) {
			
			System.out.println("Title is passed");
		} else {
			
			System.out.println("Title is failed");
		}
		
		//clicks  on the sign button
		//WebElement sign_button  = driver.findElement(By.xpath("//a[text()='SIGN IN']"));  
		WebElement sign_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='SIGN IN']")));
		sign_button.click();
		
		/*
		 * WebElement username =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
		 * "input.username"))); username.sendKeys("sampathiravikumar@gmail.com");
		 */
		
		WebElement continue_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='login-btn' or @type='submit']")));
		continue_button.click();
		
		String expe_text_message = driver.findElement(By.cssSelector("div#error-msg")).getText();
		
		String actual_text_message = "Please enter valid Mobile Number / Email.";
		
		if(expe_text_message.equals(actual_text_message) == true) {
			
			System.out.println("text is passed");
		} else {
			
			System.out.println("text is failed");
		}
		
		
	
	}

}
