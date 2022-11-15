package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoUtiity.PostThroughPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PostAndDeleteTest {

	@Test
	public void postAndDelete() {

		baseURI = "http://localhost";
		port = 8084;

		PostThroughPojo po = new PostThroughPojo("drshn", "id1234", "Active", 8);

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
		.delete("projects/{projectId}");
		
		int actData1 = resp.getStatusCode();
		
		Assert.assertEquals(actData1, 204);

	}

}
