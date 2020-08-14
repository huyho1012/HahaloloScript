package actions.PageObject.Newsfeed.PageFeed.PostFunction;

import actions.PageObject.Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import interfaces.EditorDemo.EditorDemoUI;
import interfaces.Newsfeed.Editor.EditorUI;
import interfaces.Newsfeed.TabFeed.PostModelUI;
import org.openqa.selenium.WebDriver;

public class EditorPostPageObject extends AbstractPage {
    WebDriver driver;
    public void insertEmoji(int numberChar,String emoIndex) {
        for(int i = 0; i<numberChar; i++){
            waitElementToClickAble(driver,PostModelUI.EMOJI_POP_UP);
            clickToElement(driver,PostModelUI.EMOJI_ITEM,emoIndex);
            break;
        }
    }

    public void chooseUserTagging(String friendName) {
        waitElementToVisible(driver, PostModelUI.SEARCH_USER_TAGGING);
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

    public void chooseImage(){
    }

    public void chooseFeeling(String feelingName) {
        waitElementToClickAble(driver,PostModelUI.FEELING_FUNCTION);
        clickToElement(driver,PostModelUI.FEELING_FUNCTION);

        waitElementToVisible(driver,PostModelUI.FEELING_LIST);
        waitElementToClickAble(driver,PostModelUI.FEELING_ITEM,feelingName);
        clickToElement(driver,PostModelUI.FEELING_ITEM,feelingName);
    }

    public void choosePostScope(String scopeName) {
        selectItemInCustomDropdown(driver,EditorUI.POST_SCOPE, EditorUI.SCOPE_ITEM,scopeName);
    }

    public void clickToCloseEditor(){
        waitElementToClickAble(driver, EditorUI.CLOSE_MODEL_BUTTON);
        clickToElement(driver,EditorUI.CLOSE_MODEL_BUTTON);
    }

    public void clickBackOnPopupConfirmCloseOPost(){
        waitElementToClickAble(driver,EditorUI.BACK_TO_EDITOR);
        clickToElement(driver,EditorUI.BACK_TO_EDITOR);
    }
    public void clickClosePopupConfirmClosePost(){
        waitElementToClickAble(driver,EditorUI.CANCEL_CLOSE_EDITOR);
        clickToElement(driver,EditorUI.CANCEL_CLOSE_EDITOR);
    }
    public void clickConfirmClosePost(){
        waitElementToClickAble(driver,EditorUI.CONFIRM_CLOSE_EDITOR);
        clickToElement(driver,EditorUI.CONFIRM_CLOSE_EDITOR);
    }

    public String getContentPopupConfirmCloseEditor(){
        waitElementToPresence(driver, EditorUI.CONTENT_MODEL_CONFIRM_CLOSE_POST);
        return  getTextOfElement(driver,EditorUI.CONTENT_MODEL_CONFIRM_CLOSE_POST);
    }

    public void chooseFunctionIcon(String functionName) {
        waitElementToClickAble(driver, PostModelUI.ITEM_FUNCTION_ON_POST, functionName);
        clickToElement(driver, PostModelUI.ITEM_FUNCTION_ON_POST, functionName);
    }


    public String getTitlePopupConfirmCloseEditor(){
        waitElementToPresence(driver, EditorUI.TITLE_MODEL_CONFIRM_CLOSE_POST);
        return  getTextOfElement(driver,EditorUI.TITLE_MODEL_CONFIRM_CLOSE_POST);
    }

    // Hàm chỉnh sửa
    public void openFunction(WebDriver driver, String postContent, String authorName, String functionPost){
        waitElementToVisible(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
        clickToElement(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
        waitElementToClickAble(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
        clickToElement(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
    }

    public PersonalTimelinePageObject clickToSharePostButton() {
        waitElementToClickAble(driver,PostModelUI.CREATE_POST_BUTTON);
        clickToElement(driver,PostModelUI.CREATE_POST_BUTTON);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }

    public boolean checkCssShareButton() {
        return false;
    }
}
