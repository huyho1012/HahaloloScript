package Newsfeed.Editor.NormalPost;

import CommonHelper.Function.PageGenerator;
import Newsfeed.Editor.Common.CommonEditorUI;
import Newsfeed.Editor.Common.FunctionPageObject;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import org.openqa.selenium.WebDriver;

public class NormalPostEditor extends FunctionPageObject {
    WebDriver driver;
    public NormalPostEditor(WebDriver webDriver){
        driver= webDriver;
    }

    // Hàm get title của Normal Editor
    public String getTitleOfNormalPost(WebDriver driver){
        return getTextOfElement(driver, CommonEditorUI.NORMAL_POST);
    }

    // Hàm kiểm tra Khởi tạo hiển thị Normal Editor
    public boolean checkNewNormalPostEditorIsDisplay(WebDriver driver) {
        if(checkIsDisplayedElement(driver, CommonEditorUI.CREATE_BUTTON) && !checkStatusOfShareButton(driver)
                && checkIsDisplayedElement(driver, CommonEditorUI.SCOPE_POST_DROPDOWN) && checkIsDisplayedElement(driver, CommonEditorUI.TAGGING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_LOCATION_FUNCTION) && checkIsDisplayedElement(driver, CommonEditorUI.ADD_FELLING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION) && getTitleOfNormalPost(driver).contains("Tạo bài viết")
                && checkIsDisplayedElement(driver, CommonEditorUI.EMOJI_INSERT_FUNCTION))
            return true;
        return false;
    }

    // Hàm kiểm tra Khởi tạo hiển thị Normal Editor
    public boolean checkEditNormalPostEditorIsDisplay(WebDriver driver) {
        if(checkIsDisplayedElement(driver, CommonEditorUI.CREATE_BUTTON) && checkStatusOfShareButton(driver)
                && checkIsDisplayedElement(driver, CommonEditorUI.SCOPE_POST_DROPDOWN) && checkIsDisplayedElement(driver, CommonEditorUI.TAGGING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_LOCATION_FUNCTION) && checkIsDisplayedElement(driver, CommonEditorUI.ADD_FELLING_FUNCTION)
                && checkIsDisplayedElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION) && checkIsDisplayedElement(driver, CommonEditorUI.EMOJI_INSERT_FUNCTION)
                && getTitleOfNormalPost(driver).contains("Chỉnh sửa bài viết"))
            return true;
        return false;
    }

    // Kiểm tra trạng thái Enable/Disable của nút Share Post
    public boolean checkStatusOfShareButton(WebDriver driver) {
        return checkIsEnableElement(driver, CommonEditorUI.CREATE_BUTTON);
    }

    public void inputNormalPostContent(WebDriver driver, String contentPost) {
        waitElementToVisible(driver, CommonEditorUI.NORMAL_POST_CONTENT);
        sendKeyToElement(driver, CommonEditorUI.NORMAL_POST_CONTENT, contentPost);
    }

    // Hàm upload image
    public void uploadImageToNormalPost(WebDriver driver, String...values){
        clickToElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION);
        uploadMultipleFileByAutoIT(driver,values);
    }

    public void removeImage(WebDriver driver) {
        int numImage = countElements(driver, CommonEditorUI.LIST_IMAGE_ATTACHMENT);
        for(int i = numImage ; i > 0; i--){
            hoverMouseToElement(driver, CommonEditorUI.ITEM_IMAGE,String.valueOf(i));
            clickToElement(driver, CommonEditorUI.BUTTON_REMOVE_ITEM_IMAGE,String.valueOf(i));
        }
    }

    // Hàm get placeholer
    public String getPlaceHolderPostNormal() {
        return getAttributeOfElement(driver, CommonEditorUI.NORMAL_POST_CONTENT,"data-placeholder");
    }

    public String getScopeDisplayOnDropdown(WebDriver driver){
        return getTextOfElement(driver, CommonEditorUI.DEFAULT_SCOPE);
    }

    public NewsFeedTabPageObject clickClosePostEditor() {
        clickToElement(driver, CommonEditorUI.BUTTON_CLOSE_EDITOR);
        return PageGenerator.getNewsFeedPage(driver);
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
}
