package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicSJ;
import SpiceJet_Project.Guvi_Project_02.OneWayTripClass;

public class TC_02_OneWayTripTest  extends BasicSJ{
	@BeforeTest
	public void setup() {
		testName = "TC_02_OneWayTripTest";
		testDescription = "Navigating to the SpiceJet Flight Booking website and OneWayTrip ";
		testCategory = "Regression";
		testAuthor = "Kavin Vikram ";
		
	}
	@Test(priority = 2)
	public void TC_02_OneWayTripTest() throws Exception {
		OneWayTripClass ow=new OneWayTripClass(driver);
        ow.Ticketbooking("del");
		ow.reportStep(testCategory, testAuthor, testName);
	}

}
