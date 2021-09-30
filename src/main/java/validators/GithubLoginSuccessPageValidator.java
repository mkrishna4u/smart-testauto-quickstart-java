package validators;

import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
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
	public void setInitParams(SmartAppDriver appDriver) {
		this.appDriver = appDriver;

	}

	@Override
	protected void tryLogout(String activeUserProfileName) {
		GithubHomePO.IMAGE_UserIcon.getValidator(appDriver, null).click(0);
		appDriver.waitForSeconds(1);
		GithubHomePO.MENU_Signout.getValidator(appDriver, null).click(0);
	}

	@Override
	protected void validateInfo(String activeUserProfileName) {
		GithubHomePO.IMAGE_UserIcon.getValidator(appDriver, null).validatePresent(2);	
	}

	@Override
	protected boolean checkLoginSuccessPageVisible(String activeUserProfileName) {
		return GithubHomePO.IMAGE_UserIcon.getValidator(appDriver, null).isPresent(2);
	}
}
