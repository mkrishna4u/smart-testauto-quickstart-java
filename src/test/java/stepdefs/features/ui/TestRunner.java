package stepdefs.features.ui;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.uitnet.testing.smartfwk.ui.core.defaults.testng.SmartUiTestNGExecutionListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
/**
 * 
 * @author Ajita Krishna
 *
 */
@CucumberOptions(
	features = {
			"cucumber-testcases/features/ui" }, 
	plugin = {"pretty", "json:test-results/cucumber-reports/json/Github-results.json"}, 
	glue = {"stepdefs.features.ui" }
	)
@Listeners(SmartUiTestNGExecutionListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}
}