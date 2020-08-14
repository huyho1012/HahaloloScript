package actions.PageObject.Newsfeed.PageFeed;

import actions.PageObject.Newsfeed.Common.HeaderMenu;
import interfaces.Newsfeed.TabFeed.TourTabPageUI;
import org.openqa.selenium.WebDriver;

public class NewsFeedTour extends HeaderMenu {
    WebDriver driver;
    public NewsFeedTour(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourTabSelected() {
        waitElementToVisible(driver, TourTabPageUI.TOUR_SEARCH_FORM);
        return checkIsDisplayedElement(driver, TourTabPageUI.TOUR_SEARCH_FORM);
    }
}
