package stepdefs.features.ui;

import org.uitnet.testing.smartfwk.ui.core.SmartCucumberUiScenarioContext;

import global.AppConstants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.GithubMainPO;

/**
 * This class contains the login steps and the shared steps that can be used in all the scenarios defined in cucumber feature file.
 * 
 * @author Ajita Krishna
 *
 */
public class LoginAndSharedSteps {
	private SmartCucumberUiScenarioContext scenarioContext;
	
	public LoginAndSharedSteps(SmartCucumberUiScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		scenarioContext.setScenario(scenario);
		scenarioContext.captureScreenshot();
	}

	@After
	public void afterScenario(Scenario scenario) {
		scenarioContext.captureScreenshot();
		scenarioContext.close();
	}
	
	@When("User login using {string} user profile.")
	public void user_login_using_user_profile(String userProfileName) {
		scenarioContext.setActiveUserProfile(AppConstants.GITHUB_APP, userProfileName);
	}
	
	@Given("User is already logged in using {string} user profile.")
	public void user_is_already_logged_in_using_user_profile(String userProfileName) {
		scenarioContext.setActiveUserProfile(AppConstants.GITHUB_APP, userProfileName);
	}
	
	@Then("Verify the login page is displayed.")
	public void verify_the_login_page_is_displayed() {
		GithubMainPO.LINK_SignIn.getValidator(scenarioContext, null).validatePresent(3);
	}
}
