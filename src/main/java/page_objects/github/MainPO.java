package page_objects.github;

import org.uitnet.testing.smartfwk.ui.standard.domobj.HyperlinkSD;

/**
 * 
 * @author Ajita Krishna
 *
 */
public interface MainPO {
	HyperlinkSD Link_SignIn = new HyperlinkSD("Sign in", "//a[normalize-space()='Sign in']");
}
