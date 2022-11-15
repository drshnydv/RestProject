package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersClass extends BaseClass implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		
		System.out.println(testName + "============Execute & I'm Listnening============");
		
		//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass1.sDriver);
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
		
		File scrFile = ts.getScreenshotAs(OutputType.FILE);
		File dstFile = new File("./screenshot/"+testName+".png");
		try {
			FileUtils.copyFile(scrFile, dstFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("============Test End============");
		
		
	}
	
}