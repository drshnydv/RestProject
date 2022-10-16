package Validation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class timeValidation {
	
	@Test
	public void timeVaidate() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.get("projects")
		
		.then()
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.SECONDS);
		
	}
	
}
