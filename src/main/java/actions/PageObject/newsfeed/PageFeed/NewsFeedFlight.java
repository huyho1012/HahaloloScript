package actions.PageObject.newsfeed.PageFeed;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import interfaces.Newsfeed.PageFeed.FlightTabPageUI;
import org.openqa.selenium.WebDriver;

public class NewsFeedFlight extends HeaderMenu {
    WebDriver driver;
    public NewsFeedFlight(WebDriver webDriver){
        driver = webDriver;
    }

    public String checkFlightTabSelected() {
        waitElementToVisible(driver, FlightTabPageUI.TITLE_PAGE);
        return getTextOfElement(driver, FlightTabPageUI.TITLE_PAGE);
    }
}
