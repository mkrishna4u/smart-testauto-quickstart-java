package page_objects;

import org.uitnet.testing.smartfwk.ui.standard.domobj.HyperlinkSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.ImageSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.LabelSD;
import org.uitnet.testing.smartfwk.ui.standard.domobj.TextBoxSD;

/**
 * 
 * @author Ajita Krishna
 *
 */
public interface GithubHomePO {

	HyperlinkSD LINK_Notifications = new HyperlinkSD("Notifications", "//a[@data-target='notification-indicator.link']");
	ImageSD IMAGE_UserIcon = new ImageSD( "User Icon", "//summary[@aria-label='View profile and more']//img");
	LabelSD LABEL_Repositories = new LabelSD("Repositories", "//h2[normalize-space()='Repositories']");
	TextBoxSD TEXTBOX_FindARepository = new TextBoxSD("Find a repository", "//input[@id='dashboard-repos-filter-left']");
	
	LabelSD LIST_Repositories = new LabelSD("List Repositories", "//ul[@data-filterable-for='dashboard-repos-filter-left']/li[not (@hidden)]//a");
	
	LabelSD MENU_Signout = new LabelSD("Sign out", "//button[contains(text(),'Sign out')]");
	
}
