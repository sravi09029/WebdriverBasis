package selenium.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basicsTest {

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
		
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize(); // maximize the browser

		// get the current url

		String extected_URL = driver.getCurrentUrl();
		System.out.println(extected_URL);

		String actual_URL = "http://automationpractice.com/index.php";

		if (extected_URL.equals(actual_URL) == true) {

			System.out.println("Current URL is passed");
		} else {

			System.out.println("Current URL is failed");
		}

		String expected_title = driver.getTitle();
		System.out.println(expected_title);

		String actual_title = "My Store";

		if (expected_title.equals(actual_title) == true) {

			System.out.println("Expected title is passed");
		} else {

			System.out.println("expected title is failed");
		}
		
		driver.close(); //current browser is closed
		driver.quit(); // current browser + all browsers are closed
		

	}

}
