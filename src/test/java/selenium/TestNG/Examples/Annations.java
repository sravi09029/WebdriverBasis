package selenium.TestNG.Examples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annations {
	
	
	@BeforeSuite
	public void connectdb() {
		
		System.out.println("connection is done --- before suite");
	}
	
	@AfterSuite
	public void disconnectdb() {
		
		System.out.println("disconnect db ----after suite");
	}
	
	
	@BeforeTest
	public void createdbconn() {
		
		System.out.println("Creating DB connection -- before test");
	}
	
	@AfterTest
	public void closedbconn() {
		
		System.out.println("disconnect db connection --- after db");
	}
	
	
	@BeforeMethod
	public void openbrowser() {
		
		System.out.println("Launching browser ----- before method");
	}
	
	@AfterMethod
	public void closebowser() {
		
		System.out.println("Closing bowser --- after method");
	}
	
	
	@Test
	public void dologin() {
		
		System.out.println("Executing login test");
	}
	
	@Test
	public void douserReg() {
		
		System.out.println("Executing User Reg Test");
	}
	
	
	
	

	
	
}
