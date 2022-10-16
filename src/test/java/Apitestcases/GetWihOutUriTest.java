package Apitestcases;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetWihOutUriTest {
	@Test
	public void getTest() {

		int extData = 404;

		port = 8084;

		Response res = when().get("/projects");

		int actData = res.getStatusCode();

		Assert.assertEquals(extData, actData);
	}

}
