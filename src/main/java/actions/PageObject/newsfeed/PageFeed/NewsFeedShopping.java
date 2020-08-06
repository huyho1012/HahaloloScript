package actions.PageObject.newsfeed.PageFeed;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import interfaces.Newsfeed.Common.HeaderPageUI;
import org.openqa.selenium.WebDriver;
public class NewsFeedShopping extends HeaderMenu {
    WebDriver driver;
    public NewsFeedShopping(WebDriver webDriver){
        driver = webDriver;
    }

    public String getTitle(String tabMenu) {
        waitElementToVisible(driver, HeaderPageUI.NEWS_FEED_MENU,tabMenu);
        return driver.getTitle();
    }
}
