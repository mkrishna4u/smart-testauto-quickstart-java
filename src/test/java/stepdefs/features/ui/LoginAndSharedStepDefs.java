package stepdefs.features.ui;

import org.uitnet.testing.smartfwk.ui.core.DefaultAppConnector;
import org.uitnet.testing.smartfwk.ui.core.SmartAppConnector;
import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
import org.uitnet.testing.smartfwk.ui.core.cache.DefaultSmartCache;
import org.uitnet.testing.smartfwk.ui.core.cache.SmartCache;

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
public class LoginAndSharedStepDefs {
	private DefaultAppConnector appConnector;
	private Scenario runningScenario;
	private SmartAppDriver appDriver; 
	private SmartCache globalCache;
	
	public LoginAndSharedStepDefs() {
		globalCache = DefaultSmartCache.getInstance();
		appConnector = SmartAppConnector.connect(AppConstants.GITHUB_APP);
		globalCache.setAppConnector(appConnector);
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		runningScenario = scenario;
		
		globalCache.setRunningScenario(scenario);
		globalCache.publish(globalCache);
		
		appConnector.captureScreenshot(runningScenario, "scenario-started");
	}

	@After
	public void afterScenario(Scenario scenario) {
		appConnector.captureScreenshot(scenario, "scenario-" + scenario.getStatus());
	}
	
	@When("User login using {string} user profile.")
	public void user_login_using_user_profile(String userProfileName) {
		appDriver = appConnector.setActiveUserProfileName(userProfileName);
		globalCache.setAppDriver(appDriver);
		globalCache.publish(globalCache);
	}
	
	@Given("User is already logged in using {string} user profile.")
	public void user_is_already_logged_in_using_user_profile(String userProfileName) {
		appDriver = appConnector.setActiveUserProfileName(userProfileName);
		globalCache.setAppDriver(appDriver);
		globalCache.publish(globalCache);
	}
	
	@Then("Verify the login page is displayed.")
	public void verify_the_login_page_is_displayed() {
		GithubMainPO.LINK_SignIn.getValidator(appDriver, null).validatePresent(3);
	}
}
