package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Utilities.EndPointsLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutWithBDD {
	
	@Test
	public void putTest() {
		
		JSONObject job = new JSONObject();
		
		job.put( "createdBy" , "Drshn");
		job.put("projectName" , "ydvv");
		job.put("status" , "Active");
		job.put("teamSize" , 4);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.body(job)
		.contentType(ContentType.JSON)
		
		.when()
		.put(EndPointsLibrary.updateProject+"TY_PROJ_3617")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		
		.log().all();
		
	}

}
