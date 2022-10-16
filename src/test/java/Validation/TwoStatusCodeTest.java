package Validation;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class TwoStatusCodeTest {
	
	@Test
	public void twoCodes() {
		
		baseURI = "http://reqres.in/";
		
		when()
		.get("api/users/2")
		
		.then()
		.log().all();
		
	}

}