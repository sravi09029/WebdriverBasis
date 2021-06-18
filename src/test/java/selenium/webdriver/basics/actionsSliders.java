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

public class actionsSliders {
	
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
			driver = new InternetExplorerDriver();
		}
		
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		/*
		 * //mouse move to the element WebElement sliders =
		 * driver.findElement(By.linkText("Slider")); Actions action = new
		 * Actions(driver); action.moveToElement(sliders).click();
		 */
		
		/*
		 * WebElement slider_button = driver.findElement(By.linkText("Slider"));
		 * slider_button.click();
		 */
		
		//locator of mainelement
		WebElement mainslider = driver.findElement(By.id("slider"));
		int width  = mainslider.getSize().width/2;
		
		
		//locator of sider element
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
		/*
		 * //1st method Actions action = new Actions(driver);
		 * action.dragAndDropBy(slider, 400, 0).perform();
		 */
			
		
		//2nd method
		new Actions(driver).dragAndDropBy(slider, width, 0).perform();
		
		
		driver.close();
		driver.quit();
	}
	

}
