package cumListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
		Reporter.log("<a href = \"E:\\screenshot\\error.jpg\" target=\"_blank\">Screenshot link</a>");
		Reporter.log("<br>");
		Reporter.log("<a href = \"E:\\screenshot\\error.jpg\" target=\"_blank\">img height=200 width=200 src=\"E:\\screenshot\\error.jpg\"</a>");
		System.out.println("Test success ---"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reporting.escape-output","false");
		//Reporter.log("screen shoot link");
		Reporter.log("<a href = \"E:\\screenshot\\error.jpg\" target=\"_blank\">Screenshot link</a>");
		Reporter.log("<br>");
		Reporter.log("<a href = \"E:\\screenshot\\error.jpg\" target=\"_blank\">img height=200 width=200 src=\"E:\\screenshot\\error.jpg\"</a>");
		System.out.println("Capture screenshoot ---"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Skipped ---"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		System.out.println("Failed but with success percentage ---"+result.getName());
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	
	
	
}
