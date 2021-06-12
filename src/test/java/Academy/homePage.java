package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class homePage extends base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String Password, String text)
			throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		

//		if(lp.getPopUpSize()>0)
//
//		{
//
//		lp.getPopUp().click();
//
//		}
//        
//		Thread.sleep(2000);
//		
//		lp.getLogin().click();

		LoginPage lp =(LoginPage) l.getLogin();
		
		lp.getEmailAdd().sendKeys(userName);
		lp.getPassword().sendKeys(Password);
//		System.out.println(text);
		log.info(text);
        
		
		
		lp.getLOGIn().click();
		ForgotPassword fp = lp.getforgotPassword();
		fp.getEmailAdd().sendKeys("xxxx");
		fp.getSendMeInstruction().click();

	}

	@DataProvider
	public Object[][] getData() {

		// Row stands for how many different datatypes test should run-- email pass so 2
		// rows
		// coloumn stands for how many values per each test--- email pass so 2 col
		// Object takes total counts ; Object[total row][total column], not index.Hence
		// if you are taking 2 rows and 3 columns, it should be:Object[][] data= new
		// Object[2][3];
		// When you assign the data to those arrays, its should start from [0][0], as it
		// denotes the index.

		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "nonrestriceduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non-restrictive user";

		// First row
		data[1][0] = "restrictiveduser@qw.com";
		data[1][1] = "654321";
		data[1][2] = "Restrictive user";

		return data;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
