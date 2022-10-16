package Apitestcases;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class DeleteWithOutBaseUri {
	
	@Test
	public void Delete() {

	String ectData = "HTTP/1.1 204 ";
	
	baseURI = "http://localhost";
	port = 8084;
	
	Response res = when().delete("/project/TY_PROJ_3202");
	
	String actData = res.getStatusLine();
	
	Assert.assertEquals(ectData, actData);

	}
	
}