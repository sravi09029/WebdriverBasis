package selenium.EventListeners.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testListeners {

	public static String browser = "chrome";
	//public static ChromeDriver driver;
	
		public static WebDriver webdriver;

		public static void main(String[] args) {

			if (browser.equals("firefox")) {

				WebDriverManager.firefoxdriver().setup();
				//FirefoxDriver driver = new FirefoxDriver();
				webdriver = new FirefoxDriver();
				
			} else if (browser.equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				//ChromeDriver driver = new ChromeDriver();
				webdriver = new ChromeDriver();
				
			} else if (browser.equals("IE")) {
				WebDriverManager.iedriver().setup();
				//InternetExplorerDriver driver = new InternetExplorerDriver();
				webdriver = new InternetExplorerDriver();

			}
			
			// create the eventfiringwebdriver class
			EventFiringWebDriver  driver = new EventFiringWebDriver(webdriver);
			//create the weblisteners class
			webListeners listeners = new webListeners();
			
			//register the class
			driver.register(listeners);
			
			
			
			webdriver.get("https://google.com");
			webdriver.manage().window().maximize();
			
			WebElement gmail = webdriver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a"));
			gmail.click();
		
	}

}
