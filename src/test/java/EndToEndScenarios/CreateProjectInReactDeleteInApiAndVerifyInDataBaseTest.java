package EndToEndScenarios;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Endpoint;

import POM.Home;
import POM.Login;
import POM.Projects;
import Utilities.BaseClass;
import Utilities.DataBaseUtility;
import Utilities.EndPointsLibrary;
import Utilities.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectInReactDeleteInApiAndVerifyInDataBaseTest extends BaseClass {

	String projectId;
	
	@Test
	public void creteDeleteAndVerify() throws Throwable {
		
		String proName = "DeleteProject";
		
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
		
		project.projectName(proName);
		
		WebElement textbox = project.getTeamSizeTxtBox();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='5'", textbox);
		
		project.createdBy("Drshn");
		
		WebElement dropDown = project.getStatusDrpDwn();
		
		Select sel = new Select(dropDown);
		sel.selectByValue("Created");
		
		project.submit();
		
		projectId = project.getProjectIdThroughProjectName(driver, proName);
		
		System.out.println("Project created in GUI");
		
		driver.close();
		
		
		//delete project through API
		
		when()
		.delete(EndPointsLibrary.deleteProject+projectId)
		
		.then()
		.assertThat()
		.statusCode(204);
		
		System.out.println("Project Deleted through API");
		
		
		//verify in DataBase
		
		dLib.connectDb();
		
		String query = "select project_id from project;";
		
		dLib.executeQueryAndValidate(query, 1, projectId);
	}

}
