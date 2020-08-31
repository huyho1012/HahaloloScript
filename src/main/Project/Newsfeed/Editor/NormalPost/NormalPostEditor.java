package Newsfeed.Editor.NormalPost;

import Newsfeed.Editor.Common.CommonEditorUI;
import Newsfeed.Editor.Common.Function;
import org.openqa.selenium.WebDriver;

public class NormalPostEditor extends Function {
    WebDriver driver;
    public NormalPostEditor(WebDriver webDriver){
        driver= webDriver;
    }

    public String getTitleOfNormalPost(){
        waitElementToVisible(driver, NormalPostUI.TITLE_POPUP);
        return getTextOfElement(driver, NormalPostUI.TITLE_POPUP);
    }

    public boolean checkNewNormalPostEditorIsDisplay(WebDriver driver) {
        return checkIsDisplayedElement(driver, CommonEditorUI.CREATE_BUTTON) && !checkStatusOfShareButton(driver)
                && checkIsDisplayedElement(driver, CommonEditorUI.SCOPE_POST_DROPDOWN) && checkIsDisplayedElement(driver, CommonEditorUI.TAGGING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_LOCATION_FUNCTION) && checkIsDisplayedElement(driver, CommonEditorUI.ADD_FELLING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION) && getTitleOfNormalPost().contains("Tạo bài viết")
                && checkIsDisplayedElement(driver, CommonEditorUI.EMOJI_INSERT_FUNCTION);
    }

    public boolean checkEditNormalPostEditorIsDisplay(WebDriver driver) {
        return checkIsDisplayedElement(driver, CommonEditorUI.CREATE_BUTTON) && checkStatusOfShareButton(driver)
                && checkIsDisplayedElement(driver, CommonEditorUI.SCOPE_POST_DROPDOWN) && checkIsDisplayedElement(driver, CommonEditorUI.TAGGING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_LOCATION_FUNCTION) && checkIsDisplayedElement(driver, CommonEditorUI.ADD_FELLING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION) && checkIsDisplayedElement(driver, CommonEditorUI.EMOJI_INSERT_FUNCTION)
                && getTitleOfNormalPost().contains("Chỉnh sửa bài viết");
    }

    public void inputNormalPostContent(WebDriver driver,String content) {
        sendKeyToElement(driver, NormalPostUI.POST_CONTENT,content);
    }

    // Hàm upload image
    public void uploadImageToNormalPost(WebDriver driver, String...values){
        clickToElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION);
        uploadMultipleFileByAutoIT(driver,values);
    }

    public void removeImage(WebDriver driver) {
        int numImage = countElements(driver, NormalPostUI.LIST_IMAGE_ATTACHMENT);
        for(int i = numImage ; i > 0; i--){
            hoverMouseToElement(driver, NormalPostUI.ITEM_IMAGE,String.valueOf(i));
            clickToElement(driver, NormalPostUI.BUTTON_REMOVE_ITEM_IMAGE,String.valueOf(i));
        }
    }

    // Hàm get placeholder
    public String getPlaceHolderPostNormal() {
        return getAttributeOfElement(driver, NormalPostUI.POST_CONTENT,"data-placeholder");
    }

    public String getScopeDisplayOnDropdown(WebDriver driver){
        return getTextOfElement(driver, CommonEditorUI.DEFAULT_SCOPE);
    }

    public void clickClosePostEditor() {
        waitElementToClickAble(driver, CommonEditorUI.BUTTON_CLOSE_EDITOR);
        clickToElement(driver, CommonEditorUI.BUTTON_CLOSE_EDITOR);
    }

    public boolean checkFunctionInsertEmojiIsDisplay() {
        return checkIsDisplayedElement(driver, CommonEditorUI.EMOJI_INSERT_FUNCTION);
    }
    public boolean checkFunctionTaggingUserIsDisplay() {
        return checkIsDisplayedElement(driver, CommonEditorUI.TAGGING_FUNCTION);
    }
    public boolean checkFunctionAddLocationIsDisplay() {
        return checkIsDisplayedElement(driver, CommonEditorUI.ADD_LOCATION_FUNCTION);
    }
    public boolean checkFunctionAddImageIsDisplay() {
        return checkIsDisplayedElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION);
    }
    public boolean checkFunctionAddFeelingIsDisplay() {
        return checkIsDisplayedElement(driver, CommonEditorUI.ADD_FELLING_FUNCTION);
    }

    public void clickOVerPopup(WebDriver driver) {
        moveByOffset(driver);
    }

    public String getMessageErrLimitChar() {
        return getTextOfElement(driver, CommonEditorUI.MESSAGE_VALIDATION_POST_NORMAL);
    }

    public void clearNormalPostContent() {
        waitElementToVisible(driver, NormalPostUI.POST_CONTENT);
        removeTextOnElement(driver, NormalPostUI.POST_CONTENT);
    }

    public String getTextOfSharePostButton() {
        return getTextOfElement(driver,CommonEditorUI.CREATE_BUTTON);
    }

    public void clickToTargetTextArea() {
        clickToElement(driver,NormalPostUI.POST_CONTENT);
        setTimeDelay(1);
    }
}
