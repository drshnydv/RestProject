package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostWithOutPortnoTest {
	@Test 
	public void postingwithoutportno() {
		
		int extData = 403;
		
		JSONObject j=new JSONObject();
		j.put( "createdBy", "raja");
		j.put("projectName", "shopthunt1");
		j.put("status", "created");
		j.put("teamSize", 14);
		
		baseURI="http://localhost";

		given()
		.body(j)
		.contentType(ContentType.JSON);
		
		Response res = when().post("/addProjects");
		
		int actData = res.getStatusCode();
		
		 Assert.assertEquals(extData, actData);

	}
}

