package Validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class headerValidation {
	
//	HTTP/1.1 200 
//	Vary: Origin
//	Vary: Access-Control-Request-Method
//	Vary: Access-Control-Request-Headers
//	X-Content-Type-Options: nosniff
//	X-XSS-Protection: 1; mode=block
//	Cache-Control: no-cache, no-store, max-age=0, must-revalidate
//	Pragma: no-cache
//	Expires: 0
//	X-Frame-Options: DENY
//	Content-Type: application/json
//	Transfer-Encoding: chunked
//	Date: Mon, 03 Oct 2022 12:01:09 GMT
//	Keep-Alive: timeout=60
//	Connection: keep-alive
	
	
	@Test
	public void varyValidation() {
		
		String expData = "Access-Control-Request-Headers";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.getHeader("Vary");
		
		Assert.assertEquals(expData, actData);
		
	}
	
	@Test
	public void proIdValidation() {
		
		String expData = "nosniff";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		String actData = res.getHeader("X-Content-Type-Options");
		
		Assert.assertEquals(expData, actData);
		
	}
	
	@Test
	public void allVaryValidation() {
		
		String expData = "Origin";
	
		baseURI = "http://localhost";
		port = 8084;
		
		Response res = when().get("/projects/TY_PROJ_3202");
		
		 Headers headers = res.getHeaders();
		 
		 List<Header> h = headers.getList("vary");
		 
		 boolean flag = false;
		 
		 for (Header header : h) {
			
			if(header.equals(expData)) {
				
				flag = true;
				
			}
			 
		 }
		
		Assert.assertTrue(flag);
		
	}

}
