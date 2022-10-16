package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	public Home(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//li/a[text()='Project']")
	private WebElement projecrBtn;

	public WebElement getProjecrBtn() {
		return projecrBtn;
	}
	
	public void getProjects() {
		
		getProjecrBtn().click();
		
	}

}
