package EndToEndScenarios;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import POM.Home;
import POM.Login;
import POM.Projects;
import Utilities.BaseClass;
import Utilities.DataBaseUtility;
import Utilities.EndPointsLibrary;
import Utilities.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectInReactAppUpdateThroughApiAndDeleteInDataBase extends BaseClass {

	@Test
	public void createUpdateAndDelete() throws Throwable {
		
		String proId;
		
		DataBaseUtility dLib = new DataBaseUtility();
		
		//create project in ReactApplication
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		Login login = new Login(driver);
		Home home = new Home(driver);
		Projects project = new Projects(driver);
		
		driver.get(IConstants.REACTAPP_URL);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		login.login(IConstants.REACTAPP_USERNAME, IConstants.REACTAPP_PASSWORD);
		
		home.getProjects();
		
		project.createNewProject();
		
		project.projectName("PUBG");
		
		WebElement textbox = project.getTeamSizeTxtBox();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled',0);", textbox);
		
		project.sendTeamSize("9");
		
		project.createdBy("Drshn");
		
		WebElement dropDown = project.getStatusDrpDwn();
		
		Select sel = new Select(dropDown);
		sel.selectByValue("Created");
		
		project.submit();
		
		proId = project.getProjectIdThroughProjectName(driver, "PUBG");
		
		System.out.println(proId);
		
		System.out.println("Project created in GUI");
		
		driver.close();
		
		
		//update(PUT) project through API
		
		File file = new File("./Data/new.json");

		baseURI = "http://localhost";
		port = 8084;

		Response res = given()
		.body(file)
		.contentType(ContentType.JSON)

		.when()
		.put(EndPointsLibrary.updateProject+proId);
		
		String proName = res.jsonPath().get("projectName");
		
		System.out.println(proName);
		
		int actData = res.getStatusCode();
		
		Assert.assertEquals(actData, 200);
		
		System.out.println("Project Updated through API");
		
		
		//verify in DataBase
		
		dLib.connectDb();
		
		String query = "delete from project where project_name = '"+proName+"';";
		
		dLib.updateQuery(query);
		
		String query1 = "select * from project;";
		
		dLib.executeQueryAndValidate(query1, 4, proName);
	
	}

}
