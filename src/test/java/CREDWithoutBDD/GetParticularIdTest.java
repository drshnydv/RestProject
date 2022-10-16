package CREDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetParticularIdTest {
	
	@Test
	public void getId() {
		
		Response req = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1242");
		
		ValidatableResponse re = req.then();
		
		re.log().all();
		
	}

}
