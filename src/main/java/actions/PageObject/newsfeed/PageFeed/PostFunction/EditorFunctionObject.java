package actions.PageObject.Newsfeed.PageFeed.PostFunction;

import actions.PageObject.Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import interfaces.Newsfeed.Editor.EditorUI;
import interfaces.Newsfeed.TabFeed.PostModelUI;
import org.openqa.selenium.WebDriver;

public class EditorFunctionObject extends AbstractPage {
    protected WebDriver driver;
    public void insertEmoji(WebDriver driver,int numEmoji) {
        clickToElement(driver,EditorUI.EMOJI_INSERT_FUNCTION);
        waitElementToVisible(driver,EditorUI.EMOJI_POP_UP);
        for(int i = 0; i< numEmoji; i++){
            clickToElement(driver,EditorUI.EMOJI_ITEM);
            setTimeDelay(1);
            break;
        }
    }
    public void chooseUserTagging(WebDriver driver,String friendName, String friendIndex) {
        clickToElement(driver,EditorUI.TAGGING_FUNCTION);
        setTimeDelay(1);
        sendKeyToElement(driver,EditorUI.SEARCH_USER_TAGGING,friendName);
        waitElementToVisible(driver,EditorUI.USER_TAGGING_LIST);
        clickToElementByJS(driver,EditorUI.USER_ITEM,friendIndex);
    }
    public void removeOneUserTagging(WebDriver driver, int friendIndex){
        if(checkIsDisplayedElement(driver, EditorUI.DISPLAYED_TAGGER_USER)){
            clickToElement(driver, EditorUI.DISPLAYED_TAGGER_USER);
            clickToElement(driver, EditorUI.ICON_REMOVE_TAGGER_USER,String.valueOf(friendIndex));
        }
    }

    public void chooseLocationAddress(WebDriver driver,String locationName) {
        clickToElement(driver,EditorUI.ADD_LOCATION_FUNCTION);
        setTimeDelay(1);
        sendKeyToElement(driver,EditorUI.SEARCH_LOCATION,locationName);
        clickToElement(driver,EditorUI.LOCATION_ITEM,locationName);
    }
    public void removeLocation(WebDriver driver, String locationName) {
        if(checkIsDisplayedElement(driver, EditorUI.DISPLAYED_LOCATION,locationName)){
            clickToElement(driver, EditorUI.DISPLAYED_LOCATION,locationName);
            clickToElement(driver, EditorUI.ICON_REMOVE_LOCATION,locationName);
        }
    }
    public void chooseImageToInsert(WebDriver driver, String...values){
        clickToElement(driver,EditorUI.ADD_IMAGE_FUNCTION);
        uploadMultipleFileByAutoIT(driver,values);
    }
    public void chooseFeeling(WebDriver driver,String feelingName) {
        clickToElement(driver,EditorUI.ADD_FELLING_FUNCTION);
        clickToElement(driver,EditorUI.FEELING_FUNCTION);
        clickToElement(driver,EditorUI.FEELING_ITEM,feelingName);
    }
    public void removeFeeling(WebDriver driver, String nameFeeling) {
        if(checkIsDisplayedElement(driver, EditorUI.DISPLAYED_FEELING,nameFeeling)){
            clickToElement(driver, EditorUI.DISPLAYED_FEELING,nameFeeling);
            clickToElement(driver, EditorUI.ICON_REMOVE_FELLING);
        }
    }
    public void choosePostScope(String scopeName) {
        selectItemInCustomDropdown(driver,EditorUI.POST_SCOPE, EditorUI.SCOPE_ITEM,scopeName);
    }

    public void clickToCloseEditor(){
        waitElementToClickAble(driver, EditorUI.BUTTON_CLOSE_EDITOR);
        clickToElement(driver,EditorUI.BUTTON_CLOSE_EDITOR);
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
    public void openFunction(String postContent, String authorName, String functionPost){
        waitElementToVisible(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
        clickToElement(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
        waitElementToClickAble(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
        clickToElement(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
    }

    public void clickToSharePostButton( ) {
        waitElementToClickAble(driver,PostModelUI.CREATE_POST_BUTTON);
        clickToElement(driver,PostModelUI.CREATE_POST_BUTTON);
    }
}
