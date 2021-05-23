package smartfwk.testing.sample.gmail.features.stepdefs.logon;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import smartfwk.testing.ui.core.DefaultUITestHelper;
import smartfwk.testing.ui.core.commons.UIObjectType;
import smartfwk.testing.ui.core.events.MouseEvent;
import smartfwk.testing.ui.core.events.MouseEventName;
import smartfwk.testing.ui.core.objects.ImageObject;
import smartfwk.testing.ui.core.objects.webpage.PathItem;
import smartfwk.testing.ui.core.objects.webpage.WebPage;
import smartfwk.testing.ui.core.objects.webpage.WebPagePath;
import smartfwk.testing.ui.core.objects.webpage.WebPageRecognitionItems;
import smartfwk.testing.ui.standard.imgobj.WebPageTitleSI;

public class LoginGoogleEmailStepDefs {
	private DefaultUITestHelper uiTestcaseMgr;
	private Scenario runningScenario;
	public LoginGoogleEmailStepDefs() {
		uiTestcaseMgr = new DefaultUITestHelper();
		uiTestcaseMgr.init("google-email-app", "google-email-app-web-browser", 
				new WebPage(
						new WebPageTitleSI("Login success user banner", "login-success-user-img.png"), 
						new WebPagePath()
							.append(new PathItem(
								new ImageObject(UIObjectType.label, "Login success user banner", "login-page-title.png"), new MouseEvent(MouseEventName.mouseClick))), 
						new WebPageRecognitionItems().addItem(new ImageObject(UIObjectType.label, "Login success user banner", "login-success-user-img.png"))), 
				"GoogleEmailUserProfile");
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
		runningScenario = scenario;
		uiTestcaseMgr.captureScreenshot(scenario, "scenario-started");
	}

	@After
	public void afterScenario(Scenario scenario) {
		uiTestcaseMgr.captureScreenshot(scenario, "scenario-" + scenario.getStatus());
	}
	
	@Given("^Login on Google email is successful\\.$")
	public void gmailLoginSuccessful() {		
		uiTestcaseMgr.checkLogoutAndLoginAgain("GoogleEmailUserProfile");
	}
	
	@When("^Click on Logout button on dashboard\\.$")
	public void clickLogoutButtonOnDashboard() {
		
	}
	
	@Then("^Google email login screen will be displayed\\.$")
	public void gmailLoginScreenDisplayed() {
		uiTestcaseMgr.logoutAndQuit();
	}
	
}
