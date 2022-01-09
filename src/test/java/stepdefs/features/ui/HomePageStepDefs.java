package stepdefs.features.ui;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.uitnet.testing.smartfwk.ui.core.AbstractAppConnector;
import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
import org.uitnet.testing.smartfwk.ui.core.cache.DefaultSmartCache;
import org.uitnet.testing.smartfwk.ui.core.cache.SmartCache;
import org.uitnet.testing.smartfwk.ui.core.cache.SmartCacheSubscriber;
import org.uitnet.testing.smartfwk.ui.core.objects.NewTextLocation;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.GithubHomePO;
import page_objects.TopMenuPO;

/**
 * Step definitions for Home page.
 * 
 * @author Ajita Krishna
 *
 */
public class HomePageStepDefs {
	// ------------- Common Code for step definition - START -------
	private AbstractAppConnector appConnector;
	private Scenario runningScenario;
	private SmartAppDriver appDriver;
	private SmartCache globalCache;

	/**
	 * Constructor
	 */
	public HomePageStepDefs() {
		globalCache = DefaultSmartCache.getInstance();
		
		appConnector = globalCache.getAppConnector();
		runningScenario = globalCache.getRunningScenario();
		appDriver = globalCache.getAppDriver();
				
		// Subscribe to the the cache to get the latest data
		globalCache.subscribe(new SmartCacheSubscriber() {
			@Override
			protected void onMessage(SmartCache message) {
				appConnector = message.getAppConnector();
				runningScenario = message.getRunningScenario();
				appDriver = message.getAppDriver();
			}
		});
	}
	
	// ------------- Common Code for step definition - END -------

	// ------------- Step definition starts here -----------------
	
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
}
