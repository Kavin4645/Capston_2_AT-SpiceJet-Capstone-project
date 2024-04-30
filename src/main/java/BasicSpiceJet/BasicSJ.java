package BasicSpiceJet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import UtilesSpiceJet.UtilesSJ;

public class BasicSJ extends UtilesSJ {
	@BeforeSuite
	public void StartReport() {
		int randomnum = (int) (Math.random() * 10 + 1000);
		String path = System.getProperty("user.dir") + "/Reports/"+randomnum+"index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation SpiceJet Result");
		reporter.config().setDocumentTitle("Test Result");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kavin Vikram");

	}

	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}

	@BeforeMethod
	public void start() throws Exception {
		launchBrowser(readProperty("brouser"));
		getapplication("https://www.spicejet.com/");//"url"

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
