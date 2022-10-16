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

import static io.restassured.http.ContentType.*;

public class PostWithOutMethodTest {
	@Test
	public void postwithputmethod() {
		
		int extData = 404;
		
		JSONObject j=new JSONObject();
		
		j.put( "createdBy", "raja");
		j.put("projectName", "shopthunt123");
		j.put("status", "created");
		j.put("teamSize", 14);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(j)
		.contentType(ContentType.JSON);
		
		Response res = when().put("/addProjects");
		
		int actData = res.getStatusCode();
		
		 Assert.assertEquals(extData, actData);

	}
}
