package Parameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;

public class QueryParameter {
	
	@Test
	public void query() {
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("https://reqres.in/api/users")
		.then().log().all();
		
	}
	
	@Test
	public void gitQuery() {
		
		baseURI = "https://api.github.com";
		
		Header head = new Header("Accept", "application/vnd.github+json");
		
		given()
		//.header("Accept", "application/vnd.github+json", null)
		.header(head)
		.pathParam("username", "DrshnYdv")
		.queryParam("sort", "pushed")
		
		.when()
		.get("/users/{username}/repos")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
