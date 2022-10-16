package Authentication;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class BearerTokenTest {

	@Test
	public void bearerTocken() {
		
		given()
		.auth()
		.oauth2("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")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.log().all();
		
	}

}