package page_objects;

import org.uitnet.testing.smartfwk.ui.core.commons.UIObjectType;
import org.uitnet.testing.smartfwk.ui.core.objects.ImageObject;
import org.uitnet.testing.smartfwk.ui.standard.domobj.ButtonSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.LabelSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.TextBoxSD;
import org.uitnet.testing.smartfwk.ui.standard.imgobj.ImageSI;

public interface GithubLoginPO {
	ImageSI IMG_GithubLoginIcon = new ImageSI("Sign in to GitHub Image", "SignInToGithubImage.jpg", null);
	LabelSD LABEL_SignInToGithub = new LabelSD("Sign in to GitHub", "//h1[normalize-space()='Sign in to GitHub']");
	TextBoxSD TEXTBOX_UsernameOrEmailAddress = new TextBoxSD("Username or email address", "//input[@id='login_field']");
	TextBoxSD TEXTBOX_Password = new TextBoxSD("Password", "//input[@id='password']");
	ButtonSD BUTTON_SignIn = new ButtonSD("Sign in", "//input[@value='Sign in' and @name='commit']");

}
