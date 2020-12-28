package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUi extends MainPageObject {
    protected static String
        MY_LISTS_LINK,
        OPEN_NAVIGATION;


    public NavigationUi(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation(){
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open naviagtion button",5);
        } else {
            System.out.println("Method openNavigation() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void cLickMyLists(){
        if (Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "My lists are not found in navigation bar",
                    5
                    );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "My lists are not found in navigation bar",
                    5
            );
        }
    }
}
