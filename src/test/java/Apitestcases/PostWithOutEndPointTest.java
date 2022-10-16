package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import  static io.restassured.http.ContentType.*;

public class PostWithOutEndPointTest {
	@Test
	public void postingwithoutendpoint(){
		
		String ectData = "HTTP/1.1 405 ";

		JSONObject j=new JSONObject();
		
		j.put( "createdBy", "raja");
		j.put("projectName", "shopthunt1");
		j.put("status", "created");
		j.put("teamSize", 14);

		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(j)
		.contentType(ContentType.JSON);
		
		Response res = when().post("");
		
		String actData = res.getStatusLine();
		
		Assert.assertEquals(ectData, actData);
	}
}
