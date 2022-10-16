package CREDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
	
	@Test
	public void createProjectTest() {
		
	JSONObject job = new JSONObject();
	
	job.put( "createdBy" , "Drshn");
	job.put("projectName" , "Ydv11");
	job.put("status" , "Active");
	job.put("teamSize" , 4);
	
	RequestSpecification reqsp = RestAssured.given();
	reqsp.body(job);
	reqsp.contentType(ContentType.JSON);
	
	Response respo = reqsp.post("http://localhost:8084/addProject");
	
	ValidatableResponse valRespo = respo.then();
	
	valRespo.assertThat().contentType(ContentType.JSON);
	valRespo.assertThat().statusCode(201);
	
	valRespo.log().all();
		
	}

}