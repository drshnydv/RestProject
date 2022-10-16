package Apitestcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class withouturiportandendpointTest {
@Test
public void withouturiportandendpointgetTest() {
	

	
	
	when()
	.get()
	.then()
	.statusCode(200).log().all();
	
}
}
