package Apitestcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostWithoutBodyTest {
	@Test
	public void postwihoutbodyTest() {
		
		int extData = 403;
		
		JSONObject j=new JSONObject();

		given()
		.body(j)
		.contentType(ContentType.JSON);
		
		Response res = when().post("/addProjects");
		
		int actData = res.getStatusCode();
		
		Assert.assertEquals(extData, actData);

	}

}
