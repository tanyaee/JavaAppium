package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:{ARTICLE_TITLE}";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Search";
        MY_LISTS_ITEM_TPL = "xpath://*[@text='{NAME_OF_FOLDER}']";
        ARTICLE_TITLE_TPL = "xpath://*[@text='{ARTICLE_TITLE}']";
        CLOSE_SYNC_YOUR_SAVED_ARTICLES = "id:places auth close";
    }

    public IOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
