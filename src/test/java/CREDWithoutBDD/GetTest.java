package CREDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetTest {
	
	@Test
	public void getRequest() {
		
		Response req = RestAssured.get("http://localhost:8084/projects");
		
		//req.prettyPeek();
		//req.prettyPrint();
		
		ValidatableResponse re = req.then();
		
		re.assertThat().statusCode(200);
		
		re.log().all();
		
	}

}