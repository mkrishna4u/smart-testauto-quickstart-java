package validators.github;

import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
import org.uitnet.testing.smartfwk.ui.core.config.AppConfig;
import org.uitnet.testing.smartfwk.ui.core.config.UserProfile;
import org.uitnet.testing.smartfwk.ui.core.objects.NewTextLocation;
import org.uitnet.testing.smartfwk.ui.core.objects.logon.LoginPageValidator;
import page_objects.github.LoginPO;
import page_objects.github.MainPO;

/**
 *
 * @author Ajita Krishna
 *
 */
public class AppLoginPageValidator extends LoginPageValidator {

    public AppLoginPageValidator() {
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

        MainPO.Link_SignIn.getValidator(appDriver, null).click(5);

        LoginPO.Label_SignInToGithub.getValidator(appDriver, null).validateVisible(5);
        LoginPO.Textbox_UsernameOrEmailAddress.getValidator(appDriver, null)
                .typeText(userProfile.getAppLoginUserId(), NewTextLocation.replace, 0);
        LoginPO.Textbox_Password.getValidator(appDriver, null).typeText(userProfile.getAppLoginUserPassword(),
                NewTextLocation.replace, 0);
        LoginPO.Button_SignIn.getValidator(appDriver, null).click(0);
    }

    @Override
    protected void validateInfo(String activeUserProfileName) {
        MainPO.Link_SignIn.getValidator(appDriver, null).validateVisible(2);
    }

    @Override
    public boolean checkLoginPageVisible(String activeUserProfileName) {
        return MainPO.Link_SignIn.getValidator(appDriver, null).isVisible(2);
    }

}
