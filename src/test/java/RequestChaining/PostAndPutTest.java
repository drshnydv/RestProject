package RequestChaining;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import PojoUtiity.PostThroughPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndPutTest {

	@Test
	public void postAndPut() {
		
		String projectName = "NewProjectName";

		baseURI = "http://localhost";
		port = 8084;

		PostThroughPojo po = new PostThroughPojo("drshn", "OldName", "Active", 8);

		 Response res = given()
		.body(po)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject");
		
		String proId = res.jsonPath().get("projectId");
		
		String oldBody = res.getBody().asString();
		
		int actData = res.getStatusCode();
		
		System.out.println(oldBody);
		
		Assert.assertEquals(actData, 201);
		
		JSONObject job = new JSONObject();
		
		job.put( "createdBy" , "DarshanYadav");
		job.put("projectName" , projectName);
		job.put("status" , "InActive");
		job.put("teamSize" , 5);
		
		Response resp = given()
				.body(job)
				.contentType(ContentType.JSON)
		.pathParam("projectId", proId)
		
		.when()
		.put("projects/{projectId}");
		
		String newBody = resp.getBody().asString();
		
		int actData1 = resp.getStatusCode();
		
		System.out.println(newBody);
		
		Assert.assertEquals(actData1, 200);	

	}

}