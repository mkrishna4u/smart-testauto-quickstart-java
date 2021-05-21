package smartfwk.testing.sample.gmail.features.logon;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
@Test
@CucumberOptions(
	features = {
			"cucumber-testcases/features/logon/LoginLogoutGoogleEmail.feature" }, 
	plugin = {"pretty", "json:test-results/cucumber-reports/json/LoginGoogleEmailTest-results.json"}, 
	glue = {"smartfwk.testing.sample.gmail.features.logon" } 
	)
public class LoginGoogleEmailTest extends AbstractTestNGCucumberTests {
	
}