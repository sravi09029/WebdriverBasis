package selenium.webdriver.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basics {

	public static void main(String[] args) {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\RK\\Downloads\\chromedriver_win32\\chromedriver.exe"); WebDriver
		 * driver = new ChromeDriver();
		 */

		/*
		 * WebDriverManager.firefoxdriver().setup(); FirefoxDriver driver = new
		 * FirefoxDriver();
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
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
		
		
		System.out.println(driver.getCapabilities());
		
		
		System.out.println(driver.getPageSource());
		

	}

}
