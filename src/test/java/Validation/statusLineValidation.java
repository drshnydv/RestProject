package Validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class statusLineValidation {
	
	@Test
	public void getHeader() {
		
		String ectData = "HTTP/1.1 200 ";
		
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/project");
		
		String actData = res.getStatusLine();
		
		Assert.assertEquals(ectData, actData);
		
	}

}