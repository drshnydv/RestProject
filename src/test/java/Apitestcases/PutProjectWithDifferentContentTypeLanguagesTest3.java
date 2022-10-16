package Apitestcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutProjectWithDifferentContentTypeLanguagesTest3 {
	@Test
	public void putProjectWithDifferentContentTypeLanguages()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Keerthan7");
		jobj.put("projectName", "neverownjas");
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 7);
		baseURI="http://localhost";
		port=8084;


		given()
		.body(jobj)
		.contentType(ContentType.XML)
		.when()
		.put("/projects/TY_PROJ_1002")
		.then()
		.assertThat()
		.contentType(ContentType.XML).log().all();
	}
}


