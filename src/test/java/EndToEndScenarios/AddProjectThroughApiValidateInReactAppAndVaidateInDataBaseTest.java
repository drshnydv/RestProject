package EndToEndScenarios;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import POM.Home;
import POM.Login;
import POM.Projects;
import PojoUtiity.postThroughPojo;
import Utilities.BaseClass1;
import Utilities.EndPointsLibrary;
import Utilities.IConstants;
import Utilities.RestAssuredUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import junit.framework.Assert;

public class AddProjectThroughApiValidateInReactAppAndVaidateInDataBaseTest extends BaseClass1 {
	
	@Test
	public void addAndValidateProjectTest() throws Throwable {
		
		//add project through API
		RestAssuredUtility rLib = new RestAssuredUtility();
		
		String createdBy = eLib.getExcelData("EndToEnd", 1, 0);
		String proName = eLib.getExcelData("EndToEnd", 1, 1);
		String status = eLib.getExcelData("EndToEnd", 1, 2);
		String teamsize = eLib.getExcelData("EndToEnd", 1, 3);
		int teamSize = Integer.valueOf(teamsize);
		String statusCodeLine = eLib.getExcelData("EndToEnd", 1, 4);
		
		String extData = statusCodeLine;
		String projectId;
		
		postThroughPojo po = new postThroughPojo(createdBy, proName+jLib.RandomNumber(), status, teamSize);
		
		 Response res = given().spec(requestSpec)
		.body(po)
		
		.when()
		.post(EndPointsLibrary.createProject);
		
		projectId = rLib.getJsonData(res, "projectId");
		
		String actData = res.getStatusLine();
		
		Assert.assertEquals(extData, actData);
				
		System.out.println("Project is created through API");
		

		//validating project in ReactApp
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Login login = new Login(driver);
		Home home = new Home(driver);
		Projects project = new Projects(driver);
		
		driver.get("http://localhost:8084");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		login.login(IConstants.REACTAPP_USERNAME, IConstants.REACTAPP_PASSWORD);
		
		home.getProjects();
		
		List<WebElement> proId = project.getAllProjectIds();
		
		
		for (WebElement webElement : proId) {
			
			String name = webElement.getText();
			
			if(name.equals(projectId)) {
				
				System.out.println("Project Present in GUI");
				break;
				
			}
			
		}
		
		
		//validating project in DataBase
		
		String query = "select * from project;";
		
		dLib.executeQueryAndValidate(query, 1, projectId);
			
	
	}
	
}