package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicSJ;
import SpiceJet_Project.Guvi_Project_02.RoundWayTripClass;


public class TC_03RoundWayTripTest extends BasicSJ{
	@BeforeTest
	public void setup() {
		testName = "TC_03RoundWayTripTest";
		testDescription = "Navigating to the SpiceJet Flight Booking website and RoundTrip";
		testCategory = "Regression";
		testAuthor = "Kavin Vikram ";
	}
	@Test (priority = 3)
	public void TC_03RoundWayTripTest() throws Exception {
		RoundWayTripClass rw=new RoundWayTripClass(driver);
		rw.changetwo("del");
		rw.reportStep(testCategory, testAuthor, testName);
	}



}
