package SpiceJet_Project.Guvi_Project_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicSpiceJet.BasicSJ;

public class BookingPageClass extends BasicSJ{
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
	
	@FindBy(xpath="//div[text()='Mr']")
	WebElement ClickMr;

	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	WebElement LastName;
	
	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	WebElement PhoneNumber;
	
	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement Email;
	
	@FindBy(xpath = "//div[text()='India']")
	WebElement SelectCountry;
	
	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	WebElement City;

	@FindBy(xpath = "//div[text()='I am flying as the primary passenger']")
	WebElement CheckBox;
	
	@FindBy(id = "traveller-0-first-traveller-info-input-box")
	WebElement passengerfname;
	
	@FindBy(id = "traveller-0-last-traveller-info-input-box")
	WebElement passengerlname;
	
	@FindBy(id = "sc-member-mobile-number-input-box")
	WebElement paswsengerphonenumber;
	
	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement continue1;
	
	@FindBy(xpath = "//*[@id=\"travellers-view\"]/div[2]/div/div/div[2]")
	WebElement continue2;
	
	@FindBy(xpath ="")
	WebElement  CreNumber;

	public BookingPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public BookingPageClass Ticketbooking(String start) throws InterruptedException {

		enter(From, start);
		Click(To);
		ExpliciteWait(Date);
		Click(Date);
		Click(Date);
		Click(SelectDate);
		Click(Next);
		ExpliciteWait(ClickNext);
		Click(ClickNext);
		return this;

	}
	
	public  BookingPageClass book(String fname, String lname, String pNo, String email, String city) throws InterruptedException {
		Thread.sleep(1000);
		ExpliciteWait(ClickMr);
		Click(ClickMr);
		Click(ClickMr);
		enter(FirstName, fname);
		enter(LastName, lname);
		enter(PhoneNumber, pNo);
		enter(Email, email);
		Click(SelectCountry);
		enter(City, city);
		Click(CheckBox);
		Click(continue1);
		
		Click(continue2);
		Click(continue2);
		return this;

	}
	
	/*public StatusClass payment (String crNumb) {
		enter(CreNumber, crNumb);
		return new StatusClass(driver);
	}*/

	

}
