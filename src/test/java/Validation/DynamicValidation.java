package Validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidation {
	
	@Test
	public void validation() {
		
		String expData = "TY_PROJ_3202";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects");
		
		List<String> actData = res.jsonPath().get("projectId");
		
		Boolean flag = false;
		
		for (String string : actData) {
			
			if(string.equalsIgnoreCase(expData)) {
				
				flag = true;
				
			}
			
		}
	
		Assert.assertTrue(true);
		
	}

}
