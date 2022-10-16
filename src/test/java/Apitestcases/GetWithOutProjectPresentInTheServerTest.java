package Apitestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetWithOutProjectPresentInTheServerTest {
	@Test
	public void Getwithoutprojectpresentintheserver() {

		String expData = "Not Found";

		baseURI = "http://localhost";
		port = 8084;

		Response res = when().get("/project/TY_PROJ_000");

		String actData = res.getBody().asString();

		boolean flag = false;

		if(actData.contains(expData)) {
			
			flag = true;

		}

		Assert.assertTrue(flag);
		
	}

}