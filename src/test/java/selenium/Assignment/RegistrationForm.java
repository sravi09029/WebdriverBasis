package selenium.Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationForm {
	
	
	public static String browser = "chrome";
	public static WebDriver driver;
	
	 public  static boolean iselementpresent(By by) {
		 
		 int size = driver.findElements(by).size();
		 if(size==0) {
			 
			 return false;
		 } else {
			 return true;
		 }
		 
	 }

	public static void main(String[] args) throws Exception {
		
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
		
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("qa.way2automation");
		search.sendKeys(Keys.ENTER); 
		
		WebElement Welcome_to_the_Testsite = driver.findElement(By.xpath("//h3[text()='Welcome to the Test Site - Way2Automation']"));
		Welcome_to_the_Testsite.click();
		
		String actual_title = driver.getTitle();
		System.out.println("Title is: "+actual_title);
		String exp_title = "Welcome to the Test Site";
		if(actual_title.equals(exp_title) == true) {
			System.out.println("Title is passed");
		} else {
			
			System.out.println("title is failed");
		}
		
		boolean name_present = iselementpresent(By.cssSelector("input[name='name']"));
		System.out.println(name_present);
		
		boolean phone_present = iselementpresent(By.cssSelector("input[name='phone']"));
		System.out.println(phone_present);
		
		boolean email_present = iselementpresent(By.cssSelector("input[name='email']"));
		System.out.println(email_present);
		 
		boolean  country_present = iselementpresent(By.cssSelector("select[name='country']"));
		System.out.println(country_present);
		
		boolean city_present = iselementpresent(By.cssSelector("input[name='city']"));
		System.out.println(city_present);
		
		boolean username_present = iselementpresent(By.cssSelector("input[name='username']"));
		System.out.println(username_present);
		
		boolean password_present = iselementpresent(By.cssSelector("input[name='password']"));
		System.out.println(password_present);
		
		boolean submit_present = iselementpresent(By.cssSelector("input[class='button']"));
		System.out.println(submit_present);
		
		
		//print the all dorpdown list
		List<WebElement> dropdown_list = driver.findElements(By.tagName("option"));
		System.out.println(dropdown_list.size());
		
		for(int i = 0; i<dropdown_list.size();i++) {
			
			System.out.println(dropdown_list.get(i).getAttribute("value"));
		}
		
		
		//enter the name and  clicks  on the submit button
		WebElement name =  driver.findElement(By.cssSelector("input[name='name']"));
		name.sendKeys("Ravi kumar");
		
		
		
		WebElement submit = driver.findElement(By.cssSelector("div[id='load_box'] input[value='Submit']"));
		submit.click();
		
		WebElement phone = driver.findElement(By.cssSelector("input[name='phone']"));
		phone.sendKeys("9441608483");
		submit.click();
		
		WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
		email.sendKeys("sampathiravikumar@gmail.com");
		submit.click();
		
		WebElement city = driver.findElement(By.cssSelector("input[name='city']"));
		city.sendKeys("pulivendula");
		submit.click();
	
		//WebElement username = driver.findElement(By.cssSelector("input[name='username']")); // getting  erorr message as Exception in thread "main" org.openqa.selenium.ElementNotInteractableException: element not interactable
		WebElement username = driver.findElement(By.cssSelector("div[id='load_box'] input[name='username']"));
		username.sendKeys("ravi009");
		submit.click();
		
		
		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
		
		
	}

}
