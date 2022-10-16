package Utilities;

import io.restassured.response.Response;

public class RestAssuredUtility {
	
	public String getJsonData(Response response,String path ) {
		
		String jsonData = response.jsonPath().get(path);
		
		return jsonData;
		
	}
	
}