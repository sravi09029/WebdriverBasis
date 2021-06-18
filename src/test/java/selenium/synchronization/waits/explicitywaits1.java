package selenium.synchronization.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class explicitywaits1 {
	
	
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
			driver =  new InternetExplorerDriver();
		}
		
		driver.navigate().to("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15l, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10l);
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click me to start timer']")));
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		
		
		String  element = driver.findElement(By.xpath("//p[text()='WebDriver']")).getText();
		
		String actual_text =   "WebDriver";
		
		if(element.equals(actual_text) == true) {
			
			System.out.println("text is passed");
		} else {
			
			System.out.println("text is failed");
		}
		
	

	}
}
