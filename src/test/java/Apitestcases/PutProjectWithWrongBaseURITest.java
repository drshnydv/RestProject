package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutProjectWithWrongBaseURITest {
	@Test
	public void putProjectWithWrongBaseURI(){
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Keerthan21");
		jobj.put("projectName", "neverghost5");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 7);
		baseURI="http://localghost";
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