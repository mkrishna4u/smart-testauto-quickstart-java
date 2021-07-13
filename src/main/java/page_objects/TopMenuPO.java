package page_objects;

import org.uitnet.testing.smartfwk.ui.standard.domobj.LabelSD;

/**
 * 
 * @author Ajita Krishna
 *
 */
public interface TopMenuPO {
	LabelSD MENU_Home = new LabelSD("Home menu", "(//a[@aria-label='Homepage '])[1]");
	
}
