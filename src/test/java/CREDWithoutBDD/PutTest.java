package CREDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutTest {
	
	@Test
	public void changeResource() {
		
		JSONObject job = new JSONObject();
		
		job.put( "createdBy" , "DrshnYdv");
		job.put("projectName" , "Ydv");
		job.put("status" , "Active");
		job.put("teamSize" , 5);
		
		RequestSpecification re = RestAssured.given();
		
		re.body(job);
		re.contentType(ContentType.JSON);
		
		Response res = re.put("http://localhost:8084/projects/TY_PROJ_1403");
		
		ValidatableResponse r = res.then();
		
		r.assertThat().statusCode(200);
		
		r.log().all();
		
		
	}

}
