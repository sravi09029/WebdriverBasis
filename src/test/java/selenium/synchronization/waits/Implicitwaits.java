package selenium.synchronization.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicitwaits {
	
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
		
		driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Drm%26ogbl&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(14l,TimeUnit.SECONDS); // implicity waits 
		
		//username
		WebElement username = driver.findElement(By.cssSelector("input#identifierId"));
		username.sendKeys("sampathiravikumar@gmail.com");
		
		//clicks on the next button
		WebElement next_button = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		next_button.click();
		
		driver.navigate().refresh();
	}
	
	
}
