package CREDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteTest {
	
	@Test
	public void deleteResource() {
		
		Response req = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1405");
		
		ValidatableResponse re = req.then();
		
		re.assertThat().statusCode(204);
		
	}

}
