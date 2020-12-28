package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareArticleTitle() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title;

        if (Platform.getInstance().isIOS()) {
            ArticlePageObject.waitForTitleElementIOS("Java (programming language)");
            article_title = ArticlePageObject.getArticleTitleIOS("Java (programming language)");
        } else {
            article_title = ArticlePageObject.getArticleTitle();

        }


        assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );

    }

    @Test
    public void testSwipeArticle() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        if(Platform.getInstance().isIOS()){
            ArticlePageObject.waitForTitleElementIOS("Java (programming language)");

        } else {
            ArticlePageObject.waitForTitleElement();

        }
        ArticlePageObject.swipeToFooter();

    }


    @Test
    public void testAssertTitlePresent(){

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        String search_line = "Appium";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.clickByArticleWithSubstring(search_line);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        if(Platform.getInstance().isIOS()){
            ArticlePageObject.waitForTitleElementIOS(search_line);
        } else {
            ArticlePageObject.waitForTitleElement();
        }

        ArticlePageObject.checkArticleTitlePresent(search_line);

    }
}
