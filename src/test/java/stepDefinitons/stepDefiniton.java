package stepDefinitons;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.junit.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefiniton extends base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();

	}
	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
	}

	@When("^user enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) throws Throwable {

		LoginPage lp = new LoginPage(driver);

		lp.getEmailAdd().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLOGIn().click();
	}

	@Then("^Verify user is successfully logged in$")
	public void verify_user_is_successfully_logged_in() throws Throwable {
		PortalHomePage p = new PortalHomePage(driver);
		Assert.assertTrue(p.getSearchBox().isDisplayed());

	}

	

	@And("^Click on Login link in home page to login on secure sign in page$")
	public void click_on_login_link_in_home_page_to_login_on_secure_sign_in_page() throws Throwable {

		LandingPage l = new LandingPage(driver);
		if (l.getPopUpSize() > 0) {
			l.getPopUp().click();
		}
		LoginPage lp = l.getLogin();
	}
	
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	    }


}