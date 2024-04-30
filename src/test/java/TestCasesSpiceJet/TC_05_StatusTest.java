package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicSJ;
import SpiceJet_Project.Guvi_Project_02.StatusClass;

public class TC_05_StatusTest extends BasicSJ{
	@BeforeTest
	public void setup() {
		testName = "TC_05_StatusTest";
		testDescription = "Navigating to the SpiceJet Flight Booking website and StatusCheck";
		testCategory = "Regression";
		testAuthor = "Kavin Vikram ";
}
	@Test(priority = 5)
	public void TC_05_StatusTest() throws Exception {
		StatusClass sc=new StatusClass(driver);
		sc.status();
		sc.reportStep(testCategory, testAuthor, testName);
		
	}
	
	
	
}

