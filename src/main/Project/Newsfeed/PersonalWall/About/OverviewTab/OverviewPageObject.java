package Newsfeed.PersonalWall.About.OverviewTab;

import Newsfeed.PersonalWall.About.Common.PersonalAbout;
import org.openqa.selenium.WebDriver;

public class OverviewPageObject extends PersonalAbout {
    WebDriver driver;
    public OverviewPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public String getEmailOfUserOnWidgetIntro() {
        waitElementToVisible(driver, OverviewPageUI.EMAIL_USER_INFO);
        return  getTextOfElement(driver,OverviewPageUI.EMAIL_USER_INFO);
    }
}
