package page_objects.github;

import org.uitnet.testing.smartfwk.ui.standard.domobj.LabelSD;

/**
 * 
 * @author Ajita Krishna
 *
 */
public interface TopMenuPO {
	LabelSD Menu_Home = new LabelSD("Home menu", "(//a[@aria-label='Homepage '])[1]");
	LabelSD TopMenu_List = new LabelSD("Top menu list", "//nav[@id='global-nav']//a[contains(@class, 'js-selected-navigation-item Header-link') and not(contains(@class, 'd-md-none'))]");
}
