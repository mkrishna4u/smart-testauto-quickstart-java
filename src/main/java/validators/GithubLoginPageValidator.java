package validators;

import org.uitnet.testing.smartfwk.ui.core.config.AppConfig;
import org.uitnet.testing.smartfwk.ui.core.config.UserProfile;
import org.uitnet.testing.smartfwk.ui.core.config.webbrowser.WebBrowser;
import org.uitnet.testing.smartfwk.ui.core.objects.NewTextLocation;
import org.uitnet.testing.smartfwk.ui.core.objects.logon.LoginPageValidator;

import page_objects.GithubLoginPO;
import page_objects.GithubMainPO;

/**
 * 
 * @author Ajita Krishna
 *
 */
public class GithubLoginPageValidator extends LoginPageValidator {

	public GithubLoginPageValidator() {
		super(null, null);
	}

	@Override
	public void setInitParams(WebBrowser browser) {
		this.browser = browser;
	}

	@Override
	protected void tryLogin(String activeUserProfileName) {
		AppConfig appConfig = browser.getAppConfig();
		UserProfile userProfile = appConfig.getUserProfile(activeUserProfileName);
		
		GithubMainPO.LINK_SignIn.getValidator(browser, null).click(5);
		
		GithubLoginPO.LABEL_SignInToGithub.getValidator(browser, null).validatePresent(5);
		GithubLoginPO.TEXTBOX_UsernameOrEmailAddress.getValidator(browser, null).typeText(
				userProfile.getAppLoginUserId(), NewTextLocation.replace, 0);
		GithubLoginPO.TEXTBOX_Password.getValidator(browser, null).typeText(
				userProfile.getAppLoginUserPassword(), NewTextLocation.replace, 0);
		GithubLoginPO.BUTTON_SignIn.getValidator(browser, null).click(0);
		
	}

	@Override
	protected void validateInfo(String activeUserProfileName) {
		GithubMainPO.LINK_SignIn.getValidator(browser, null).validatePresent(2);	
	}

	@Override
	public boolean checkLoginPageVisible(String activeUserProfileName) {
		return GithubMainPO.LINK_SignIn.getValidator(browser, null).isPresent(2);
	}
	
}
