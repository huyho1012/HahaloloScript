package Newsfeed.Hotel;

import HeaderMain.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class NewsFeedHotel extends HeaderMenu {
    WebDriver driver;
    public NewsFeedHotel(WebDriver webDriver){
        driver = webDriver;
    }
    public boolean checkHotelTabSelected() {
        waitElementToVisible(driver, HotelTabPageUI.HOTEL_SEARCH_FORM);
        return checkIsDisplayedElement(driver,HotelTabPageUI.HOTEL_SEARCH_FORM);
    }
}
