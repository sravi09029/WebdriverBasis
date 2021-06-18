package selenium.webdriver.basics;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverPrograms {
	
	public static String browser = "chrome";
	public static WebDriver driver;
	

	public static void main(String[] args) throws Exception {
		
		
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
		
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("way2automation");
		search.sendKeys(Keys.ENTER);
		
		WebElement way2automation = driver.findElement(By.xpath("//h3[text()='Way2Automation']"));
		way2automation.click();
		
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		
		String exp_title = "Online Selenium Certification Course | Selenium Online Training | Selenium Tutorial";
		
		if(actual_title.equals(exp_title) == true ) {
			
			System.out.println("title is passed");
		} else {
			
			System.out.println("Title is failed");
		}
		
		//Mouse move to the element
		WebElement menu_resource = driver.findElement(By.xpath("//a[text()='Resources']"));
		Actions action = new Actions(driver); // handling the mouse over
		action.moveToElement(menu_resource).perform();
		
		WebElement Practice_site_1 = driver.findElement(By.linkText("Practice site 1"));
		Practice_site_1.click();
			
		
	}

}
