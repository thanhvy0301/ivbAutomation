package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.seatech.pages.common.common;
import com.seatech.test.login.LoginTestcase;

import io.qameta.allure.Attachment;

public class TestAllureListener implements ITestListener{
	 private WebDriver driver;
	 
	 common com;
	 LoginTestcase logintestcase;
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
	    	
	    }
	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
//	        Log.info(getTestName(iTestResult) + " test is passed.");
//	        //ExtentReports log operation for passed tests.
//	        ExtentTestManager.logMessage(Status.PASS, getTestDescription(iTestResult));
	    }
	    @Attachment(value = "Screenshot", type = "image/png")
	    public byte[] saveScreenshotOnFailure(WebDriver driver) {
	    	return ((TakesScreenshot) common.getDriver()).getScreenshotAs(OutputType.BYTES);
	    }
	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	    	saveScreenshotOnFailure(driver);
	    	saveLogs(iTestResult.getMethod().getConstructorOrMethod().getName());	    	
	    }
 	  	    
	    @Attachment(value="Stacktrace", type ="text/plain")
	    private String saveLogs(String message) {	    	
			return message;
			// TODO Auto-generated method stub			
		}
	    
	}
