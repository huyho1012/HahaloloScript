package Newsfeed.Editor.Common;

import CommonHelper.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Function extends AbstractPage {
    protected WebDriver driver;

    // Hàm chèn emoji
    public void insertEmoji(WebDriver driver,int numEmoji) {
        clickToElement(driver, CommonEditorUI.EMOJI_INSERT_FUNCTION);
        waitElementToVisible(driver, CommonEditorUI.EMOJI_POP_UP);
        for(int i = 0; i< numEmoji; i++){
            clickToElement(driver, CommonEditorUI.EMOJI_ITEM);
        }
    }
    // Hàm tagging user
    public void chooseUserTagging(WebDriver driver, String friendName, int index) {
        clickToElement(driver, CommonEditorUI.TAGGING_FUNCTION);
        sendKeyToElement(driver, CommonEditorUI.SEARCH_USER_TAGGING, friendName);
        waitElementToVisible(driver, CommonEditorUI.USER_TAGGING_LIST);
        clickToElementByJS(driver, CommonEditorUI.USER_ITEM, String.valueOf(index));
    }
    // Hàm remove user
    public void removeOneUserTagging(WebDriver driver, int friendIndex){
        if(checkIsDisplayedElement(driver, CommonEditorUI.DISPLAYED_TAGGER_USER)){
            clickToElement(driver, CommonEditorUI.DISPLAYED_TAGGER_USER);
            clickToElement(driver, CommonEditorUI.ICON_REMOVE_TAGGER_USER,String.valueOf(friendIndex));
        }
    }
    // Hàm add Location
    public void chooseLocationAddress(WebDriver driver,String locationName) {
        clickToElement(driver, CommonEditorUI.ADD_LOCATION_FUNCTION);
        setTimeDelay(1);
        sendKeyToElement(driver, CommonEditorUI.SEARCH_LOCATION,locationName);
        clickToElement(driver, CommonEditorUI.LOCATION_ITEM,locationName);
    }
    // Hàm remove Location
    public void removeLocation(WebDriver driver, String locationName) {
        if(checkIsDisplayedElement(driver, CommonEditorUI.DISPLAYED_LOCATION,locationName)){
            clickToElement(driver, CommonEditorUI.DISPLAYED_LOCATION,locationName);
            clickToElement(driver, CommonEditorUI.ICON_REMOVE_LOCATION,locationName);
        }
    }

    public void chooseFeeling(WebDriver driver,String feelingName) {
        clickToElement(driver, CommonEditorUI.ADD_FELLING_FUNCTION);
        clickToElement(driver, CommonEditorUI.FEELING_FUNCTION);
        clickToElement(driver, CommonEditorUI.FEELING_ITEM,feelingName);
    }
    public void removeFeeling(WebDriver driver, String nameFeeling) {
        if(checkIsDisplayedElement(driver, CommonEditorUI.DISPLAYED_FEELING,nameFeeling)){
            clickToElement(driver, CommonEditorUI.DISPLAYED_FEELING,nameFeeling);
            clickToElement(driver, CommonEditorUI.ICON_REMOVE_FELLING);
        }
    }
    public void choosePostScope(String scopeName) {
        selectItemInCustomDropdown(driver, CommonEditorUI.SCOPE_POST_DROPDOWN, CommonEditorUI.SCOPE_POST_ITEM, scopeName);
    }

    public void clickToCloseEditor(){
        waitElementToClickAble(driver, CommonEditorUI.BUTTON_CLOSE_EDITOR);
        clickToElement(driver, CommonEditorUI.BUTTON_CLOSE_EDITOR);
    }

    public void clickBackOnPopupConfirmCloseOPost(){
        waitElementToClickAble(driver, CommonEditorUI.BACK_TO_EDITOR);
        clickToElement(driver, CommonEditorUI.BACK_TO_EDITOR);
    }
    public void clickClosePopupConfirmClosePost(){
        waitElementToClickAble(driver, CommonEditorUI.CANCEL_CLOSE_EDITOR);
        clickToElement(driver, CommonEditorUI.CANCEL_CLOSE_EDITOR);
    }
    public void clickConfirmClosePost(){
        waitElementToClickAble(driver, CommonEditorUI.CONFIRM_CLOSE_EDITOR);
        clickToElement(driver, CommonEditorUI.CONFIRM_CLOSE_EDITOR);
    }

    public String getContentPopupConfirmCloseEditor(){
        waitElementToPresence(driver, CommonEditorUI.CONTENT_MODEL_CONFIRM_CLOSE_POST);
        return  getTextOfElement(driver, CommonEditorUI.CONTENT_MODEL_CONFIRM_CLOSE_POST);
    }
//
//    public void chooseFunctionIcon(String functionName) {
//        waitElementToClickAble(driver, PostModelUI.ITEM_FUNCTION_ON_POST, functionName);
//        clickToElement(driver, PostModelUI.ITEM_FUNCTION_ON_POST, functionName);
//    }
//
//
//    public String getTitlePopupConfirmCloseEditor(){
//        waitElementToPresence(driver, EditorUI.TITLE_MODEL_CONFIRM_CLOSE_POST);
//        return  getTextOfElement(driver,EditorUI.TITLE_MODEL_CONFIRM_CLOSE_POST);
//    }
//
//    // Hàm chỉnh sửa
//    public void openFunction(String postContent, String authorName, String functionPost){
//        waitElementToVisible(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
//        clickToElement(driver,PostModelUI.FUNCTION_DROPDOWN_POST,postContent,authorName);
//        waitElementToClickAble(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
//        clickToElement(driver,PostModelUI.ITEM_FUNCTION_ON_POST,postContent,authorName,functionPost);
//    }
//
//    public void clickToSharePostButton(WebDriver driver ) {
//        waitElementToClickAble(driver,PostModelUI.CREATE_POST_BUTTON);
//        clickToElement(driver,PostModelUI.CREATE_POST_BUTTON);
//    }


    public boolean checkConfirmCancelEditorPopUpDisplay(WebDriver driver) {
        waitElementToVisible(driver, CommonEditorUI.CONTENT_MODEL_CONFIRM_CLOSE_POST);
        return checkIsDisplayedElement(driver, CommonEditorUI.CONTENT_MODEL_CONFIRM_CLOSE_POST);
    }

    public void clickButtonOk(WebDriver driver) {
        waitElementToVisible(driver, CommonEditorUI.BUTTON_OK);
        clickToElement(driver, CommonEditorUI.BUTTON_OK);
    }

    public void clickToCreatePost() {
        waitElementToVisible(driver, CommonEditorUI.CREATE_BUTTON);
        clickToElement(driver, CommonEditorUI.CREATE_BUTTON);
    }
}
