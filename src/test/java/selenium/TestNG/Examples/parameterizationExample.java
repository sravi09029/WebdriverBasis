package selenium.TestNG.Examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parameterizationExample {
	
	@Test(dataProvider = "getdata")
	public void dologin(String username, String password) {
		
		System.out.println(username+"-------------"+password);
	}
	
	
	@DataProvider
	public Object[][] getdata() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "sampathiravikumar@gmail.com";
		data[0][1] = "ravi09029";
		
		data[1][0] = "srks9441@gmail.com";
		data[1][1] = "Trabd3..36";
		
		data[2][0] = "selenium9441@gmail.com";
		data[2][1] = "uywetrwu";
		
		return data;
		
		
	}
	

}
