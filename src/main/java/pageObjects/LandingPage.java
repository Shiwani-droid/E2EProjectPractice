package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;
	
	private By signIn= By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//*[contains(text(),'Featured Courses')]");
	private By contact = By.xpath("//a[contains(text(),'Contact')]");
	private By navBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	private By popup=By.xpath("//button[text()='NO THANKS']");
	private By header=By.xpath("//*[contains(text(),'Learn Hot tools like Selenium')]");
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		return new LoginPage(driver);
		
	}
	
	public WebElement getTtitle() {
		return driver.findElement(title);
	}
	
	public WebElement getContact() {
		return driver.findElement(contact);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popup);
	}
	
	public int getPopUpSize() {
		return driver.findElements(popup).size();
	}
	
	public WebElement getHeader() {
		 return driver.findElement(header);
		 
		
	}
}
