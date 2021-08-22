package stepdefs.features.ui.home;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.uitnet.testing.smartfwk.ui.core.DefaultUITestHelper;
import org.uitnet.testing.smartfwk.ui.core.config.webbrowser.WebBrowser;
import org.uitnet.testing.smartfwk.ui.core.objects.NewTextLocation;

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
	private DefaultUITestHelper uiTestHelper;
	private Scenario runningScenario;
	private WebBrowser browser;

	/**
	 * Constructor
	 */
	public HomeStepDefs() {
		uiTestHelper = DefaultUITestHelper.getInstance();		
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

	@When("User login using {string} user profile.")
	public void user_login_using_user_profile(String userProfileName) {
		uiTestHelper.init("github-app", "github-app-web-browser", null, userProfileName);
		uiTestHelper.setActiveUserProfileName(userProfileName);
		browser = uiTestHelper.getInitWebBrowser();

	}

	@Then("Home page is displayed.")
	public void home_page_is_displayed() {
		GithubHomePO.LINK_Notifications.getValidator(browser, null).validatePresent(5);
	}

	@Then("Verify the following information is present on the home page:")
	public void verify_the_following_information_is_present_on_the_home_page(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists();

		for (List<String> cols : rows) {
			String item = cols.get(0);

			if ("Notification Icon".equals(item)) {
				GithubHomePO.LINK_Notifications.getValidator(browser, null).validatePresent(3);
			} else if ("User Icon".equals(item)) {
				GithubHomePO.IMAGE_UserIcon.getValidator(browser, null).validatePresent(3);
			} else if ("Repositories Label".equals(item)) {
				GithubHomePO.LABEL_Repositories.getValidator(browser, null).validatePresent(3);
			} else if ("Find a repository Textbox".equals(item)) {
				GithubHomePO.TEXTBOX_FindARepository.getValidator(browser, null).validatePresent(3);
			} else {
				Assert.fail("No handling present for item '" + item + "'.");
			}
		}

	}

	@Given("User is already logged in using {string} user profile.")
	public void user_is_already_logged_in_using_user_profile(String userProfileName) {
		uiTestHelper.init("github-app", "github-app-web-browser", null, userProfileName);
		uiTestHelper.setActiveUserProfileName(userProfileName);
		browser = uiTestHelper.getInitWebBrowser();
	}

	@Given("Navigate to home page.")
	public void navigate_to_home_page() {
		TopMenuPO.MENU_Home.getValidator(browser, null).click(5);
		browser.waitForSeconds(2);
	}

	@When("The user types {string} in the <Find a repository> textbox present on home page.")
	public void the_user_types_in_the_find_a_repository_textbox_present_on_home_page(String textToType) {
		GithubHomePO.TEXTBOX_FindARepository.getValidator(browser, null).typeText(textToType, NewTextLocation.replace,
				2);
		browser.waitForSeconds(2);
	}

	@Then("The filter should show all the labels which contains {string} on home page.")
	public void the_filter_should_show_all_the_labels_which_contains_on_home_page(String text) {
		List<WebElement> elems = GithubHomePO.LIST_Repositories.getValidator(browser, null).findElements(5);

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
		GithubHomePO.IMAGE_UserIcon.getValidator(browser, null).click(0);
	}

	@When("From the menu items click <Sign out> on home page.")
	public void from_the_menu_items_click_sign_out_on_home_page() {
		GithubHomePO.MENU_Signout.getValidator(browser, null).click(2);
	}

	@Then("Verify the login page is displayed.")
	public void verify_the_login_page_is_displayed() {
		GithubMainPO.LINK_SignIn.getValidator(browser, null).validatePresent(3);
	}
	
	@Then("Close the web browser.")
	public void close_the_web_browser() {
		browser.quit();
	}
}
