package stepdefs.features.ui.logon;

import org.uitnet.testing.smartfwk.ui.core.DefaultUITestHelper;
import org.uitnet.testing.smartfwk.ui.core.config.webbrowser.WebBrowser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Ajita Krishna
 *
 */
public class LoginGoogleEmailStepDefs {
	private DefaultUITestHelper uiTestHelper;
	private Scenario runningScenario;
	private WebBrowser browser;

	public LoginGoogleEmailStepDefs() {
		uiTestHelper = new DefaultUITestHelper();
		uiTestHelper.init("google-email-app", "google-email-app-web-browser", null, "GoogleEmailUserProfile");
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		runningScenario = scenario;
		uiTestHelper.captureScreenshot(scenario, "scenario-started");
	}

	@After
	public void afterScenario(Scenario scenario) {
		uiTestHelper.captureScreenshot(scenario, "scenario-" + scenario.getStatus());
	}

	@Given("^Login on Google email is successful\\.$")
	public void gmailLoginSuccessful() {
		uiTestHelper.checkLogoutAndLoginAgain("GoogleEmailUserProfile");
		browser = uiTestHelper.getInitWebBrowser();
	}

	@When("^Click on Logout button on dashboard\\.$")
	public void clickLogoutButtonOnDashboard() {

	}

	@Then("^Google email login screen will be displayed\\.$")
	public void gmailLoginScreenDisplayed() {
		uiTestHelper.logoutAndQuit();
	}

}
