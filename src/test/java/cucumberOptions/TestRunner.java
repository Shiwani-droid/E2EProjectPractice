package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(stepNotifications = true,
features="src/test/java/features",
glue="stepDefinitons"
)
		

public class TestRunner  {

}
