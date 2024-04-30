package TestCasesSpiceJet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasicSpiceJet.BasicSJ;
import SpiceJet_Project.Guvi_Project_02.BookingPageClass;

public class TC_04_BookingPageTest extends BasicSJ{
	@BeforeTest
	public void setup() {
		testName = "TC_04_BookingPageTest";
		testDescription = "Navigating to the SpiceJet Flight Booking website and Booking Trip";
		testCategory = "Regression";
		testAuthor = "Kavin Vikram ";
	}
	@Test(priority = 4)
	public void TC_04_BookingPageTest() throws Exception {
		BookingPageClass bp =new BookingPageClass(driver);
		bp.Ticketbooking("del");
		bp.book("Test", "User", "6382724043", "testuser03@gmail.com", "Tiruppur");
	    bp.reportStep(testCategory, testAuthor, testName);
	    
	}

}
