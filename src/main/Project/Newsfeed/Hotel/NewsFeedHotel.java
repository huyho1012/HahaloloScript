package Newsfeed.Hotel;

import Newsfeed.Common.FeedCommon;
import org.openqa.selenium.WebDriver;

public class NewsFeedHotel extends FeedCommon {
    WebDriver driver;
    public NewsFeedHotel(WebDriver webDriver){
        driver = webDriver;
    }
    public boolean checkHotelTabSelected() {
        waitElementToVisible(driver, HotelTabPageUI.HOTEL_SEARCH_FORM);
        return checkIsDisplayedElement(driver,HotelTabPageUI.HOTEL_SEARCH_FORM);
    }
}
