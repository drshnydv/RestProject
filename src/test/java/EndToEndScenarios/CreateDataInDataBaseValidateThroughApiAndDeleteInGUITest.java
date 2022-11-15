package EndToEndScenarios;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.Home;
import POM.Login;
import POM.Projects;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
import Utilities.BaseClass;
import Utilities.EndPointsLibrary;
import Utilities.IConstants;
import io.restassured.response.Response;

import org.testng.Assert;

@Listeners(Utilities.ListnersClass.class)
public class CreateDataInDataBaseValidateThroughApiAndDeleteInGUITest extends BaseClass {

	String query;
	String query1;
	String proId ;
	int statusCode;

	@Test
	public void test() throws Throwable {

		//creatingProjectInDataBase

		proId = eLib.getExcelData("EndToEnd", 4, 0)+jLib.RandomNumber();
		String createdBy = eLib.getExcelData("EndToEnd", 4, 1);
		String CreatedDate = eLib.getExcelData("EndToEnd", 4, 2);
		String proName = eLib.getExcelData("EndToEnd", 4, 3);
		String status = eLib.getExcelData("EndToEnd", 4, 4);
		String teamsize = eLib.getExcelData("EndToEnd", 4, 5);
		int teamSize = Integer.valueOf(teamsize);
		String statuscode = eLib.getExcelData("EndToEnd", 1, 5);
		statusCode = Integer.valueOf(statuscode);

		query = "INSERT INTO project VALUES( '"+proId+"' , '"+createdBy+"', '"+CreatedDate+"', '"+proName+"', '"+status+"', '"+teamSize+"')";

		dLib.updateQuery(query);

		query1 = "select * from project";

		dLib.executeQueryAndValidate(query1, 1, proId);

		System.out.println("Project Created In DataBase");

		//validatingProjectThroughApi

		Response res = given().spec(requestSpec)

				.when()
				.get(EndPointsLibrary.getSingleProject+proId);

		int code = res.getStatusCode();

		res.getBody();

		Assert.assertEquals(code, statusCode);

		System.out.println("Project Verified Through API");

		//deleteProjectInReactApp

		Login login = new Login(driver);
		Home home = new Home(driver);
		Projects project = new Projects(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		login.login(IConstants.REACTAPP_USERNAME, IConstants.REACTAPP_PASSWORD);

		home.getProjects();

		project.deleteProjectThroughProjectId(driver, proId);

		project.clickDeleteInPopUP();

		System.out.println("Project Deleted");

	}

}