package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetAndDeleteTest {

	@Test
	public void getAndDelete() {

		baseURI = "http://localhost";
		port = 8084;

		Response res = when()
				.get("projects");

		String proId = res.jsonPath().get("[1].projectId");

		Response resp = given()
				.pathParam("projectId", proId)

				.when()
				.delete("projects/{projectId}");

		int actData = resp.getStatusCode();
		
		Assert.assertEquals(actData, 204);

	}

}