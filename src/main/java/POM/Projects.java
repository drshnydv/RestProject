package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Projects {
	
	public Projects(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[text()='Create Project']")
	private WebElement createProjectBtn;
	
	@FindBy(name = "projectName")
	private WebElement projectNameBtn;
	
	@FindBy(name = "teamSize")
	private WebElement teamSizeTxtBox;
	
	@FindBy(name = "createdBy")
	private WebElement createdByTxtBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//tbody/tr/td[text()='Project']/parent::tr/td[1]")
	private WebElement getProjectId;
	
	@FindBy(xpath = "//label[text()='Project Status ']/following-sibling::select[@class='form-control']")
	private WebElement statusDrpDwn;
	
	@FindBy(xpath = "//tbody/tr/td[1]")
	private List<WebElement> allProjectIds;
	
	@FindBy(xpath = "//input[@value = 'Delete']")
	private WebElement popUpDeleteBtn;

	public WebElement getPopUpDeleteBtn() {
		return popUpDeleteBtn;
	}

	public List<WebElement> getAllProjectIds() {
		return allProjectIds;
	}

	public WebElement getGetProjectId() {
		return getProjectId;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCreateProjectBtn() {
		return createProjectBtn;
	}

	public WebElement getProjectNameBtn() {
		return projectNameBtn;
	}

	public WebElement getTeamSizeTxtBox() {
		return teamSizeTxtBox;
	}
	

	public WebElement getCreatedByTxtBox() {
		return createdByTxtBox;
	}

	public WebElement getStatusDrpDwn() {
		return statusDrpDwn;
	}
	
	public void createNewProject() {
		
		getCreateProjectBtn().click();
		
	}
	
	public void projectName(String projectName) {
		
		getProjectNameBtn().sendKeys(projectName);
		
	}
	
	public void createdBy(String createdBy) {
		
		getCreatedByTxtBox().sendKeys(createdBy);;
		
	}
	
	public void submit() {
		
		getSubmitBtn().click();
		
	}
	
	public String getProjectIdThroughProjectName(WebDriver driver, String projectName) {
		
		String id = driver.findElement(By.xpath("//tbody/tr/td[text()='"+projectName+"']/parent::tr/td[1]")).getText();
		
		return id;
		
	}
	
	public void sendTeamSize(String teamSize) {
		
		getTeamSizeTxtBox().sendKeys(teamSize);
		
	}
	
	public void deleteProjectThroughProjectId(WebDriver driver, String projectId) {
		
		driver.findElement(By.xpath("//tbody/tr/td['"+projectId+"']/following-sibling::td/a[@class='delete']")).click();
		
	}
	
	public void clickDeleteInPopUP() {
		
		getPopUpDeleteBtn().clear();
		getPopUpDeleteBtn().click();
		
	}

}
