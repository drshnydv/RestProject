package DataDrivenInRest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoUtiity.postThroughPojo;
import Utilities.ExcelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostThroughDataDriven {
	
	@Test(dataProvider = "mulitipleData")
	public void postThroughDataProvider(String createdBy, String projectName, String status, int teamSize) {
		
		postThroughPojo p = new postThroughPojo(createdBy, projectName, status, teamSize);
		
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.contentType(ContentType.JSON)
		.body(p)
		
		.when()
		.post("/addProject")
		
		.then()
		.contentType(ContentType.JSON)
		.statusCode(201)
		
		.log().all();
		
		System.out.println(createdBy + projectName + status + teamSize);
		
	}
	
	
	@DataProvider
	public Object[][] mulitipleData() throws Throwable{
		
		Random ran = new Random();
		int r = ran.nextInt(100);
		
		ExcelUtility e = new ExcelUtility();
		
		String createdBy = e.getExcelData("Data", 0, 0);
		String projectName = e.getExcelData("Data", 1, 0);
		String status = e.getExcelData("Data", 2, 0);
		String teamSize = e.getExcelData("Data", 3, 0);
		int teamsize = Integer.valueOf(teamSize);
		String createdBy1 = e.getExcelData("Data", 0, 1);
		String projectName1 = e.getExcelData("Data", 1, 1);
		String status1 = e.getExcelData("Data", 2, 1);
		String teamSize1 = e.getExcelData("Data", 3, 1);
		int teamsize1 = Integer.valueOf(teamSize1);
		
		Object[][] a = new Object[2][4];
		
		a[0][0] = createdBy;
		a[0][1] = projectName+r;
		a[0][2] = status;
		a[0][3] = teamsize;
		a[1][0] = createdBy1;
		a[1][1] = projectName1+r;
		a[1][2] = status1;
		a[1][3] = teamsize1;
		
		for(int i = 0; i < 5; i++) {
		
			for(int j = 0; j < 4; j++) {
				
				a[i][j] = e.getExcelData("Data1", i, j);
				
			}
			
		}
		
		return a;
		
	}

}