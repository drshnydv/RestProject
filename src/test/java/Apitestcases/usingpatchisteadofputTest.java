package Apitestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class usingpatchisteadofputTest {
@Test
public void usingpatchisteadofputTest() {
	JSONObject j=new JSONObject();
	j.put( "createdBy", "raytfuyguj");
	j.put("projectName", "yuguygugu");
	j.put("status", "creuyuyuyated1");
	j.put("teamSize", 54646);
 baseURI="http://localhost";
 port=8084;
 given()
       .body(j)
       .contentType(ContentType.JSON)
   .when()
         .patch("/projects/TY_PROJ_229")
    .then()
          .assertThat()
              .statusCode(200)
              .contentType(ContentType.JSON).log().all();
	
}
}
