package actions.PageObject.Newsfeed.PageFeed.PostFunction;

import actions.PageObject.Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import interfaces.Common.MediaManagerUI;
import interfaces.Newsfeed.Editor.EditorUI;
import interfaces.Newsfeed.TabFeed.NewsFeedPageIU;
import interfaces.Newsfeed.TabFeed.PostModelUI;
import org.openqa.selenium.WebDriver;

public class NormalPostEditor extends AbstractPage {
    WebDriver driver;
    public NormalPostEditor(WebDriver webDriver){
        driver= webDriver;
    }

    public boolean checkEditPostModalIsDisplay() {
        waitElementToVisible(driver, PostModelUI.CREATE_POST_BUTTON);
        return checkIsDisplayedElement(driver,PostModelUI.TITLE_EDIT_NORMAL_POST);
    }

    public boolean checkCreatePostModalIsDisplay() {
        waitElementToVisible(driver,PostModelUI.SCOPE_POST_DROPDOWN);
        return checkIsDisplayedElement(driver,PostModelUI.SCOPE_POST_DROPDOWN);
    }


    public void inputPostNormalContent(String contentPost) {
        waitElementToVisible(driver, EditorUI.NORMAL_POST_CONTENT);
        sendKeyToElement(driver,EditorUI.NORMAL_POST_CONTENT, contentPost);
    }

    public boolean checkTitleEditNormalPostIsDisplay(){
        waitElementToVisible(driver, PostModelUI.TITLE_EDIT_NORMAL_POST);
        return checkIsDisplayedElement(driver,PostModelUI.TITLE_EDIT_NORMAL_POST);
    }

    public void removeContentPostNormal() {
        waitElementToVisible(driver, PostModelUI.POST_CONTENT_TEXT_AREA);
        removeTextOnElement(driver,PostModelUI.POST_CONTENT_TEXT_AREA);
    }

    public boolean checkConfirmDeletePostPopup() {
        waitElementToVisible(driver,PostModelUI.CONFIRM_REMOVE_POST_POPUP);
        return checkIsDisplayedElement(driver,PostModelUI.CONFIRM_REMOVE_POST_POPUP);
    }

    public PersonalTimelinePageObject clickDeleteButton() {
        acceptAlert(driver);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }



}
