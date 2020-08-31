package Newsfeed.PersonalWall.About.OverviewTab;

import Newsfeed.PersonalWall.About.Common.PersonalAbout;
import org.openqa.selenium.WebDriver;

public class OverviewPageObject extends PersonalAbout {
    WebDriver driver;
    public OverviewPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public String getUserEmailDisplayOnIntroduceWidget() {
        waitElementToVisible(driver, OverviewPageUI.EMAIL_USER_INFO);
        return  getTextOfElement(driver,OverviewPageUI.EMAIL_USER_INFO);
    }
    public String getUserBirthdayDisplayOnIntroduceWidget() {
        waitElementToVisible(driver, OverviewPageUI.BIRTHDAY_USER_INFO);
        return  getTextOfElement(driver,OverviewPageUI.BIRTHDAY_USER_INFO);
    }
    public String getUserGenderDisplayOnIntroduceWidget() {
        waitElementToVisible(driver, OverviewPageUI.GENDER_USER_INFO);
        return  getTextOfElement(driver,OverviewPageUI.GENDER_USER_INFO);
    }
}
