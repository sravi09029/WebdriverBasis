package selenium.webdriver.basics;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingTabsPopups {
	
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	
	 public static void capturescreenshoot() throws Exception {
		 
		 Date d = new Date();
		 String filename = d.toString().replace(":", "_").replace(":", "_")+".jpg";
		 File screenshoot  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshoot, new File(".//screenshoot//"+filename));
		
		 
	 }

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
		
		
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		System.out.println("-----------Generating first window--------------");
		Set<String> winds = driver.getWindowHandles();
		Iterator<String> iterate = winds.iterator();
		String first_window = iterate.next();
		System.out.println(first_window);
		
		/*
		 * //list the all drop downs List<WebElement> list =
		 * driver.findElements(By.tagName("li")); System.out.println(list.size());
		 * for(int i = 0;i<list.size();i++) {
		 * 
		 * System.out.println(list.get(i).getAttribute("value")); }
		 
		
		WebElement box =  driver.findElement(By.xpath("//div[@class='banner-right']"));
		WebElement dropdown = box.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Deposits");
		
		*/
		
		//cliciks on the  Login button
		driver.findElement(By.xpath("//*[@id=\"custom-button\"]/button")).click();
		//select the Loan Account Login
		driver.findElement(By.xpath("//input[@value='4']")).click();
		//cliicks on the login button
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		/*
		 * //clciks on the forexplus card login bton WebElement boxes =
		 * driver.findElement(By.xpath(
		 * "/html/body/div[4]/div[4]/div[1]/div[1]/div[1]/div")); boxes.click();
		 * 
		 * WebElement login = boxes
		 * .findElement(By.xpath("//div[@class='impMsgs']//div[1]//div[1]//div[1]//a[1]"
		 * )); login.click();
		 */
		//clicks on the Continue to NetBanking
		driver.findElement(By.xpath("//a[normalize-space()='Continue to NetBanking']")).click();
		
		//clciks on the login button
		driver.findElement(By.xpath("//img[@alt='Log In']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//clicks on the phonebanking
		driver.findElement(By.xpath("//a[normalize-space()='PhoneBanking']")).click();
		
		System.out.println("-----------Generating second window--------------");
		
		winds  = driver.getWindowHandles();
		iterate = winds.iterator();
		
		System.out.println(iterate.next()); //first window
		String second_window = iterate.next();
		System.out.println(second_window);
		
		Thread.sleep(5000);
		
		//go to the  first window
		driver.switchTo().window(first_window);
		//go to the second windoe
		driver.switchTo().window(second_window);
		
		capturescreenshoot();
		
		//close the  first window
		driver.switchTo().window(first_window);
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
		
		
		
		
		
	}	

}
