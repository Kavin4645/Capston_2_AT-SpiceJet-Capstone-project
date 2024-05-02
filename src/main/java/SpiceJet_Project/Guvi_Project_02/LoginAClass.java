package SpiceJet_Project.Guvi_Project_02;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasicSpiceJet.BasicSJ;

public class LoginAClass extends BasicSJ{
	
	@FindBy (xpath="//div[text()='Login']")
	WebElement LoginButton;
	@FindBy(xpath  ="//input[@data-testid='user-mobileno-input-box']")
	WebElement LoginMobilNo;
	@FindBy(xpath ="//input[@data-testid='password-input-box-cta']")
	WebElement LoginPassword;
	@FindBy(xpath ="//div[@data-testid='login-cta']")
	WebElement ClickLogin;
	@FindBy(xpath ="//div[text()='Hi Test']")
	WebElement validLogin;
	


	public  LoginAClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this );
		
	}
	public LoginAClass ClickLogin() {
		ExpliciteWait(LoginButton);
		Click(LoginButton);
		return this;
		}
	public OneWayTripClass LoginAClass(String moblileno,String Password) throws Exception {
		Thread.sleep(10);
		enter(LoginMobilNo, moblileno);
		enter(LoginPassword, Password);
		Click(ClickLogin);
		if (Clickboo(validLogin)) {
			 test.pass("If the Hi Test is visible it is true");
		} else {
             test.fail("If the Hi Test is visible it is false");
            
		}
		
		return new OneWayTripClass(driver);
	}
	

}
