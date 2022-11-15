package FunctionalTesting;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.DataBaseUtility;
import Utilities.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Listeners(Utilities.ListnersClass.class)
public class EndToEndTest {
	
	String projectName = "EndToEnd";
	String projectId;
	
	@Test(priority = 1)
	public void addProjecTest() {
		
		JSONObject job = new JSONObject();
		
		job.put( "createdBy" , "Darshan");
		job.put("projectName" , projectName);
		job.put("status" , "Active");
		job.put("teamSize" , 4);
		
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
		
		projectId=res.jsonPath().get("projectId");
		
		System.out.println("Project is created through API");
		
	}
	
	@Test(priority = 2)
	public void getIdInReactTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8084");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("usernmae")).sendKeys(IConstants.REACTAPP_USERNAME);
		
		driver.findElement(By.id("inputPassword")).sendKeys(IConstants.REACTAPP_PASSWORD);
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//li/a[text()='Project']")).click();
		
		List<WebElement> proId = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		
		for (WebElement webElement : proId) {
			
			String name = webElement.getText();
			
			if(name.equals(projectId)) {
				
				System.out.println("Project Present in GUI");
				
			}
			
		}
		
	}
	
	@Test(priority = 3)
	public void validateInDataBase() throws Throwable {
		
		DataBaseUtility Dlib = new DataBaseUtility();
		
		Dlib.connectDb();
		
		String query = "select project_id from project;";
		
		Dlib.executeQueryAndValidate(query, 1, projectId);
		
	}

}