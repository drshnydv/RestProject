package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.http.ContentType.*;

public class usingputforminorchangesTest {
@Test
public void usingputforminorchangesTest() {
	JSONObject j=new JSONObject();
	j.put( "createdBy", "raj");
	j.put("projectName", "shopthunt565644");
	j.put("status", "created1");
	j.put("teamSize", 2);
 baseURI="http://localhost";
 port=8084;
 given()
       .body(j)
       .contentType(ContentType.JSON)
   .when()
         .put("/projects/TY_PROJ_229")
    .then()
          .assertThat()
              .statusCode(200)
              .contentType(ContentType.JSON).log().all();
	
}
}
