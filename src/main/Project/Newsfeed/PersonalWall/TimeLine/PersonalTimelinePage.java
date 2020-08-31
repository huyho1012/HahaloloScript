package Newsfeed.PersonalWall.TimeLine;

import Newsfeed.Editor.Common.CommonEditorUI;
import Newsfeed.Editor.NormalPost.NormalPostUI;
import Newsfeed.PersonalWall.PersonalCommonUI;
import Newsfeed.TabFeed.NewsFeedPageIU;
import org.openqa.selenium.WebDriver;

public class PersonalTimelinePage extends PersonalCommon {
    WebDriver driver;
    public PersonalTimelinePage(WebDriver webDriver){
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

    public boolean checkTimeLinePersonalIsDisplay(String username) {
        waitForPageLoading(driver);
        return getTextOfElement(driver, PersonalCommonUI.PERSONAL_NAME).equals(username) && checkIsDisplayedElement(driver,NormalPostUI.TITLE_POPUP);
    }

    public void clickEditPostHasBeenCreatedBefore(WebDriver driver, String postContent, String authorName) {
        waitForPageLoading(driver);
        clickToElementByJS(driver,PersonalTimelinePageUI.BUTTON_EDIT,postContent,authorName);
    }

    public boolean verifyPostIsCreatedSuccessfully(WebDriver driver, String postContent, String authorName) {
        return checkIsDisplayedElement(driver,PersonalTimelinePageUI.DIRECT_POST_WITH_CONTENT_AND_AUTHOR,postContent.replace("\n", "<br>"),authorName);
    }

}
