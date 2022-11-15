package EndToEndScenarios;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import POM.Home;
import POM.Login;
import POM.Projects;
import Utilities.BaseClass;
import Utilities.EndPointsLibrary;
import Utilities.IConstants;
import io.restassured.response.Response;

@Listeners(Utilities.ListnersClass.class)
public class CreateProjectInReactAppUpdateThroughApiAndDeleteInDataBaseTest extends BaseClass {

	String proId;
	String proName;

	@Test
	public void test() throws Throwable {

		//createProjectInReactApp

		Login login = new Login(driver);
		Home home = new Home(driver);
		Projects project = new Projects(driver);

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

		//updateProjectThroughAPI

		File file = new File("./Data/new.json");

		Response res = given().spec(requestSpec)
				.body(file)

				.when()
				.put(EndPointsLibrary.updateProject+proId);

		proName = res.jsonPath().get("projectName");

		System.out.println(proName);

		int actData = res.getStatusCode();

		Assert.assertEquals(actData, 200);

		System.out.println("Project Updated through API");

		//verifyInDataBase

		String query = "delete from project where project_name = '"+proName+"';";

		dLib.updateQuery(query);

		String query1 = "select * from project;";

		dLib.executeQueryAndValidate(query1, 4, proName);

	}

}