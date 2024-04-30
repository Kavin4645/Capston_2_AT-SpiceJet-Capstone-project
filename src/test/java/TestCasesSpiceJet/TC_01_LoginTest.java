package TestCasesSpiceJet;

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
		
	}
	@Test(priority = 1)
	public void TC_01_LoginTest() throws Exception {
		LoginAClass lc=new LoginAClass(driver);
		lc.ClickLogin();
		lc.LoginAClass("6382724043", "TestUser@123");
		lc.reportStep(testCategory, testAuthor, testName);
		
	}

}
