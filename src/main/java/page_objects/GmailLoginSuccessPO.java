package page_objects;

import org.uitnet.testing.smartfwk.ui.core.commons.UIObjectType;
import org.uitnet.testing.smartfwk.ui.core.objects.ImageObject;
import org.uitnet.testing.smartfwk.ui.standard.domobj.ButtonSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.LabelSD;
import org.uitnet.testing.smartfwk.ui.standard.imgobj.WebPageTitleSI;

public class GmailLoginSuccessPO {
	public static final WebPageTitleSI LOGIN_SUCCESS_WEBPAGE_TITLE = new WebPageTitleSI("Login page title", 
			"login-success-user-img.png");
	
	public static final LabelSD LABEL_ACCOUNT_DESC = new LabelSD("User Account Description Image", 
			"//img[@class='gb_Da gbii']");
	
	public static final ButtonSD BUTTON_SIGNOUT = new ButtonSD("Sign out", 
			"//a[normalize-space()='Sign out']");
	
	public static final ImageObject LOGIN_SUCCESS_USER_BANNER = new ImageObject(UIObjectType.label, "Login success user banner", 
			"login-success-user-img.png");
	
	public static final ButtonSD BUTTON_COMPOSE = new ButtonSD("COMPOSE", 
			"//div[contains(text(),'Compose')]");
}
