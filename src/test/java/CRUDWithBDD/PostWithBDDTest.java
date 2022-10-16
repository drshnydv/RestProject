package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Endpoint;

import Utilities.EndPointsLibrary;
import Utilities.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostWithBDDTest {
	
	@Test
	public void PostTest() {
		
		JavaUtility j = new JavaUtility();
		
		int ran = j.RandomNumber();
		
		JSONObject job = new JSONObject();
		
		job.put( "createdBy" , "Drshn");
		job.put("projectName" , "ydvvaa"+ran);
		job.put("status" , "Active");
		job.put("teamSize" , "4");

		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.post(EndPointsLibrary.createProject)
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201);
		
	}

}