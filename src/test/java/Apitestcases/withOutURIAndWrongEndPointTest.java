package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class withOutURIAndWrongEndPointTest{

	@Test
	public void wrongUri() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.get("/project")
		
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		
		.log().all();
		
		
	}
	
}
