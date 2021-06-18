package selenium.EventListeners.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


public class webListeners extends AbstractWebDriverEventListener{
	
	public void afterClickOn(WebElement element,WebDriver driver) {
		
		System.out.println("object is clicked");
	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("element locator is finded");
		
	}
	
	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("backword going");
	}

	
 public void afterNavigateForward(WebDriver driver) {
		
		System.out.println("forwarding going");
  }

}
