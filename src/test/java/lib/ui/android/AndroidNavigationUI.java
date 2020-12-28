package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUi;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUi {
    static {
        MY_LISTS_LINK = "xpath://*[@content-desc='My lists']";

    }
    public AndroidNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

}
