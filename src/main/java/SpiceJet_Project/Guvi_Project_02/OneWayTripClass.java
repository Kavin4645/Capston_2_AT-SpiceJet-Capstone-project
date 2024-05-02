package SpiceJet_Project.Guvi_Project_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicSpiceJet.BasicSJ;

public class OneWayTripClass extends BasicSJ {
	@FindBy(xpath = "//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div/div[2]/input")
	WebElement From;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']//div[text()='MAA']")
	WebElement To;

	@FindBy(xpath = "//div[@data-testid='departure-date-dropdown-label-test-id']")
	WebElement Date;

	@FindBy(xpath = "//div[@data-testid='undefined-month-May-2024']//div[@data-testid='undefined-calendar-day-25']")
	WebElement SelectDate;

	@FindBy(xpath = " //div[text()='Passengers']")
	WebElement Passenger;

	@FindBy(xpath = " //div[text()='Done']")
	WebElement Passengerdone;

	@FindBy(xpath = "//div[contains(text(),'Currency')]")
	WebElement currency;

	@FindBy(xpath = "//div[contains(text(),'INR')]")
	WebElement Selectcurrency;

	@FindBy(xpath = "//div[contains(text(),'Search Flight')]")
	WebElement SearchFlight;

	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement Next;

	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement ClickNext;

	

	public OneWayTripClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public RoundWayTripClass Ticketbooking(String start) {

		enter(From, start);
		Click(To);
		ExpliciteWait(Date);
		Click(Date);
		Click(Date);
		Click(SelectDate);
		Click(Next);
		ExpliciteWait(ClickNext);
		Click(ClickNext);
		return new RoundWayTripClass(driver);

	}
	


}
