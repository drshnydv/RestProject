	package CRUDWithBDD;

import org.testng.annotations.Test;

import Utilities.EndPointsLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetWithBDDTest {
	
	@Test
	public void getTest() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.get(EndPointsLibrary.getAllProject)
		
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		
		.log().all();
		
	}

}