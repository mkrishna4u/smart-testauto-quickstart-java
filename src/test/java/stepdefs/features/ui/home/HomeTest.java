package stepdefs.features.ui.home;

import org.testng.annotations.Listeners;

import global.TestNGExecutionListener;
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
@Listeners(TestNGExecutionListener.class)
public class HomeTest extends AbstractTestNGCucumberTests {
	
}