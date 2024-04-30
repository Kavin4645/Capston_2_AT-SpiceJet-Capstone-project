package SpiceJet_Project.Guvi_Project_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Report;

import BasicSpiceJet.BasicSJ;

public class StatusClass extends BasicSJ{
	@FindBy (xpath="//div[text()='check-in']")
	WebElement CheckIn;
	@FindBy (xpath="//div[text()='Web Check-In']")
	WebElement WebCheclkIn;
	@FindBy (xpath="//div[text()='flight status']")
	WebElement FlightStatus;
	@FindBy (xpath ="//div[text()='Flight Status']")
	WebElement FStatus;
	@FindBy (xpath ="//div[text()='manage booking']")
	WebElement Booking;
	@FindBy (xpath ="//div[text()='View / Manage Booking']")
	WebElement ManageBooking;
	
	
	
	public  StatusClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public StatusClass status() throws Exception {

		Click(CheckIn);
		if(WebCheclkIn.isDisplayed())
			reportStep("pass", "Checkin validation", testName);
		else
			reportStep("fail", "Checkin  not validation", testName);
		Thread.sleep(2000);
		
		Click(FlightStatus);
		if(FStatus.isDisplayed())
			reportStep("pass", "Checkin validation", testName);
		else
			reportStep("fail", "Checkin  not validation", testName);
		Thread.sleep(2000);
		
		Click(Booking);
		if(ManageBooking.isDisplayed())
			reportStep("pass", "Checkin validation", testName);
		else
			reportStep("fail", "Checkin  not validation", testName);
		Thread.sleep(2000);
		return this;
		
	}

}
