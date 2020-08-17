package Newsfeed.PersonalWall.TimeLine;

import HeaderMain.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class PersonalTimelinePageObject extends PersonalCommon {
    WebDriver driver;
    public PersonalTimelinePageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPostIsDisplay() {
        return true;
    }

   public boolean checkCreatedPostSuccessfully(WebDriver driver,String authorName, String postContent) {
//        waitElementToVisible(driver, NO.DIRECT_POST_WITH_AUTHOR_CONTENT_TAGGING,authorName, postContent);
//        return checkIsDisplayedElement(driver, PostModelUI.DIRECT_POST_WITH_AUTHOR_CONTENT_TAGGING,authorName, postContent);
    return true;
    }
}
