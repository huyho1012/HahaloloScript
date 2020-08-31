package Newsfeed.Flight;

import Newsfeed.Common.FeedCommon;
import org.openqa.selenium.WebDriver;

public class NewsFeedFlight extends FeedCommon {
    WebDriver driver;
    public NewsFeedFlight(WebDriver webDriver){
        driver = webDriver;
    }

    public String checkFlightTabSelected() {
        waitElementToVisible(driver, FlightTabPageUI.TITLE_PAGE);
        return getTextOfElement(driver, FlightTabPageUI.TITLE_PAGE);
    }
}
