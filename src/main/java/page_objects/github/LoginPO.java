package page_objects.github;

import org.uitnet.testing.smartfwk.ui.standard.domobj.ButtonSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.LabelSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.TextBoxSD;
import org.uitnet.testing.smartfwk.ui.standard.imgobj.ImageSI;

/**
 *
 * @author Ajita Krishna
 *
 */
public interface LoginPO {
	ImageSI Image_GithubLoginIcon = new ImageSI("Sign in to GitHub Image", "SignInToGithubImage.jpg", null);
	LabelSD Label_SignInToGithub = new LabelSD("Sign in to GitHub", "//h1[normalize-space()='Sign in to GitHub']");
	TextBoxSD Textbox_UsernameOrEmailAddress = new TextBoxSD("Username or email address", "//input[@id='login_field']");
	TextBoxSD Textbox_Password = new TextBoxSD("Password", "//input[@id='password']");
	ButtonSD Button_SignIn = new ButtonSD("Sign in", "//input[@value='Sign in' and @name='commit']");

}
