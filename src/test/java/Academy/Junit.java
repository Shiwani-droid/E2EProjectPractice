package Academy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import junit.framework.Assert;

public class Junit {
	WebDriver driver;
	
	
	@Test
    public void testLoginFormPresent() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
		 
      // below you can find already setup webDriver
      driver.findElement(By.id("email-input"));
      driver.findElement(By.id("password-input"));
      driver.findElement(By.id("login-button"));
      String expectedURL= "https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html";
      String actualURL=driver.getCurrentUrl();
      Assert.assertEquals(actualURL,expectedURL);
        
    }

@Test
    public void testValidCredential() {
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
	 
      // below you can find already setup webDriver
	driver.findElement(By.id("email-input")).sendKeys("login@codility.com");
	driver.findElement(By.id("password-input")).sendKeys("password");
	driver.findElement(By.id("login-button")).click();
      Boolean display=driver.findElement(By.xpath("//div[@class='message success']")).isDisplayed();
      System.out.println("Successful login credential message displayed"+display);
		  
    }


    @Test
    public void invalidCredential(){
    	System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
		 
    	driver.findElement(By.id("email-input")).sendKeys("unknown@codility.com");
    	driver.findElement(By.id("password-input")).sendKeys("password");
    	driver.findElement(By.id("login-button")).click();
      Boolean display=driver.findElement(By.xpath("//div[@class='message error']")).isDisplayed();
      System.out.println("Invalid Credential Message displayed"+display);
		 

    }

    @Test
    public void wrongEmailVaildation(){
    	System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
		 
    	driver.findElement(By.id("email-input")).sendKeys("test.com");
    	driver.findElement(By.id("password-input")).sendKeys("password");
    	driver.findElement(By.id("login-button")).click();
       Boolean display=driver.findElement(By.xpath("//div[@class='validation error']")).isDisplayed();
      System.out.println("Wrong email Message displayed"+display);
    }

@Test
    public void emptyCredential(){
	System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
	 
	driver.findElement(By.id("login-button")).click();
       Boolean displayEmail=driver.findElement(By.xpath("//div[contains(text(),\'Email is required\')]")).isDisplayed();
      System.out.println("Empty CredentialMessage displayed"+displayEmail);
      Boolean displayPassword=driver.findElement(By.xpath("//div[contains(text(),\'Password is required\')]")).isDisplayed();
      System.out.println("Message displayed"+displayPassword);
    }
    
}
