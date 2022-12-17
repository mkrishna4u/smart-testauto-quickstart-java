package page_objects.github;

import org.uitnet.testing.smartfwk.ui.standard.domobj.*;

/**
 *
 * @author Ajita Krishna
 *
 */
public interface LoginSuccessPO {
	HyperlinkSD Link_Notifications = new HyperlinkSD("Notifications", "//a[@data-target='notification-indicator.link']");
	ImageSD Image_UserIcon = new ImageSD( "User Icon", "//summary[@aria-label='View profile and more']//img");
	ImageSD Image_NotificationIcon = new ImageSD("Notifictaion Icon", "//a[@id='AppHeader-notifications-button']//*[name()='svg']");
	LabelSD Label_Repositories = new LabelSD("Repositories", "//h2[normalize-space()='Repositories']");
	TextBoxSD Textbox_FindARepository = new TextBoxSD("Find a repository", "//input[@id='dashboard-repos-filter-left']");

	LabelSD List_Repositories = new LabelSD("List Repositories", "//ul[@data-filterable-for='dashboard-repos-filter-left']/li[not (@hidden)]//a[contains(@class, 'markdown-title')]");

	LabelSD Menu_Signout = new LabelSD("Sign out", "//button[contains(text(),'Sign out')]");

}
