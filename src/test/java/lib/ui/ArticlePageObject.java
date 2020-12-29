package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            MY_LISTS_ITEM_TPL,
            ARTICLE_TITLE_TPL,
            CLOSE_SYNC_YOUR_SAVED_ARTICLES;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /* TEMPLATE METHODS */
    private static String getFolderNameElement(String name_of_folder) {
        return MY_LISTS_ITEM_TPL.replace("{NAME_OF_FOLDER}", name_of_folder);
    }

    private static String getArticleNameElement(String article_title) {
        return ARTICLE_TITLE_TPL.replace("{ARTICLE_TITLE}", article_title);
    }

    private static String getArticleTitleElement(String article_title) {
        return TITLE.replace("{ARTICLE_TITLE}", article_title);
    }

    /* TEMPLATE METHODS */

    public WebElement waitForTitleElement() {
        //String article_title_id = getArticleNameElement(TITLE);
        return this.waitForElementPresent(TITLE, "Cannot find article title on Page", 5);
    }

    public WebElement waitForTitleElementIOS(String title) {
        String article_title_id = getArticleTitleElement(title);
        return this.waitForElementPresent(article_title_id, "Cannot find article title on Page", 5);
    }

    public String getArticleTitle() {

        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");

        } else if (Platform.getInstance().isIOS()) {
            return title_element.getAttribute("name");

        } else {
            return title_element.getText();
        }
    }

    public String getArticleTitleIOS(String title) {
        WebElement title_element = waitForTitleElementIOS(title);
        return title_element.getAttribute("name");

    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppeared(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        }

    }

    public void addArticleToMyList(String name_of_folder) {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find hamburger menu button",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "'Add to list' button not found",
                7
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "'Got it' button not found",
                7
        );


        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input field for entering the folder name",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot find input field for entering the folder name",
                10
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot tap 'OK' button on the pop-up window",
                5
        );

    }

    public void addSecondArticleToMyList(String name_of_folder) {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find hamburger menu button",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "'Add to list' button not found",
                7
        );
        String name_of_folder_xpath = getFolderNameElement(name_of_folder);

        this.waitForElementAndClick(
                name_of_folder_xpath,
                "Folder with '" + name_of_folder + "'name wasn't found",
                5
        );

    }

    public void addArticlesToMySaved() throws InterruptedException {

        if (Platform.getInstance().isMW()) {
            Thread.sleep(1000);
            this.removeArticleFromSavedIfItAdded();
        }
        Thread.sleep(1000);

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 3);

    }

    public void removeArticleFromSavedIfItAdded() throws InterruptedException {


        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot find and click button to remove article from my saved",
                    4
            );
            Thread.sleep(1000);
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before",
                    2
            );
        }
    }


    public void closeArticle() {
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot find X button",
                    5
            );
        } else {
            System.out.println("Method closeArticle does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void checkArticleTitlePresent(String article_title) {
        if (Platform.getInstance().isAndroid()) {
            String article_title_xpath = getArticleNameElement(article_title);
            this.waitForElementPresent(
                    article_title_xpath,
                    "Cannot find article title",
                    15
            );
        } else {
            String article_title_id = getArticleTitleElement(article_title);
            this.waitForElementPresent(
                    article_title_id,
                    "Cannot find article title",
                    15
            );
        }

    }
}
