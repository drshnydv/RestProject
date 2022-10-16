package RequestChaining;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAndPutTest {

	@Test
	public void getAndDelete() {
		
		String NewName = "Tyss_456";
		
		baseURI = "http://localhost";
		port = 8084;

		Response res = when()
				.get("projects");

		String proId = res.jsonPath().get("[1].projectId");
		
		String oldName = res.jsonPath().get("[1].projectName");
		
		JSONObject job = new JSONObject();
		
		job.put( "createdBy" , "DarshanYadav");
		job.put("projectName" , NewName);
		job.put("status" , "InActive");
		job.put("teamSize" , 5);
		
		Response resp = given()
				.body(job)
				.contentType(ContentType.JSON)
		.pathParam("projectId", proId)
		
		.when()
		.put("projects/{projectId}");
		
		String actData = resp.getBody().asString();
		
		boolean flag = false;
		
		if(actData.contains(NewName)) {
			
			System.out.println("Old ProjectName " + "'" + oldName + "'" + " is Changed To ==> " + "'" + NewName + "'");
			flag = true;
			
		}
		
		Assert.assertTrue(flag);

	}

}