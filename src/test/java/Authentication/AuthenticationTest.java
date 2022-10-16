package Authentication;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class AuthenticationTest {

	@Test
	public void premitiveAuth() {

		given()
		.auth().preemptive().basic("rmgyantra","rmgy@9999")
		
		.when()
		.get("http://localhost:8084/login")

		.then()
		.log().all();

	}

	@Test
	public void digestiveAuth() {

		given()
		.auth().digest("rmgyantra","rmgy@9999")
		
		.when()
		.get("http://localhost:8084/login")

		.then()
		.log().all();

	}

}