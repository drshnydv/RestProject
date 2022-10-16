package Apitestcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PostWithOutUriandEndPorint {
	@Test
	public void postingwithouturi(){

		String ectData = "HTTP/1.1 405 ";

		JSONObject j=new JSONObject();
		j.put( "createdBy", "raja");
		j.put("projectName", "shopthunt12");
		j.put("status", "created");
		j.put("teamSize", 14);

		port=8084;
		
		given()
		.body(j)
		.contentType(ContentType.JSON);
		
		Response res = when().post("");
		
		String actData = res.getStatusLine();
		
		Assert.assertEquals(ectData, actData);

	}
}
