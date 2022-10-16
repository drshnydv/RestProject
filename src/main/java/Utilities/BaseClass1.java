package Utilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass1 {
	
	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	
	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;
	
	@BeforeSuite
	public void bsConfig() throws Throwable {
		
		dLib.connectDb();
		
	}
	
	@BeforeClass
	public void bcConfig() {
		
		RequestSpecBuilder req = new RequestSpecBuilder();
		req.setBaseUri("http://localhost");
		req.setPort(8084);
		req.setContentType(ContentType.JSON);
		requestSpec = req.build();
		
	}
	
	@AfterClass
	public void acConfig() {
		
		ResponseSpecBuilder res = new ResponseSpecBuilder();
		res.expectContentType(ContentType.JSON);
		responseSpec = res.build();
		
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		
		dLib.closeDb();
		
	}

}