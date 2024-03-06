
package resource;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BasePage;

public class Listeners extends BasePage implements ITestListener{

	
	public Listeners() throws IOException {
		super();
	}
	
	@Override  
	public void onTestFailure(ITestResult result) {

		try {
			takeSnapShot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override  
	public void onTestStart(ITestResult result) { 
		
		try {
			takeSnapShot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
		try {
			takeSnapShot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
		try {
			takeSnapShot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		try {
			takeSnapShot(result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
		
	
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
		
	}  
	
}
