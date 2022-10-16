package Apitestcases;

import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class withoutportandurigettingtherequsetTest {
	@Test
	public void getwihouturiTest() {
		
		 when()
		      .get("/projects")
		  .then()
		       .assertThat()
		           .statusCode(200)
		           .contentType(ContentType.JSON).log().all();
	}
}
