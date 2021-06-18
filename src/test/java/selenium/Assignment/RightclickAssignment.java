package selenium.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightclickAssignment {
	
	
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

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

		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		
		//locate image path
		WebElement img = driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
		
		Actions action = new Actions(driver);
		action.contextClick(img).perform();
	
		WebElement sample = driver.findElement(By.xpath("//*[@id=\"dm2m1i2tdT\"]"));
		action.moveToElement(sample).perform();
		
		Thread.sleep(3000);
		
		WebElement sample4 = driver.findElement(By.xpath("//*[@id=\"dm2m8i3tdT\"]"));
		sample4.click();
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	

	}

}
