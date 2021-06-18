package selenium.webdriver.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class printinglinks {
	
	public static String browser = "chrome";
	//public static ChromeDriver driver;
	public static WebDriver driver;

	public static void main(String[] args) {
		
		if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			//FirefoxDriver driver = new FirefoxDriver();
			driver = new FirefoxDriver();
			
		} else if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			//ChromeDriver driver = new ChromeDriver();
			driver = new ChromeDriver();
			
		} else if (browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			//InternetExplorerDriver driver = new InternetExplorerDriver();
			driver = new InternetExplorerDriver();

		}
		
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total printed links: "+links.size());
		
		for(int i = 0; i<links.size();i++) {
			
			System.out.println(links.get(i).getAttribute("href"));
		}
		
		driver.close();
		driver.quit();
		
		
		
	}

}
