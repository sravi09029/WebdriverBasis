package selenium.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class way2automationlinks {
	
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		
		if(browser.equals("chrome") == true) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browser.equals("IE")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	
		
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("way2automation");
		search.sendKeys(Keys.ENTER);
		
		//clicks on the way2automation
		
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
		
		// printv the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(int i = 0; i<links.size();i++) {
			
			System.out.println(links.get(i).getAttribute("href"));
		}
		
		
		/*
		 * List<WebElement> listresults = driver.findElements(By.xpath(
		 * "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/ul/li"));
		 * System.out.println("Total list: "+listresults.size());
		 */
		
		/*
		 * for(WebElement nameslist : listresults ){
		 * 
		 * String value = nameslist.getText(); System.out.println(value);
		 * 
		 * boolean filtered=value.startsWith("www.seleniumhq.org/");
		 * 
		 * int size1 = value.split("way2automation").length-1;
		 * 
		 * System.out.println(size1);
		 * 
		 * }
		 */
		
		
		driver.close();
		driver.quit();
	
	}

}
