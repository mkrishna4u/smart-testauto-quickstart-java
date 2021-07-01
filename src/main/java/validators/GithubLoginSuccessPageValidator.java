package validators;

import org.uitnet.testing.smartfwk.ui.core.config.webbrowser.WebBrowser;
import org.uitnet.testing.smartfwk.ui.core.objects.logon.LoginSuccessPageValidator;

import page_objects.GithubHomePO;

/**
 * 
 * @author Ajita Krishna
 *
 */
public class GithubLoginSuccessPageValidator extends LoginSuccessPageValidator {

	public GithubLoginSuccessPageValidator() {
		super(null, null);
	}

	@Override
	public void setInitParams(WebBrowser browser) {
		this.browser = browser;

	}

	@Override
	protected void tryLogout(String activeUserProfileName) {
		GithubHomePO.IMAGE_UserIcon.getValidator(browser, null).click(0);
		browser.waitForSeconds(1);
		GithubHomePO.MENU_Signout.getValidator(browser, null).click(0);
	}

	@Override
	protected void validateInfo(String activeUserProfileName) {
		GithubHomePO.IMAGE_UserIcon.getValidator(browser, null).validatePresent(2);	
	}

	@Override
	protected boolean checkLoginSuccessPageVisible(String activeUserProfileName) {
		return GithubHomePO.IMAGE_UserIcon.getValidator(browser, null).isPresent(2);
	}
}
