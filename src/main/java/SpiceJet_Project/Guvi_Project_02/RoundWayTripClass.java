package SpiceJet_Project.Guvi_Project_02;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicSpiceJet.BasicSJ;

public class RoundWayTripClass extends BasicSJ{

	@FindBy(xpath="//div[text()='round trip']")
	WebElement RoundTrip;
	
	@FindBy(xpath="//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input")
	WebElement Form;
	@FindBy(xpath="//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='MAA']")
	WebElement To;
/*	@FindBy(id="//div[@data-testid='departure-date-dropdown-label-test-id']")
	WebElement clickDate;*/
	@FindBy(xpath="//div[@data-testid='undefined-month-May-2024']//div[@data-testid='undefined-calendar-day-11']")
	WebElement SelectFromDate;
	@FindBy(xpath="//div[@data-testid='undefined-month-May-2024']//div[@data-testid='undefined-calendar-day-25']")
	WebElement SelecttoDate;
	@FindBy(id="home-page-travellers")
	WebElement Passenger;
	@FindBy(xpath="//div[contains(text(),'Currency')]")
	WebElement currency;
	@FindBy(xpath="//div[contains(text(),'INR')]")
	WebElement Selectcurrency;
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement SearchFlight;
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']")
	WebElement ClickNext;


	
	public   RoundWayTripClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public BookingPageClass changetwo(String start) throws InterruptedException {
		Click(RoundTrip);
		ExpliciteWait(Form);
		enter(Form, start);
		Click(To);
		//Click(clickDate);
		Click(SelectFromDate);
		Click(SelecttoDate);
		Thread.sleep(100);
		Click(SearchFlight);
		Click(ClickNext);
		return new BookingPageClass(driver);
	}
	
	
}
