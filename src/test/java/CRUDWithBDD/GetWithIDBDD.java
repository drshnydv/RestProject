package CRUDWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetWithIDBDD {
	
	@Test
	public void getWithID() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.get("/projects/TY_PROJ_3202")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		
		.log().all();
		
	}

}
