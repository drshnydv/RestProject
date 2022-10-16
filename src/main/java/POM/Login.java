package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public Login(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "usernmae")
	private WebElement userNameEdt;
	
	@FindBy(id = "inputPassword")
	private WebElement userPasswordEdt;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement loginBtn;

	
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void UserLogin(String userName,String password) {
		
		
	}
	
	public void login(String username, String password) {
		
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
		
	}
		


}
