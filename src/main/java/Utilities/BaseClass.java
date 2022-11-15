package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass{
	
	public static WebDriver sDriver;
	
	public WebDriver driver; 
	
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
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    
	    driver.get(IConstants.REACTAPP_URL);
			
		RequestSpecBuilder req = new RequestSpecBuilder();
		req.setBaseUri("http://localhost");
		req.setPort(8084);
		req.setContentType(ContentType.JSON);
		requestSpec = req.build();
		sDriver = driver;
		
	}
	
	@AfterClass
	public void acConfig() {
		
		ResponseSpecBuilder res = new ResponseSpecBuilder();
		res.expectContentType(ContentType.JSON);
		responseSpec = res.build();
		
		driver.close();
		
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		
		dLib.closeDb();
		System.out.println("DataBase Closed");
		
	}

}