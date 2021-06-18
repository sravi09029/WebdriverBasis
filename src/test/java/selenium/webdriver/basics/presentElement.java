package selenium.webdriver.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class presentElement {

	public static String browser = "chrome";
	public static WebDriver driver;

	/*
	 * public static boolean isElementPresentxpath(String loctaor) {
	 * 
	 * 
	 * try { driver.findElement(By.xpath(loctaor)); return true;
	 * 
	 * } catch (Throwable T) {
	 * 
	 * return false; }
	 * 
	 * 
	 * int size = driver.findElements(By.xpath(loctaor)).size(); if(size == 0) {
	 * return false; } else { return true; }
	 * 
	 * }
	 * 
	 * public static boolean isElementPresentCSS(String locator) {
	 * 
	 * try {
	 * 
	 * driver.findElement(By.cssSelector(locator)); return true; } catch (Throwable
	 * T) {
	 * 
	 * return false; } }
	 */
	
	 public static boolean isElementPresent(By by) {
		 
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

		driver.get("https://www.wikipedia.org/");

		WebElement Wiktionary = driver.findElement(By.xpath("//span[contains(text(),'Wiktionary')]"));
		System.out.println(Wiktionary.isDisplayed());

		/*
		 * WebElement searchbutton =
		 * driver.findElement(By.cssSelector("select#searchLanguage"));
		 * System.out.println(searchbutton.isDisplayed()); // false
		 */

		//System.out.println(isElementPresentxpath("//select[@id='searchLanguage']"));

		//System.out.println(isElementPresentCSS("select#searchLanguage"));
		
		System.out.println(isElementPresent(By.xpath("//select[@id='searchLanguage']")));
		System.out.println(isElementPresent(By.cssSelector("select#searchLanguage")));

		driver.close();
		driver.quit();

	}

}
