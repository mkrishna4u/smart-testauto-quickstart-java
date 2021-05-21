package smartfwk.testing.sample.gmail.validators;

import smartfwk.testing.sample.gmail.page_objects.GmailLoginPO;
import smartfwk.testing.ui.core.config.AppConfig;
import smartfwk.testing.ui.core.config.UserProfile;
import smartfwk.testing.ui.core.config.webbrowser.WebBrowser;
import smartfwk.testing.ui.core.objects.NewTextLocation;
import smartfwk.testing.ui.core.objects.logon.LoginPageValidator;

public class GmailLoginPageValidator extends LoginPageValidator {

	public GmailLoginPageValidator() {
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
		
		GmailLoginPO.IMG_LOGIN_PAGE_TITLE.getValidator(browser, null).validatePresent(5);

		GmailLoginPO.TEXTBOX_USERNAME.getValidator(browser, null).typeText(userProfile.getAppLoginUserId(),
				NewTextLocation.start, 2);

		GmailLoginPO.BUTTON_NEXT.getValidator(browser, null).click(0);

		GmailLoginPO.TEXTBOX_PASSWORD.getValidator(browser, null)
				.typeText(userProfile.getAppLoginUserPassword(), NewTextLocation.replace, 10);
		GmailLoginPO.BUTTON_PWD_NEXT.getValidator(browser, null).click(0);
	}

	@Override
	protected void validateInfo(String activeUserProfileName) {
		GmailLoginPO.TEXTBOX_PASSWORD.getValidator(browser, null).validatePresent(15);
	}

	@Override
	public boolean checkLoginPageVisible(String activeUserProfileName) {
		return GmailLoginPO.LABEL_LOGIN_PAGE.getValidator(browser, null).isVisible(15);
	}
}
