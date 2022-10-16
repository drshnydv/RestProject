package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutProjectWithWrongResourceTest {
	@Test
	public void putProjectWithWrongResource(){
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Keerthan67");
		jobj.put("projectName", "neverbackdojas");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 7);
		baseURI="http://localhost";
		port=8084;


		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.put("/jhvhgv")
		.then()
		.assertThat()
		.statusCode(404)
		.contentType(ContentType.JSON).log().all();
	}
}


