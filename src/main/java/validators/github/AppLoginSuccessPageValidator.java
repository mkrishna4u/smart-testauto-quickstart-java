package validators.github;

import org.uitnet.testing.smartfwk.ui.core.appdriver.SmartAppDriver;
import org.uitnet.testing.smartfwk.ui.core.objects.logon.LoginSuccessPageValidator;
import page_objects.github.LoginSuccessPO;

/**
 * @author Ajita Krishna
 */
public class AppLoginSuccessPageValidator extends LoginSuccessPageValidator {

    public AppLoginSuccessPageValidator() {
        super(null, null);
    }

    @Override
    public void setInitParams(SmartAppDriver appDriver) {
        this.appDriver = appDriver;
    }

    @Override
    protected void tryLogout(String activeUserProfileName) {
        LoginSuccessPO.Image_UserIcon.getValidator(appDriver, null).click(0);
        appDriver.waitForSeconds(1);
        LoginSuccessPO.Menu_Signout.getValidator(appDriver, null).click(0);
    }

    @Override
    protected void validateInfo(String activeUserProfileName) {
        LoginSuccessPO.Image_UserIcon.getValidator(appDriver, null).validatePresent(2);
    }

    @Override
    protected boolean checkLoginSuccessPageVisible(String activeUserProfileName) {
        return LoginSuccessPO.Image_UserIcon.getValidator(appDriver, null).isPresent(2);
    }
}
