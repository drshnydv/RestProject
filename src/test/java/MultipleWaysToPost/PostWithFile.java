package MultipleWaysToPost;

import java.io.File;

import org.testng.annotations.Test;

import Utilities.EndPointsLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostWithFile {

	@Test
	public void fileTest() {

		File file = new File("./Data/new.json");

		baseURI = "http://localhost";
		port = 8084;

		given()
		.body(file)
		.contentType(ContentType.JSON)

		.when()
		.put(EndPointsLibrary.updateProject+"TY_PROJ_3812")

		.then()
		.assertThat()
		.contentType(ContentType.JSON)


		.log().all();
	}

}
