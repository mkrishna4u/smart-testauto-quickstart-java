package global;

import org.testng.IExecutionListener;
import org.testng.Reporter;
import org.uitnet.testing.smartfwk.ui.core.SmartAppConnector;

/**
 * 
 * @author Ajita Krishna
 *
 */
public class TestNGExecutionListener implements IExecutionListener {
	@Override
	public void onExecutionStart() {

	}

	@Override
	public void onExecutionFinish() {
		Reporter.log("Going to close all opened applications.", true);
		SmartAppConnector.close();
	}
}
