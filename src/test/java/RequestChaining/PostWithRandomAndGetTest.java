package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoUtiity.postThroughPojo;
import Utilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostWithRandomAndGetTest {
	
	@Test
	public void postAndGet() {
		
		int extData = 201;
		String expData1 = "Created";
		
		JavaUtility Jlib = new JavaUtility();
		int ran = Jlib.RandomNumber();

		baseURI = "http://localhost";
		port = 8084;

		postThroughPojo po = new postThroughPojo("drshn", "Tyss__"+ran, "Created", 8);

		 Response res = given()
		.body(po)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject");
		
		String proId = res.jsonPath().get("projectId");
		
		int actData = res.getStatusCode();
		
		org.testng.Assert.assertEquals(actData, extData);
		
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
