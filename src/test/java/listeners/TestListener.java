package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener 
		implements ITestListener {
	
	//Extent Report 
	
	ExtentReports extent = ExtentManager.getInstance();
	
	//ThreadSafe test logger
	
	ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	//Test Logger
	ExtentTest extentTest;
	
	
	//Before Test Start
	
	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extent.createTest(result.getMethod().getDescription());
		
		test.set(extentTest);
		
		test.get().log(Status.INFO, "Test Execution Started");
	}
	
	
	//On Test Success
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.get().log(Status.PASS, "Test Passed Successfuly");
		
		test.get().log(Status.INFO, "Test Execution Completed");
		
		test.remove();
	}
	
	//On Test Failure
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test.get().log(Status.FAIL, "Test Failed");
		
		//Print Exception
		
		test.get().fail(result.getThrowable());
		
		//Capture Screenshot
		try {
			WebDriver driver =

			        ((BaseTest) result.getInstance())
			        .getDriver();
			
			String screenshotPath = ScreenshotUtil.captureScreenShot(driver,
													result.getMethod().getDescription());
			
			
			//Attach ScreenShot
			test.get().addScreenCaptureFromPath(screenshotPath);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		test.get().log(Status.INFO, "Test Execution Completed");
		
		test.remove();
	}
	
	//On Test Skipped
	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.get().log(Status.SKIP, "Test Skipped");
		
		test.remove();
		
	}
	
	//After all tests
	
	@Override
	public void onFinish(ITestContext  context) {
		
		extent.flush();
	}
	
	

}
