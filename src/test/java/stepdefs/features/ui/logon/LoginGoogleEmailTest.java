package stepdefs.features.ui.logon;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
/**
 * 
 * @author Ajita Krishna
 *
 */
@Test
@CucumberOptions(
	features = {
			"cucumber-testcases/features/ui/logon" }, 
	plugin = {"pretty", "json:test-results/cucumber-reports/json/LoginGoogleEmailTest-results.json"}, 
	glue = {"stepdefs.features.ui.logon" }
	)
public class LoginGoogleEmailTest extends AbstractTestNGCucumberTests {
	
}