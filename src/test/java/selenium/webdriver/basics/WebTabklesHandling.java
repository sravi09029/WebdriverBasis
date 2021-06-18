package selenium.webdriver.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTabklesHandling {
	
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		
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
		
		
		driver.get("https://money.rediff.com/gainers");  //
		driver.manage().window().maximize();
		
		//check the total row count
		List<WebElement> rolnum =driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("Total rownumbers: "+rolnum.size());
		
		//check the total cols count
		List<WebElement> colnum = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("Total colnumbers: "+colnum.size());
		
		for(int row = 1 ;row<=rolnum.size();row++) {
			
			for(int cols = 1; cols<=colnum.size();cols++) {
				
				System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" +row+ "]/td[" +cols+ "]")).getText());
			}
			
			System.out.println(" ");
		}
		
		
	}

}
