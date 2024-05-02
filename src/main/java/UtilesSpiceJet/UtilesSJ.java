package UtilesSpiceJet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class UtilesSJ {

	public static WebDriver driver;
	public String testName;
	public String testDescription;
	public String testCategory;
	public String testAuthor;
	public static ExtentTest test;
	public static ExtentReports extent;
	public String sheetName;

	public static String readProperty(String key) throws IOException {
		String projectPath = System.getProperty("user.dir");
		File file = new File(projectPath + "./configSJ.properties");
		FileInputStream fileinput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileinput);
		return prop.get(key).toString();

	}

	public static void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			ChromeOptions obj = new ChromeOptions();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions obj = new FirefoxOptions();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
			EdgeOptions obj = new EdgeOptions();
		} else {
			System.out.println("Opening Chrome browser as a default brouser");
			ChromeOptions obj = new ChromeOptions();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

	public static void ExpliciteWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public static void getapplication(String url) {
		driver.get(url);
	}

	public static void Alert(WebElement element) {
		driver.switchTo().alert().accept();
	}
	public static void Alertdismiss(WebElement element) {
		driver.switchTo().alert().dismiss();
	}
	public static void Click(WebElement element) {
	    element.click();
	}
	public static boolean Clickboo(WebElement element) {
	    element.getText();
	    return true;
		
	}
	
	
	public static void enter(WebElement element,String text) {
		element.click();
		element.sendKeys(text);
	    
	}
	public static void enter2(WebElement element ,String text) {
		
		element.sendKeys(text);
		element.click();
	}

	public static int screenShot(String testName) throws InterruptedException, Exception, Exception {
		int randomnum = (int) (Math.random() * 10 + 1000);
		Thread.sleep(1000);
		String projectpatth = System.getProperty("user.dir");
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File(projectpatth + "/ScreenShot/" + testName + randomnum + ".png"));
		return randomnum;
	}

	public void reportStep(String stepDetails, String stepStatus, String testName) throws Exception, Exception {
		int randomnum = screenShot(testName);
		String projectPath = System.getProperty("user.dir");

		if (stepStatus.equalsIgnoreCase("pass")) {
			Assert.assertTrue(true, stepDetails);
			test.pass(stepDetails, MediaEntityBuilder
					.createScreenCaptureFromPath(projectPath + "/Screenshot/" + testName + randomnum + ".png").build());
		} else if (stepStatus.equalsIgnoreCase("fail")) {
			Assert.fail("Step Failed: " + stepDetails);
			test.fail(stepDetails, MediaEntityBuilder
					.createScreenCaptureFromPath(projectPath + "/Screenshot/" + testName + randomnum + ".png").build());
		}

	}
	
public static Object[][] dataReader(String sheetName) throws IOException {
		
		XSSFWorkbook workBook = new XSSFWorkbook("D:/loginTestSJ.xlsx");
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][columns];
		for (int r = 1; r <= rows; r++) {
			for (int c = 0; c < columns; c++) {
				data[r-1][c] = sheet.getRow(r).getCell(c).toString();
				System.out.println(sheet.getRow(r).getCell(c).toString());
			
				
			}
		}
		workBook.close();
		return data;
	}

}
