package CRUDWithBDD;

import org.testng.annotations.Test;

import Utilities.EndPointsLibrary;

import static io.restassured.RestAssured.*;
public class DeleteWithBDD {
	
	@Test
	public void deleteTest() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.delete(EndPointsLibrary.deleteProject+"TY_PROJ_3605")
		
		.then()
		.assertThat()
		.log().all();
		
	}

}
