package Apitestcases;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class OnlyGivingPortNoTest {
	@Test
	public void withOutUripPortAndeEndPointGetTest() {

		int expData1 = 200;
		//server should accept the request but return no body

		port = 8084;

		Response res = when().get("");

		int actData1 = res.getStatusCode();

		Assert.assertEquals(expData1, actData1);
	}
}