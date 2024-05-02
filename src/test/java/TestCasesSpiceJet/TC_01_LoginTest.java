package TestCasesSpiceJet;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicSJ;
import SpiceJet_Project.Guvi_Project_02.LoginAClass;

public class TC_01_LoginTest extends BasicSJ{
	@BeforeTest
	public void setup() {
		testName = "TC_01_LoginTest";
		testDescription = "Navigating to the SpiceJet Flight Booking website and login";
		testCategory = "Regression";
		testAuthor = "Kavin Vikram ";
		sheetName = "Sheet1";
	}
	@Test(dataProvider="getFromExcel",priority = 1)
	public void TC_01_LoginTest(String moblileno,String Password) throws Exception {
		LoginAClass lc=new LoginAClass(driver);
		lc.ClickLogin();
		lc.LoginAClass(moblileno, Password);
		
		lc.reportStep(testCategory, testAuthor, testName);
		
	}

}
