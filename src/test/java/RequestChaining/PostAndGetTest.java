package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoUtiity.postThroughPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAndGetTest {
	
	@Test
	public void postAndGet() {
		
		String expData1 = "drshn";

		baseURI = "http://localhost";
		port = 8084;

		postThroughPojo po = new postThroughPojo("drshn", "id1234", "Active", 8);

		 Response res = given()
		.body(po)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject");
		
		String proId = res.jsonPath().get("projectId");
		
		int actData = res.getStatusCode();
		
		org.testng.Assert.assertEquals(actData, 201);
		
		Response resp = given()
		.pathParam("projectId", proId)
		
		.when()
		.get("projects/{projectId}");
		
		String actData1 = resp.getBody().asString();
		
		boolean flag = false;
		
		if(actData1.contains(expData1)) {
			
			flag = true;
			
		}
		
		Assert.assertTrue(flag);
		
	}

}