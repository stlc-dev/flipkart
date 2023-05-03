package testClasses;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import utilities.CaptureSS;
import utilities.StaticBrowser;

public class BaseClass {
	WebDriver driver;
	public static ExtentReports report;
	public static ExtentHtmlReporter extent;
	public static ExtentTest logger;

	@Parameters({ "browser" })

	@BeforeTest
	public void beforetest(String browser) {
		WebDriver driver = StaticBrowser.openbrowser(browser, "https://www.flipkart.com");
		this.driver = driver;
		extent = new ExtentHtmlReporter(
				"test-output" + File.separator + "Report" + File.separator + System.currentTimeMillis() + ".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		// Failure TestCases Screenshot using ITestResult(TestNG Listener)
		if (result.getStatus() == ITestResult.FAILURE) {
			String source = CaptureSS.screenshot(driver);
			logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(source).build());
		}
		// Pass TestCases Screenshot using ITestResult(TestNG Listener)
		else if (result.getStatus() == ITestResult.SUCCESS) {
			String source = CaptureSS.screenshot(driver);
			logger.pass("Test Case Passed", MediaEntityBuilder.createScreenCaptureFromPath(source).build());
		}
		report.flush();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
