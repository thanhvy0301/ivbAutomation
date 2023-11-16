package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.seatech.page.common.common;

import io.qameta.allure.Attachment;

public class TestAllureListener implements ITestListener{
	 WebDriver driver;
	 common com;
	    public String getTestName(ITestResult result) {
	        return result.getTestName() != null ? result.getTestName()
	                : result.getMethod().getConstructorOrMethod().getName();
	    }

	    public String getTestDescription(ITestResult result) {
	        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	    }

	    @Override
	    public void onStart(ITestContext iTestContext) {	    	
	    	 //Initialize the com object
	        driver = common.getDriver();
	    }

		@Override
	    public void onFinish(ITestContext iTestContext) {
	    }

	    @Override
	    public void onTestStart(ITestResult iTestResult) {
//	        Log.info(getTestName(iTestResult) + " test is starting...");
//	        ExtentTestManager.saveToReport(iTestResult.getName(), iTestResult.getTestName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
//	        Log.info(getTestName(iTestResult) + " test is passed.");
//	        //ExtentReports log operation for passed tests.
//	        ExtentTestManager.logMessage(Status.PASS, getTestDescription(iTestResult));
	    }
	    @Attachment(value = "Screenshot", type = "image/png")
	    public byte[] saveScreenshotOnFailure() {
	        if (driver != null) {
	            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        } else {
	            System.out.println("Driver is null. Cannot take screenshot.");
	            return new byte[0];
	        }
	    }
	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        saveScreenshotOnFailure();
	        saveLogs(iTestResult.getMethod().getConstructorOrMethod().getName());
	    }
 	  	    
	    @Attachment(value="Stacktrace", type ="text/plain")
	    private String saveLogs(String message) {	    	
			return message;
			// TODO Auto-generated method stub			
		}
		@Override
	    public void onTestSkipped(ITestResult iTestResult) {
//	        Log.warn(getTestName(iTestResult) + " test is skipped.");
//	        ExtentTestManager.logMessage(Status.SKIP, getTestName(iTestResult) + " test is skipped.");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//	        Log.error("Test failed but it is in defined success ratio " + getTestName(iTestResult));
//	        ExtentTestManager.logMessage("Test failed but it is in defined success ratio " + getTestName(iTestResult));
	    }
	}
