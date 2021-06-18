package selenium.Uploadfile.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class uploadfile {
	
	public static void main(String[] args) throws FindFailed, Exception {
		
		//upload img file wala code
		Screen screen = new Screen();
		// filename wala pattern
		Pattern img1 = new Pattern("C:\\Users\\RK\\Desktop\\Capture.JPG");
		//open wala patern
		Pattern img2 = new Pattern("C:\\Users\\RK\\Desktop\\open.JPG");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zamzar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"uploader-tool-step-1\"]/div/div/p[1]/button/span")).click();
		
		Thread.sleep(3000);
		
		//type the 
		screen.type(img1, "C:\\Users\\RK\\Downloads\\Manual Testing Guide.pdf");
		screen.click(img2);
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		
		
	}

}
