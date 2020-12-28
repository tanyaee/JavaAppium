package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT ="xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT ="xpath://XCUIElementTypeSearchField";
        SEARCH_CANCEL_BUTTON ="xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT ="xpath://XCUIElementTypeCell";
        SEARCH_EMPTY_RESULT_ELEMENT ="xpath://XCUIElementTypeStaticText[@name='No results found']";
        //SEARCH_PREVIOUS_SEARCH_REQUEST_TPL ="xpath://*[@text='{SUBSTRING}']";
        SEARCH_RESULT_CONTAINER ="xpath://XCUIElementTypeCell";
    }

    public IOSSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
