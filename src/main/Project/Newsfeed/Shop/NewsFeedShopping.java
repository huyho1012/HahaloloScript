package Newsfeed.Shop;

import Newsfeed.Common.FeedCommon;
import org.openqa.selenium.WebDriver;
public class NewsFeedShopping extends FeedCommon {
    WebDriver driver;
    public NewsFeedShopping(WebDriver webDriver){
        driver = webDriver;
    }

//    public String getTitle(String tabMenu) {
//        waitElementToVisible(driver, HeaderPageUI.NEWS_FEED_MENU,tabMenu);
//        return driver.getTitle();
//    }
}
