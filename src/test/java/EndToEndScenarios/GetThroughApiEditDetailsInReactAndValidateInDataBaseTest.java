package EndToEndScenarios;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import POM.Login;
import Utilities.BaseClass;
import Utilities.DataBaseUtility;
import Utilities.EndPointsLibrary;
import Utilities.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

public class GetThroughApiEditDetailsInReactAndValidateInDataBaseTest extends BaseClass { 
	
	@Test
	public void test() throws Throwable {
		
		String proId = "TY_PROJ_3402";
		
		String newName = "GOOGLE";
		
		//getprojectthroughAPI
		
		Response res = when()
		.get(EndPointsLibrary.getSingleProject+proId);
		
		String proName = res.jsonPath().get("projectName");
		int teamSize = res.jsonPath().get("teamSize");
		String createdBy = res.jsonPath().get("createdBy");
		
		
		//edit project in React
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8084");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Login login = new Login(driver);
		
		login.login(IConstants.REACTAPP_USERNAME, IConstants.REACTAPP_PASSWORD);
		
		driver.findElement(By.xpath("//li/a[text()='Projects']")).click();
		
		driver.findElement(By.xpath("//tbody/tr/td['"+proId+"']/following-sibling::td/a[@class='edit']")).click();
		
		driver.findElement(By.xpath("//input[@value='"+proName+"']")).clear();
		driver.findElement(By.xpath("//input[@value='"+proName+"']")).sendKeys(newName);
		
		WebElement textbox = driver.findElement(By.xpath("//input[@value ='"+teamSize+"']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled',0);", textbox);
		
		driver.findElement(By.xpath("//input[@value ='"+teamSize+"']")).clear();
		driver.findElement(By.xpath("//input[@value ='"+teamSize+"']")).sendKeys("11");
		
		driver.findElement(By.xpath("//input[@value='"+createdBy+"']")).clear();
		driver.findElement(By.xpath("//input[@value='"+createdBy+"']")).sendKeys("Darshan");
		
		WebElement dropDown = driver.findElement(By.xpath("//div[@class='form-group']/select"));
		
		Select sel = new Select(dropDown);
		sel.selectByValue("Completed");
		
		driver.findElement(By.xpath("//div[@class='modal-footer']/input[@value='Save']")).click();
		
		System.out.println("Project Edited In ReactApp");
		
		
		
		//verify in DataBase
		
		DataBaseUtility dLib = new DataBaseUtility();
		
		dLib.connectDb();
		
		String query = "select * from project;";
		
		dLib.executeQueryAndValidate(query, 4, newName);
		
		
	}

}