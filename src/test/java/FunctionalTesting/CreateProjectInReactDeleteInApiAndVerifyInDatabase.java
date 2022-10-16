package FunctionalTesting;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utilities.DataBaseUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectInReactDeleteInApiAndVerifyInDatabase {
	
	String projectId;
	
	@Test
	public void createProjectInReact() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8084");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//li/a[text()='Projects']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("DeleteProject");
		
		WebElement textbox = driver.findElement(By.name("teamSize"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='5'", textbox);
		
		driver.findElement(By.name("createdBy")).sendKeys("Drshn");
		
		WebElement dropDown = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@class='form-control']"));
		
		Select sel = new Select(dropDown);
		sel.selectByValue("Created");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		projectId = driver.findElement(By.xpath("//tbody/tr/td[text()='DeleteProject']/parent::tr/td[1]")).getText();
		
		System.out.println("Project created in GUI");
		
		driver.close();
		
	}
	
	@Test
	public void deleteInAPITest() {
		
		baseURI = "http://localhost";
		port = 8084;
		
		when()
		.delete("/projects/"+projectId)
		
		.then()
		.assertThat()
		.statusCode(204);
		
		System.out.println("Project Deleted through API");
		
	}
	
	@Test
	public void validateInDataBase() throws Throwable {
		
		DataBaseUtility Dlib = new DataBaseUtility();
		
		Dlib.connectDb();
		
		String query = "select project_id from project;";
		
		Dlib.executeQueryAndValidate(query, 1, projectId);
		
	}
	
}