 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	WebDriver driver;
	
	private By emailAdd= By.cssSelector("#user_email");
	private By sendMeInstruction= By.xpath("//input[@name='commit']");
	
	

	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmailAdd() {
		return driver.findElement(emailAdd);
	}
	
	
	public WebElement getSendMeInstruction() {
		// TODO Auto-generated method stub
		return driver.findElement(sendMeInstruction);
	}
	
	
	
	
	
}
