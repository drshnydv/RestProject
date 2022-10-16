package Authentication;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Ouath2 {

	@Test
	public void ouath2() {

		Response res = given()
				.formParam("client_id", "Trail")
				.formParam("client_secret", "cf8ec5968753dd1ad610aafd33d4eadc")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://trail.com")
				.formParam("code ", "3885")

				.when()
				.post("http://coop.apps.symfonycasts.com/token");

		System.out.println(res);

		String token = res.jsonPath().get("access_token");
		
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", 3885)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
			
		.then().log().all();
		
	}

}