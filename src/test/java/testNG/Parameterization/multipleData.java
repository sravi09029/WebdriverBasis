package testNG.Parameterization;

import java.util.Hashtable;

import org.testng.annotations.Test;

public class multipleData {
	
	
	
	@Test(dataProviderClass = ParamaterizationExamples.class, dataProvider = "db1")
	public void TestUserLogin(Hashtable<String, String> table) {

		//System.out.println(username + "----" + password + "---" + is_correct + "-----" + City + "---" + age);

		System.out.println(table.get("username")+"----"+table.get("password")+"----"+table.get("is_correct")+ "-----" + table.get("age") + "----" + table.get("City"));
	}
	
	@Test(dataProviderClass = ParamaterizationExamples.class, dataProvider = "db1")
	public void TestUserReg(Hashtable<String, String> table) {
		
		System.out.println(table.get("firstname")+"----"+table.get("lastname")+"----"+table.get("postcode")+ "-----" + table.get("alerttext") + "----" + table.get("runmode"));
	}

}
