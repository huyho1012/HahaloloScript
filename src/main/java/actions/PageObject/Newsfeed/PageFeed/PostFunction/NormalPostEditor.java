package actions.PageObject.Newsfeed.PageFeed.PostFunction;

import actions.PageObject.Newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import actions.common.Function.PageGenerator;
import interfaces.Newsfeed.Editor.EditorUI;
import interfaces.Newsfeed.TabFeed.PostModelUI;
import org.openqa.selenium.WebDriver;

public class NormalPostEditor extends EditorFunctionObject {
    WebDriver driver;
    public NormalPostEditor(WebDriver webDriver){
        driver= webDriver;
    }

    public boolean checkEditPostModalIsDisplay(WebDriver driver) {
        waitElementToVisible(driver, PostModelUI.CREATE_POST_BUTTON);
        return checkIsDisplayedElement(driver,PostModelUI.TITLE_EDIT_NORMAL_POST);
    }

    public boolean checkCreatePostModalIsDisplay(WebDriver driver) {
        waitElementToVisible(driver,PostModelUI.SCOPE_POST_DROPDOWN);
        return checkIsDisplayedElement(driver,PostModelUI.SCOPE_POST_DROPDOWN);
    }

    public void inputPostNormalContent(WebDriver driver,String contentPost) {
        waitElementToVisible(driver, EditorUI.NORMAL_POST_CONTENT);
        sendKeyToElement(driver,EditorUI.NORMAL_POST_CONTENT, contentPost);
    }

    public boolean checkTitleEditNormalPostIsDisplay(WebDriver driver){
        waitElementToVisible(driver, PostModelUI.TITLE_EDIT_NORMAL_POST);
        return checkIsDisplayedElement(driver,PostModelUI.TITLE_EDIT_NORMAL_POST);
    }

    public void removeContentPostNormal(WebDriver driver) {
        removeTextOnElement(driver,EditorUI.NORMAL_POST_CONTENT);
    }

    public boolean checkConfirmDeletePostPopup(WebDriver driver) {
        waitElementToVisible(driver,PostModelUI.CONFIRM_REMOVE_POST_POPUP);
        return checkIsDisplayedElement(driver,PostModelUI.CONFIRM_REMOVE_POST_POPUP);
    }

    public PersonalTimelinePageObject clickDeleteButton(WebDriver webDriver) {
        acceptAlert(driver);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }

    public boolean checkStatusOfShareButton(WebDriver driver) {
        return checkIsEnableElement(driver, EditorUI.CREATE_BUTTON);
    }

    public void removeImage(WebDriver driver) {
        int numImage = countElements(driver,EditorUI.LIST_IMAGE_ATTACHMENT);
        for(int i = numImage ; i > 0; i--){
            hoverMouseToElement(driver,EditorUI.ITEM_IMAGE,String.valueOf(i));
            clickToElement(driver,EditorUI.BUTTON_REMOVE_ITEM_IMAGE,String.valueOf(i));
        }
    }


    public String getPlaceHolderPostNormal() {
        return getAttributeOfElement(driver,EditorUI.NORMAL_POST_CONTENT,"data-placeholder");
    }
    public String getTitleOfNormalPost(WebDriver driver){
        return getTextOfElement(driver, EditorUI.NORMAL_POST);
    }
    public String getScopeDisplayOnDropdown(WebDriver driver){
        return getTextOfElement(driver,EditorUI.DEFAULT_SCOPE);
    }

    public NewsFeedHomepage clickClosePostEditor() {
        clickToElement(driver, EditorUI.BUTTON_CLOSE_EDITOR);
        return PageGenerator.getNewsFeedPage(driver);
    }

    public boolean checkFunctionInsertEmojiIsDisplay() {
        return checkIsDisplayedElement(driver,EditorUI.EMOJI_INSERT_FUNCTION);
    }
    public boolean checkFunctionTaggingUserIsDisplay() {
        return checkIsDisplayedElement(driver,EditorUI.TAGGING_FUNCTION);
    }
    public boolean checkFunctionAddLocationIsDisplay() {
        return checkIsDisplayedElement(driver,EditorUI.ADD_LOCATION_FUNCTION);
    }
    public boolean checkFunctionAddImageIsDisplay() {
        return checkIsDisplayedElement(driver,EditorUI.ADD_IMAGE_FUNCTION);
    }
    public boolean checkFunctionAddFeelingIsDisplay() {
        return checkIsDisplayedElement(driver,EditorUI.ADD_FELLING_FUNCTION);
    }

    public void clickOVerPopup(WebDriver driver) {
        moveByOffset(driver);
    }
}
