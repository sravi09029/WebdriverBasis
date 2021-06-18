package selenium.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionsDradandDrop {
	
	
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
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		//locate the draggable element
		WebElement draggable = driver.findElement(By.id("draggable"));
		
		//locate the droppable element
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		/*
		 * Actions action = new Actions(driver); action.dragAndDrop(draggable,
		 * draggable).perform();
		 */
		
		new Actions(driver).dragAndDropBy(draggable, 400, 100).perform();
		
		driver.close();
		driver.quit();
		
		
		
		
	}	

	

}
