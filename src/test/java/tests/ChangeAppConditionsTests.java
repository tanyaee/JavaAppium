package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

import java.time.Duration;

public class ChangeAppConditionsTests extends CoreTestCase {
    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String title_before_rotation;
        if (Platform.getInstance().isAndroid()){
            title_before_rotation = ArticlePageObject.getArticleTitle();
        } else {
            ArticlePageObject.waitForTitleElementIOS("Java (programming language)");
            title_before_rotation = ArticlePageObject.getArticleTitleIOS("Java (programming language)");
        }
        this.rotateScreenLandscape();

        String title_after_rotation;

        if (Platform.getInstance().isAndroid()){
            title_after_rotation = ArticlePageObject.getArticleTitle();
        } else {
            ArticlePageObject.waitForTitleElementIOS("Java (programming language)");
            title_after_rotation = ArticlePageObject.getArticleTitleIOS("Java (programming language)");
        }

        assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        this.rotateScreenPortrait();
        String title_after_second_rotation;

        if (Platform.getInstance().isAndroid()){
            title_after_second_rotation = ArticlePageObject.getArticleTitle();
        } else {
            ArticlePageObject.waitForTitleElementIOS("Java (programming language)");

            title_after_second_rotation = ArticlePageObject.getArticleTitleIOS("Java (programming language)");
        }
        assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }


    @Test
    public void testCheckSearchArticleInBackground()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        this.backgroundApp(Duration.ofSeconds(2));
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }

}
