package PostGenrate;

import HeaderMain.HeaderMenu;
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
