package page_objects;

import org.uitnet.testing.smartfwk.ui.core.commons.UIObjectType;
import org.uitnet.testing.smartfwk.ui.core.objects.ImageObject;
import org.uitnet.testing.smartfwk.ui.standard.domobj.ButtonSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.TextBoxSD;

public class GmailLoginPO {
	public static final ImageObject IMG_LOGIN_PAGE_TITLE = new ImageObject(UIObjectType.label, "Login success user banner", 
			"login-page-title.png");
	
	public static final TextBoxSD TEXTBOX_USERNAME = new TextBoxSD("Email", "//input[@id='identifierId']");
	public static final ButtonSD BUTTON_NEXT = new ButtonSD("Next", "(//button[@type='button'])[3]");
	public static final TextBoxSD TEXTBOX_PASSWORD = new TextBoxSD("Password", "//input[@name='password']");
	public static final ButtonSD BUTTON_PWD_NEXT = new ButtonSD("Next", "(//button[@type='button'])[2]");
	public static final ButtonSD LABEL_LOGIN_PAGE = new ButtonSD("Sign in to continue to Gmail", "//span[normalize-space()='to continue to Gmail']");
}
