package selenium.webdriver.basics;

import java.awt.Checkbox;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxesHandling {

	public static String browser = "chrome";
	public static WebDriver driver;

	public static boolean isElementPrasent(By by) {
		
		int size = driver.findElements(by).size();
		 if(size == 0) {
			 return false;
		 } else {
			 return true;
		 }
	}
	
	
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

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();

		WebElement block = driver.findElement(By.xpath("//tbody//tr//div[4]"));

		/*
		 * WebElement soccer = block.findElement(By.xpath("//input[@value='soccer']"));
		 * soccer.click();
		 * 
		 * WebElement football =
		 * block.findElement(By.xpath("//input[@value='football']")); football.click();
		 * 
		 * WebElement baseball =
		 * block.findElement(By.xpath("//input[@value='baseball']")); baseball.click();
		 * 
		 * WebElement basketball =
		 * block.findElement(By.xpath("//input[@value='basketball']"));
		 * basketball.click();
		 */

		/*
		 * for (int i = 1; i < 5; i++) {
		 * 
		 * driver.findElement( By.xpath(
		 * "/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[" + i +
		 * "]")) .click(); }
		 */
		
		
		/*
		 * int i = 1; int count = 0;
		 * 
		 * while(isElementPrasent(By.xpath(
		 * "/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[" +i+
		 * "]"))) {
		 * 
		 * driver.findElement(By.xpath(
		 * "/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[" +i+
		 * "]")).click();
		 * 
		 * i++;
		 * 
		 * count++; }
		 * 
		 * System.out.println("Total check boxes: "+count);
		 */
		 
		
		 
		 List<WebElement> checkboxes = block.findElements(By.xpath("//div[4]//input"));
		 
		 System.out.println("Total checkboes count: "+checkboxes);
		 
		 for(WebElement checkboxe : checkboxes) {
			 
			 checkboxe.click();
		 }
		
		
	}

}
