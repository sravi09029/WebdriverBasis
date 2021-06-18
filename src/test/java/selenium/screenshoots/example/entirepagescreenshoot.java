package selenium.screenshoots.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class entirepagescreenshoot {
	
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void capturescreenshoot() throws Exception {
		
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(":", "_")+".jpg";
		File screenshoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshoot, new File(".//screenshoot//"+filename));
		
	}
	
	public static void elementcapturedscreen(WebElement ele) throws IOException {
		
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(":", "_")+".jpg";
		
		File screenshoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullimag = ImageIO.read(screenshoot);
		Point point = ele.getLocation();
		int elewidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		
		BufferedImage elescreenshoot = fullimag.getSubimage(point.getX(),point.getY(), elewidth, eleHeight);
		ImageIO.write(elescreenshoot, "jpg", screenshoot);
		File screenshootlocation = new File(".//screenshoot//"+filename);
		FileUtils.copyFile(screenshoot, screenshootlocation);
		
	}
	
	public static void entiescreenshoot() throws IOException {
		
		Date d = new Date(); 
		String filename = d.toString().replace(":", "_").replace(":", "_")+".jpg"; 
		Screenshot screenshoot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver); 
		ImageIO.write(screenshoot.getImage(), "jpg", new File(".//screenshoot//"+filename));
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
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
		
		driver.get("http://www.way2automation.com/");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.cssSelector("img.header-logo__img"));
		entiescreenshoot();
		/*
		 * Date d = new Date(); String filename = d.toString().replace(":",
		 * "_").replace(":", "_")+".jpg"; Screenshot screenshoot = new
		 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
		 * takeScreenshot(driver); ImageIO.write(screenshoot.getImage(), "jpg", new
		 * File(".//screenshoot//"+filename));
		 */
		
		driver.close();
		driver.quit();
	
		
		
	}	

}
