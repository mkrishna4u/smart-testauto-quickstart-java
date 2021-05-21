package smartfwk.testing.sample.gmail.page_objects;

import smartfwk.testing.ui.core.commons.UIObjectType;
import smartfwk.testing.ui.core.objects.ImageObject;
import smartfwk.testing.ui.standard.domobj.ButtonSD;
import smartfwk.testing.ui.standard.domobj.TextBoxSD;

public class GmailLoginPO {
	public static final ImageObject IMG_LOGIN_PAGE_TITLE = new ImageObject(UIObjectType.label, "Login success user banner", 
			"login-page-title.png");
	
	public static final TextBoxSD TEXTBOX_USERNAME = new TextBoxSD("Email", "//input[@id='identifierId']");
	public static final ButtonSD BUTTON_NEXT = new ButtonSD("Next", "//div[@class='VfPpkd-RLmnJb']");
	public static final TextBoxSD TEXTBOX_PASSWORD = new TextBoxSD("Password", "//input[@name='password']");
	public static final ButtonSD BUTTON_PWD_NEXT = new ButtonSD("Next", "//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']//div[@class='VfPpkd-RLmnJb']");
	public static final ButtonSD LABEL_LOGIN_PAGE = new ButtonSD("Sign in to continue to Gmail", "//span[normalize-space()='to continue to Gmail']");
}
