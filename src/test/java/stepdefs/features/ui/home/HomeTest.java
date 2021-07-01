package stepdefs.features.ui.home;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
/**
 * 
 * @author Ajita Krishna
 *
 */
@CucumberOptions(
	features = {
			"cucumber-testcases/features/ui/home" }, 
	plugin = {"pretty", "json:test-results/cucumber-reports/json/HomeTest-results.json"}, 
	glue = {"stepdefs.features.ui.home" }
	)
public class HomeTest extends AbstractTestNGCucumberTests {
	
}