package Apitestcases;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutProjectWithDifferentContentTypeLanguageTest2 {
	@Test
	public void putProjectWithDifferentContentTypeLanguage()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Keerthan76");
		jobj.put("projectName", "neverbackdownjas");
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
		.contentType(ContentType.JSON).log().all();
	}
}


