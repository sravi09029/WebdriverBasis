package selenium.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboardkeys {
	
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

		driver.get("https:gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		
		WebElement username = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
		username.sendKeys("ravikumar051994@gmail.com");
		
		
		//driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]")).sendKeys(Keys.ENTER);
		
		WebElement cliks = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]"));
		//action.moveToElement(cliks).perform();
		cliks.click();
		
		//action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).build().perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		
		username.click();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		
		
		
	
	}
}
