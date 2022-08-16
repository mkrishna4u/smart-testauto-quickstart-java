package validators;

import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
import org.uitnet.testing.smartfwk.ui.core.config.AppConfig;
import org.uitnet.testing.smartfwk.ui.core.config.UserProfile;
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
	public void setInitParams(SmartAppDriver appDriver) {
		this.appDriver = appDriver;
	}

	@Override
	protected void tryLogin(String activeUserProfileName) {
		AppConfig appConfig = appDriver.getAppConfig();
		UserProfile userProfile = appConfig.getUserProfile(activeUserProfileName);

		GithubMainPO.LINK_SignIn.getValidator(appDriver, null).click(5);

		GithubLoginPO.LABEL_SignInToGithub.getValidator(appDriver, null).validateVisible(5);
		GithubLoginPO.TEXTBOX_UsernameOrEmailAddress.getValidator(appDriver, null)
				.typeText(userProfile.getAppLoginUserId(), NewTextLocation.replace, 0);
		GithubLoginPO.TEXTBOX_Password.getValidator(appDriver, null).typeText(userProfile.getAppLoginUserPassword(),
				NewTextLocation.replace, 0);
		GithubLoginPO.BUTTON_SignIn.getValidator(appDriver, null).click(0);

	}

	@Override
	protected void validateInfo(String activeUserProfileName) {
		GithubMainPO.LINK_SignIn.getValidator(appDriver, null).validateVisible(2);
	}

	@Override
	public boolean checkLoginPageVisible(String activeUserProfileName) {
		return GithubMainPO.LINK_SignIn.getValidator(appDriver, null).isVisible(2);
	}

}
