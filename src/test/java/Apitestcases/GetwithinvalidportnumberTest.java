package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetwithinvalidportnumberTest {
	@Test
	public void getWithInvalidPortNumberTest() {

		baseURI="http://localhost";
		port=8085;
		
		when()
		.get("/projects/TY_PROJ_004")
		
		.then()
		.assertThat()
		.statusCode(200).log().all();
		
	}
}