package validators;

import org.uitnet.testing.smartfwk.ui.core.config.webbrowser.WebBrowser;
import org.uitnet.testing.smartfwk.ui.core.objects.logon.LoginSuccessPageValidator;

import page_objects.GmailLoginSuccessPO;

/**
 * 
 * @author Ajita Krishna
 *
 */
public class GmailLoginSuccessPageValidator extends LoginSuccessPageValidator {

	public GmailLoginSuccessPageValidator() {
		super(null, null);
	}

	@Override
	public void setInitParams(WebBrowser browser) {
		this.browser = browser;

	}

	@Override
	protected void tryLogout(String activeUserProfileName) {
		GmailLoginSuccessPO.LABEL_ACCOUNT_DESC.getValidator(browser, null).click(15);
		browser.waitForSeconds(2);
		GmailLoginSuccessPO.BUTTON_SIGNOUT.getValidator(browser, null).click(10);
	}

	@Override
	protected void validateInfo(String activeUserProfileName) {
		GmailLoginSuccessPO.LABEL_ACCOUNT_DESC.getValidator(browser, null).validatePresent(15);
	}

	@Override
	protected boolean checkLoginSuccessPageVisible(String activeUserProfileName) {
		return GmailLoginSuccessPO.LABEL_ACCOUNT_DESC.getValidator(browser, null).isVisible(15);
	}
}
