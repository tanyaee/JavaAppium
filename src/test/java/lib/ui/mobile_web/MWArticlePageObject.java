package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@id='ca-watch'][text()='Watch']";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#ca-watch.watched";
        MY_LISTS_ITEM_TPL = "xpath://*[@text='{NAME_OF_FOLDER}']";
        ARTICLE_TITLE_TPL = "xpath://*[@text='{ARTICLE_TITLE}']";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }

}
