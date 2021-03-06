package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        SWIPE_ACTION_TO_DELETE = "id:swipe action delete";
        CLOSE_SYNC_YOUR_SAVED_ARTICLES = "id:Close";

    }
    public IOSMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
