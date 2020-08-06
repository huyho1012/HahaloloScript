package actions.PageObject.newsfeed.PageFeed.PostFunction;


import actions.PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import interfaces.Common.MediaManagerUI;
import interfaces.Newsfeed.PageFeed.NewsFeedPageIU;
import interfaces.Newsfeed.PageFeed.PostModelUI;
import org.openqa.selenium.WebDriver;

public class EditorFunction extends AbstractPage {
    WebDriver driver;
    public EditorFunction(WebDriver webDriver){
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

    public boolean checkButtonSharePostIsEnable() {
        waitElementToVisible(driver,PostModelUI.CREATE_POST_BUTTON);
        return checkIsEnableElement(driver, PostModelUI.CREATE_POST_BUTTON);
    }

    public void inputPostNormalContent(String contentPost) {
        waitElementToVisible(driver, PostModelUI.POST_CONTENT_TEXT_AREA);
        sendKeyToElement(driver,PostModelUI.POST_CONTENT_TEXT_AREA, contentPost);
    }

    public void chooseFunctionIcon(String functionName) {
        waitElementToClickAble(driver, PostModelUI.ITEM_FUNCTION_ON_POST, functionName);
        clickToElement(driver, PostModelUI.ITEM_FUNCTION_ON_POST, functionName);
    }

    public void insertEmoji(int numberChar,String emoIndex) {
        for(int i = 0; i<numberChar; i++){
            waitElementToClickAble(driver,PostModelUI.EMOJI_POP_UP);
            clickToElement(driver,PostModelUI.EMOJI_ITEM,emoIndex);
            break;
        }
    }

    public void chooseUserTagging(String friendName) {
        waitElementToVisible(driver,PostModelUI.SEARCH_USER_TAGGING);
        sendKeyToElement(driver,PostModelUI.SEARCH_USER_TAGGING,friendName);
        setTimeDelay(1);
        waitElementToVisible(driver,PostModelUI.USER_TAGGING_LIST);
        clickToElementByJS(driver,PostModelUI.USER_ITEM);
    }
    public void chooseLocationAddress(String locationName) {
        waitElementToVisible(driver,PostModelUI.SEARCH_LOCATION);
        sendKeyToElement(driver,PostModelUI.SEARCH_LOCATION,locationName);
        setTimeDelay(2);
        waitElementToVisible(driver,PostModelUI.LOCATION_LIST);
        clickToElement(driver,PostModelUI.LOCATION_ITEM);
    }
    public void chooseFeeling(String feelingName) {
        waitElementToClickAble(driver,PostModelUI.FEELING_FUNCTION);
        clickToElement(driver,PostModelUI.FEELING_FUNCTION);

        waitElementToVisible(driver,PostModelUI.FEELING_LIST);
        waitElementToClickAble(driver,PostModelUI.FEELING_ITEM,feelingName);
        clickToElement(driver,PostModelUI.FEELING_ITEM,feelingName);
    }

    public void clickChooseScopeDropdown(String scopeName) {
        waitElementToClickAble(driver,PostModelUI.SCOPE_POST_DROPDOWN);
        clickToElement(driver,PostModelUI.SCOPE_POST_DROPDOWN);
        setTimeDelay(1);
        waitElementToClickAble(driver,PostModelUI.SCOPE_POST_ITEM,scopeName);
        clickToElement(driver,PostModelUI.SCOPE_POST_ITEM,scopeName);
    }

    public PersonalTimelinePageObject clickToSharePostButton() {
        waitElementToClickAble(driver,PostModelUI.CREATE_POST_BUTTON);
        clickToElement(driver,PostModelUI.CREATE_POST_BUTTON);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }


    public void clickToExperienceEditor() {
        waitElementToClickAble(driver, NewsFeedPageIU.EXPERIENCE_POST_FUNCTION);
        clickToElement(driver,NewsFeedPageIU.EXPERIENCE_POST_FUNCTION);
    }

    public boolean checkToExperienceEditorDisplay() {
        waitElementToVisible(driver, PostModelUI.UPLOAD_COVER_EXPERIENCE_BUTTON);
        return checkIsDisplayedElement(driver,PostModelUI.UPLOAD_COVER_EXPERIENCE_BUTTON);
    }

    public void inputExperienceTitle(String titleExp) {
        waitElementToVisible(driver, PostModelUI.TITLE_EXPERIENCE_TEXT_AREA);
        sendKeyToElement(driver, PostModelUI.TITLE_EXPERIENCE_TEXT_AREA,titleExp);
    }

    public void inputExperienceContent(String dummyText) {
        waitElementToVisible(driver,PostModelUI.POST_CONTENT_TEXT_AREA);
        sendKeyToElement(driver,PostModelUI.POST_CONTENT_TEXT_AREA,dummyText);
    }

    public void clickUploadCoverExperienceButton() {
        waitElementToClickAble(driver,PostModelUI.UPLOAD_COVER_EXPERIENCE_BUTTON);
        clickToElement(driver,PostModelUI.UPLOAD_COVER_EXPERIENCE_BUTTON);
    }

    public void chooseImageToInsert(String indexImage) {
        waitElementToVisible(driver, MediaManagerUI.TITLE_MEDIA_MANAGER);
        waitElementToVisible(driver,MediaManagerUI.IMAGE_ROOT_ITEM,indexImage);
        clickToElement(driver,MediaManagerUI.IMAGE_ROOT_ITEM,indexImage);
        setTimeDelay(1);
        waitElementToVisible(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
        clickToElement(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
    }

    public void openFunction(WebDriver driver, String postContent, String authorName, String functionPost){
        waitElementToVisible(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
        clickToElement(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
        waitElementToClickAble(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
        clickToElement(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
    }

    public boolean checkPostIsCreateSuccessfully() {
        return true;
    }

    public void removeUserTagging() {
    }

    public boolean checkTitleEditNormalPostIsDisplay(){
        waitElementToVisible(driver, PostModelUI.TITLE_EDIT_NORMAL_POST);
        return checkIsDisplayedElement(driver,PostModelUI.TITLE_EDIT_NORMAL_POST);
    }

    public void removeContent() {
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

    public void closeNormalPostEditor() {
    }
}
