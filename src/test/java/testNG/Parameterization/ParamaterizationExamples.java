package testNG.Parameterization;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelReader;

public class ParamaterizationExamples {

	public static ExcelReader excel = null;

	@Test(dataProvider = "db1")
	public void TestUserLogin(Hashtable<String, String> table) {

		//System.out.println(username + "----" + password + "---" + is_correct + "-----" + City + "---" + age);

		System.out.println(table.get("username")+"----"+table.get("password")+"----"+table.get("is_correct")+ "-----" + table.get("age") + "----" + table.get("City"));
	}
	
	@Test(dataProvider = "db1")
	public void TestUserReg(Hashtable<String, String> table) {
		
		System.out.println(table.get("firstname")+"----"+table.get("lastname")+"----"+table.get("postcode")+ "-----" + table.get("alerttext") + "----" + table.get("runmode"));
	}

	@DataProvider(name="db1")
	public Object[][] getData(Method m) throws FileNotFoundException {
		
		Object[][] data = null;
		
		if(m.getName().equals("TestUserLogin")) {

		if (excel == null) {

			try {
				excel = new ExcelReader("E:\\SeleniumProject\\basics\\src\\test\\resources\\excel\\testdata.xlsx");

			} catch (Exception e) {

				System.out.println("Exception Occured");
			}
		}
		// added the sheetName, rows,cols
		String sheetName = "details_check";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		 data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;

			}
		}
		
	}  else if(m.getName().equals("TestUserReg")) {
		
		      // added the sheetName, rows,cols
				String sheetName = "AddCustomerTest";
				int rows = excel.getRowCount(sheetName);
				int cols = excel.getColumnCount(sheetName);

				 data = new Object[rows - 1][1];

				Hashtable<String, String> table = null;
				for (int rowNum = 2; rowNum <= rows; rowNum++) {
					table = new Hashtable<String, String>();
					for (int colNum = 0; colNum < cols; colNum++) {

						// data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

						table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
						data[rowNum - 2][0] = table;

					}
				}
		
	      }

		return data;

	}


}
