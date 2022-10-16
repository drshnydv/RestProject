package RequestChaining;

import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import PojoUtiity.postThroughPojo;
import Utilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostWithRandomAndPutTest {

	@Test
	public void postAndPut() {
		
		String Name = "Tyss";
		
		JavaUtility Jlib = new JavaUtility();
		int ran = Jlib.RandomNumber();
	
		baseURI = "http://localhost";
		port = 8084;

		postThroughPojo po = new postThroughPojo("Drshn", "Ty"+ran , "Active", 8);

		 Response res = given()
		.body(po)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject");
		
		String proId = res.jsonPath().get("projectId");
		
		String oldName = res.jsonPath().get("projectName");
		
		int actData = res.getStatusCode();
		
		Assert.assertEquals(actData, 201);
		
		postThroughPojo jo = new postThroughPojo("DarshanYadav", Name+ran , "InActive", 4);
		
		Response resp = given()
				.body(jo)
				.contentType(ContentType.JSON)
		.pathParam("projectId", proId)
		
		.when()
		.put("projects/{projectId}");
		
		int actData1 = resp.getStatusCode();
		
		String name = resp.jsonPath().get("projectName");
		
		System.out.println("Old ProjectName " + "'" + oldName + "'" + " is Changed To ==> " + "'" + name + "'");
		
		Assert.assertEquals(actData1, 200);
			
	}

}