package Parameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PathParameterTest {
	
	@Test
	public void path() {
		
		String proId = "TY_PROJ_3402";
		
		baseURI = "http://localhost";
		port = 8084;
		
		given().pathParam("projectID", proId)
		
		.when().get("/projects/{projectID}")
		
		.then().log().all();
		
	}

}