package Apitestcases;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetTheResponseWithWorngUri {
	@Test
	public void get() {
		
		baseURI = "http://worngUri";
		port = 8084;
		
		Response res = when().get("/projects");
		
		res.then().assertThat().log().all();
		
	}
	
}