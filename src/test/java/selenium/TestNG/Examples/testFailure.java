package selenium.TestNG.Examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(cumListeners.Listeners.class)

public class testFailure {

	@Test
	public void dologin() {
		
		
		System.out.println("Capture screenshoot");
		Assert.fail("Failing the login teste");
		
	}
	
	
	@Test
	public void method() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		String actual_title =  driver.getTitle();
		System.out.println(actual_title);
		String expected_title = "Google";
		
		softasserts softassert = new softasserts();
		Assert.assertEquals(actual_title, expected_title);
		
		driver.close();
		driver.quit();
		
	}
	
}
