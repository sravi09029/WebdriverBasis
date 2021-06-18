package selenium.webdriver.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdowns {
	
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
			
			WebElement dropdown = driver.findElement(By.cssSelector("select#searchLanguage"));
			//dropdown.sendKeys("Costa Rica");
			
			Select select = new Select(dropdown);
			//select.selectByVisibleText("Costa Rica");
			
			
			List<WebElement> values = driver.findElements(By.tagName("option"));
			System.out.println("Total values of size: "+values.size());
			
			System.out.println(values.get(10).getText());
			
			//int j = 10;
			String lang = "Slovenčina";
			
			for(int i = 0; i<values.size();i++) {
				
				System.out.println(values.get(i).getAttribute("lang"));
				
				/*
				 * if(j==i) {
				 * 
				 * break; }
				 */
				 
				/*
				 * System.out.println(values.get(11).getAttribute("lang")); break;
				 */
				//System.out.println(values.get(i).getText().equals("Slovenčina"));
				
				/*
				 * if(lang.equals("sk") == true) {
				 * 
				 * System.out.println(values.get(i).getText()); }
				 */
			}
			
			
			
			driver.close();
			
	
	
		}

}
