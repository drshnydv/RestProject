package Apitestcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutProjectWithoutBaseURITest {
	@Test
	public void putProjectWithoutBaseURI(){
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Keerthan13");
		jobj.put("projectName", "neverbackn333");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 7);
		//baseURI="http://localhost";
		port=8084;


		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/TY_PROJ_1002")
		.then()
		.assertThat()
		.statusCode(400)
		.contentType(ContentType.JSON).log().all();
	}
}


