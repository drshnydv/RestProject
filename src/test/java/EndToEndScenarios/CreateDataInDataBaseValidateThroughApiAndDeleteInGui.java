package EndToEndScenarios;

import org.testng.annotations.Test;

import POM.Home;
import POM.Login;
import POM.Projects;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import Utilities.BaseClass;
import Utilities.DataBaseUtility;
import Utilities.EndPointsLibrary;
import Utilities.ExcelUtility;
import Utilities.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateDataInDataBaseValidateThroughApiAndDeleteInGui extends BaseClass{


	@Test
	public void createValidateAndDelete() throws Throwable {

		//creating project in DataBase
		
		DataBaseUtility dLib = new DataBaseUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		String proId = eLib.getExcelData("EndToEnd", 4, 0);
		String createdBy = eLib.getExcelData("EndToEnd", 4, 1);
		String CreatedDate = eLib.getExcelData("EndToEnd", 4, 2);
		String proName = eLib.getExcelData("EndToEnd", 4, 3);
		String status = eLib.getExcelData("EndToEnd", 4, 4);
		String teamsize = eLib.getExcelData("EndToEnd", 4, 5);
		int teamSize = Integer.valueOf(teamsize);
		String statuscode = eLib.getExcelData("EndToEnd", 1, 5);
		int statusCode = Integer.valueOf(statuscode);
		
		dLib.connectDb();

		String query = "INSERT INTO project VALUES( '"+proId+"' , '"+createdBy+"', '"+CreatedDate+"', '"+proName+"', '"+status+"', '"+teamSize+"')";

		dLib.updateQuery(query);
		
		String query1 = "select * from project";
		
		dLib.executeQueryAndValidate(query1, 4, "TYSS9876");
		
		System.out.println("Project Created In DataBase");
		
		//validating project created or not through Api
		
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when()
		.get(EndPointsLibrary.getSingleProject+proId);
		
		int code = res.getStatusCode();
		
		Assert.assertEquals(code, statusCode);
		
		System.out.println("Project Verified Through API");
		
		
		//delete project in ReactApp
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Login login = new Login(driver);
		Home home = new Home(driver);
		Projects project = new Projects(driver);
		
		driver.get("http://localhost:8084");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		login.login(IConstants.REACTAPP_USERNAME, IConstants.REACTAPP_PASSWORD);
		
		home.getProjects();
	
		project.deleteProjectThroughProjectId(driver, proId);
		
		project.clickDeleteInPopUP();
		
		driver.close();
		
		System.out.println("Project Deleted");
		
	}

}