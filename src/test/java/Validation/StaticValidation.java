package Validation;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class StaticValidation {
	
	@Test
	public void validation() {
		
		String expData = "TY_PROJ_3202";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects");
		
		String actData = res.jsonPath().get("[0].projectId");
		
		Assert.assertEquals(expData, actData);
	}

}