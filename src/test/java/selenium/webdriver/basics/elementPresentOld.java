package selenium.webdriver.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class elementPresentOld {

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

		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_checkbox_disabled2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("input#myCheck")).click();
	}

}
