package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	public WebDriver driver;
	LandingPage lp ;

	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to HomePage");

	}

	@Test()
	public void validateAppTitle() throws IOException, InterruptedException {

		lp = new LandingPage(driver);
		// Compare the text from the browser with actual value--requirement

		Assert.assertEquals(lp.getTtitle().getText(), "FEATURED COURSES 1 2 3");
		log.info("Successfully validated text message");

		// you need to validate whether contact tab is present or not
//		Assert.assertEquals(true, lp.getContact().isDisplayed());
//		log.info("Contact field is available");


	}

	
	@Test()
	public void validateHeader() {
		
		Assert.assertEquals((lp.getHeader().getText()), "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed successfully");
	}

}
