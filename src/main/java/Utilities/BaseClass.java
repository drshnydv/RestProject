package Utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BaseClass {
	
	DataBaseUtility dLib = new DataBaseUtility();
	
	@BeforeSuite
	public void ConfigBS() throws Throwable {
		
		dLib.connectDb();
		
		baseURI = "http://localhost";
		port = 8084;
		
	}
	
	@AfterSuite
	public void ConfigAS() throws Throwable {
		
		dLib.closeDb();
		
	}

}
