package Validation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class bodyValidation {
	
	@Test
	public void proIdValidation() {
		
		String expData = "TY_PROJ_3202";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.jsonPath().get("projectId");
		
		Assert.assertEquals(expData, actData);
		
	}
	
	@Test
	public void proIdInBodyValidation() {
		
		String expData = "TY_PROJ_3202";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.getBody().asString();
		
		boolean flag = false;
		
		if(actData.contains(expData)) {
			
			System.out.println("Content Found");
			flag = true;
			
		}
		
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void nameValidation() {
		
		String expData = "ydvvaa";
		
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.getBody().asString();
		
		boolean flag = false;
		
		if(actData.contains(expData)) {
			
			System.out.println("Content Found");
			flag = true;
			
		}
		
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void createdOnValidation() {
		
		String expData = "03/10/2022";
		
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.getBody().prettyPrint();
		
		boolean flag = false;
		
		if(actData.contains(expData)) {
			
			System.out.println("Content Found");
			flag = true;
			
		}
		
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void createdByValidation() {
		
		String expData = "Drshn";
		
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.getBody().asPrettyString();
		
		boolean flag = false;
		
		if(actData.contains(expData)) {
			
			System.out.println("Content Found");
			flag = true;
			
		}
		
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void statusValidation() {
		
		String expData = "Active";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.jsonPath().get("status");
		
		Assert.assertEquals(expData, actData);
		
	}
	
	@Test
	public void teamSizeValidation() {
		
		int expData = 4;
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		int actData = res.jsonPath().get("teamSize");
		
		Assert.assertEquals(expData, actData);
		
	}
	
}
