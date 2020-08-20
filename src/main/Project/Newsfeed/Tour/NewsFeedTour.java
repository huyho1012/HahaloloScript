package Newsfeed.Tour;

import Newsfeed.Common.FeedCommon;
import org.openqa.selenium.WebDriver;

public class NewsFeedTour extends FeedCommon {
    WebDriver driver;
    public NewsFeedTour(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourTabSelected() {
        waitElementToVisible(driver, TourTabPageUI.TOUR_SEARCH_FORM);
        return checkIsDisplayedElement(driver, TourTabPageUI.TOUR_SEARCH_FORM);
    }
}
