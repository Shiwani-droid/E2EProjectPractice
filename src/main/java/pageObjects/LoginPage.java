 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	private By emailAdd= By.cssSelector("#user_email");
	private By password= By.cssSelector("#user_password");
	private By logIn   = By.xpath("//input[@type='submit']");
	private By forgotPassword = By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

	
	public ForgotPassword getforgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
	
	
	public WebElement getEmailAdd() {
		return driver.findElement(emailAdd);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLOGIn() {
		return driver.findElement(logIn);
	}
	
	
	
	
}
