package page_objects;

import org.uitnet.testing.smartfwk.ui.standard.domobj.HyperlinkSD;

/**
 * 
 * @author Ajita Krishna
 *
 */
public interface GithubMainPO {
	HyperlinkSD LINK_SignIn = new HyperlinkSD("Sign in", "//a[normalize-space()='Sign in']");
}
