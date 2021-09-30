package stepdefs.features.ui.home;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.uitnet.testing.smartfwk.ui.core.DefaultAppConnector;
import org.uitnet.testing.smartfwk.ui.core.SmartAppConnector;
import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
import org.uitnet.testing.smartfwk.ui.core.objects.NewTextLocation;

import global.AppConstants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.GithubHomePO;
import page_objects.GithubMainPO;
import page_objects.TopMenuPO;

/**
 * 
 * @author Ajita Krishna
 *
 */
public class HomeStepDefs {
	private DefaultAppConnector appConnector;
	private Scenario runningScenario;
	private SmartAppDriver appDriver;

	/**
	 * Constructor
	 */
	public HomeStepDefs() {
		appConnector = SmartAppConnector.connect(AppConstants.GITHUB_APP);		
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		runningScenario = scenario;
		appConnector.captureScreenshot(runningScenario, "scenario-started");
	}

	@After
	public void afterScenario(Scenario scenario) {
		appConnector.captureScreenshot(scenario, "scenario-" + scenario.getStatus());
	}

	@When("User login using {string} user profile.")
	public void user_login_using_user_profile(String userProfileName) {
		appDriver = appConnector.setActiveUserProfileName(userProfileName);
	}

	@Then("Home page is displayed.")
	public void home_page_is_displayed() {
		GithubHomePO.LINK_Notifications.getValidator(appDriver, null).validatePresent(5);
	}

	@Then("Verify the following information is present on the home page:")
	public void verify_the_following_information_is_present_on_the_home_page(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists();

		for (List<String> cols : rows) {
			String item = cols.get(0);

			if ("Notification Icon".equals(item)) {
				GithubHomePO.LINK_Notifications.getValidator(appDriver, null).validatePresent(3);
			} else if ("User Icon".equals(item)) {
				GithubHomePO.IMAGE_UserIcon.getValidator(appDriver, null).validatePresent(3);
			} else if ("Repositories Label".equals(item)) {
				GithubHomePO.LABEL_Repositories.getValidator(appDriver, null).validatePresent(3);
			} else if ("Find a repository Textbox".equals(item)) {
				GithubHomePO.TEXTBOX_FindARepository.getValidator(appDriver, null).validatePresent(3);
			} else {
				Assert.fail("No handling present for item '" + item + "'.");
			}
		}

	}

	@Given("User is already logged in using {string} user profile.")
	public void user_is_already_logged_in_using_user_profile(String userProfileName) {
		appDriver = appConnector.setActiveUserProfileName(userProfileName);
	}

	@Given("Navigate to home page.")
	public void navigate_to_home_page() {
		TopMenuPO.MENU_Home.getValidator(appDriver, null).click(5);
		appDriver.waitForSeconds(2);
	}

	@When("The user types {string} in the <Find a repository> textbox present on home page.")
	public void the_user_types_in_the_find_a_repository_textbox_present_on_home_page(String textToType) {
		GithubHomePO.TEXTBOX_FindARepository.getValidator(appDriver, null).typeText(textToType, NewTextLocation.replace,
				2);
		appDriver.waitForSeconds(2);
	}

	@Then("The filter should show all the labels which contains {string} on home page.")
	public void the_filter_should_show_all_the_labels_which_contains_on_home_page(String text) {
		List<WebElement> elems = GithubHomePO.LIST_Repositories.getValidator(appDriver, null).findElements(5);

		for (WebElement elem : elems) {
			String record = elem.getAttribute("href");
			if (record.contains(text)) {
				// Good
			} else {
				Assert.fail("Record '" + record + "' does not contain '" + text + "' keyword.");
			}
		}
	}

	@When("The user clicks on <User icon> on home page.")
	public void the_user_clicks_on_user_icon_on_home_page() {
		GithubHomePO.IMAGE_UserIcon.getValidator(appDriver, null).click(0);
	}

	@When("From the menu items click <Sign out> on home page.")
	public void from_the_menu_items_click_sign_out_on_home_page() {
		GithubHomePO.MENU_Signout.getValidator(appDriver, null).click(2);
	}

	@Then("Verify the login page is displayed.")
	public void verify_the_login_page_is_displayed() {
		GithubMainPO.LINK_SignIn.getValidator(appDriver, null).validatePresent(3);
	}
	
	@Then("Close the web browser.")
	public void close_the_web_appDriver() {
		appDriver.closeApp();
	}
}
