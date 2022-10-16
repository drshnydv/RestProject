package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoUtiity.postThroughPojo;
import Utilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostWithRandomAndDeleteTest {

	@Test
	public void postWithAndDelete() {
		
		int extData = 201;
		String extData1 = "HTTP/1.1 204 ";
		
		JavaUtility Jlib = new JavaUtility();
		int ran = Jlib.RandomNumber();

		baseURI = "http://localhost";
		port = 8084;

		postThroughPojo po = new postThroughPojo("drshn", "id123"+ran , "Active", 8);

		 Response res = given()
		.body(po)
		.contentType(ContentType.JSON)
		
		.when()
		.post("addProject");
		
		String proId = res.jsonPath().get("projectId");
		
		int actData = res.getStatusCode();
		
		org.testng.Assert.assertEquals(extData, actData);
		
		Response resp = given()
		.pathParam("projectId", proId)
		
		.when()
		.delete("projects/{projectId}");
		
		String actData1 = resp.getStatusLine();
		
		Assert.assertEquals(extData1, actData1);

	}

}