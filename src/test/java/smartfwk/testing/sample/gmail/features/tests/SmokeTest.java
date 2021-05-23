package smartfwk.testing.sample.gmail.features.tests;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(
	features = {
			"cucumber-testcases/features" }, 
	plugin = {"pretty", "json:test-results/cucumber-reports/json/SmokeTest-results.json"}, 
	glue = {"smartfwk.testing.sample.gmail.features.stepdefs" } ,
	tags = "@SmokeTest"
	)
public class SmokeTest extends AbstractTestNGCucumberTests {

}
