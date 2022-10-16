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

public class PostIntValueInsteasdOfStringTest {
	@Test
	public void  postintvalueinsteasdofString() {

		int extData = 400;

		JSONObject j=new JSONObject();

		j.put( "createdBy", "Ydv");
		j.put("projectName", 5);
		j.put("status", 656);
		j.put("teamSize", 4);

		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(j)
		.contentType(ContentType.JSON);

		Response res = when().post("addProject");
		
		res.then().log().all();

		//int actData = res.getStatusCode();

		//Assert.assertEquals(extData, actData);

	}

}