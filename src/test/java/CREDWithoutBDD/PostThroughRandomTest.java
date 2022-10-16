package CREDWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostThroughRandomTest {
	
	@Test
	public void postRandom() {
		
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		JSONObject job = new JSONObject();
		
		job.put( "createdBy" , "Drshn");
		job.put("projectName" , "ydv"+random);
		job.put("status" , "Active");
		job.put("teamSize" , 4);
		
		RequestSpecification req = RestAssured.given();
		
		req.body(job);
		req.contentType(ContentType.JSON);
		
		
			
		Response res = req.post("http://localhost:8084/addProject");
		
		ValidatableResponse re = res.then();
		re.assertThat().statusCode(201);
		re.log().all();
		
	}

}
