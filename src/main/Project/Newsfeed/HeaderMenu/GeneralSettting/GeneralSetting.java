package Newsfeed.HeaderMenu.GeneralSettting;

import Newsfeed.HeaderMenu.UserSetting.PageObject.CommonAccountSetting;
import org.openqa.selenium.WebDriver;

public class GeneralSetting extends CommonAccountSetting {

    WebDriver driver;
    public GeneralSetting(WebDriver webDriver){
        driver = webDriver;
    }

    public String getTitleOfSettingGeneral(){
        return getTextOfElement(driver, GeneralSettingUI.TITLE_OF_TAB,"setting_general");
    }

    // Update full name function

    public String getFullNameIsDisplay() {
        waitElementToVisible(driver, GeneralSettingUI.FULL_NAME_DATA);
        return getTextOfElement(driver, GeneralSettingUI.FULL_NAME_DATA);
    }

    public void clickIconEditFullName(WebDriver driver){
        waitElementToClickAble(driver, GeneralSettingUI.EDIT_FULL_NAME_BUTTON);
        clickToElement(driver, GeneralSettingUI.EDIT_FULL_NAME_BUTTON);
    }

    public void removeValueOnFieldOnFullName(WebDriver driver, String fieldName) {
        removeTextOnElement(driver, GeneralSettingUI.DYNAMIC_FIELD_ON_FULL_NAME, fieldName);
    }
    public void inputValueToFieldOnFullName(WebDriver driver, String fieldName, String value) {
        waitElementToVisible(driver, GeneralSettingUI.DYNAMIC_FIELD_ON_FULL_NAME, fieldName);
        waitElementToVisible(driver, GeneralSettingUI.DYNAMIC_FIELD_ON_FULL_NAME, value, fieldName);
    }

    public String getErrMesFieldOnFullName(WebDriver driver, String fieldName) {
        waitElementToVisible(driver, GeneralSettingUI.ERROR_MESSAGE_OF_DYNAMIC_FIELD_ON_FULL_NAME,fieldName);
        return getTextOfElement(driver, GeneralSettingUI.ERROR_MESSAGE_OF_DYNAMIC_FIELD_ON_FULL_NAME,fieldName);
    }

    public void clickToButtonSaveChangeOfFullName(WebDriver driver){
        waitElementToClickAble(driver, GeneralSettingUI.SAVE_CHANGE_FULL_NAME);
        clickToElement(driver, GeneralSettingUI.SAVE_CHANGE_FULL_NAME);
    }

    public boolean checkConfirmPasswordPopupIsDisplay() {
        return checkIsDisplayedElement(driver, GeneralSettingUI.CONFIRM_PASS_POPUP);
    }

    public void clickToConfirmButtonOnPopup() {
        waitElementToClickAble(driver, GeneralSettingUI.CONFIRM_PASS_BUTTON);
        clickToElement(driver, GeneralSettingUI.CONFIRM_PASS_BUTTON);
    }


    // Function thay đổi định danh người dùng
    public String getUserIdentityNameDisplay(WebDriver driver){
        waitElementToVisible(driver, GeneralSettingUI.FULL_NAME_DATA);
        return getTextOfElement(driver, GeneralSettingUI.FULL_NAME_DATA);
    }

    public void clickToIconEditUserName() {
        waitElementToClickAble(driver, GeneralSettingUI.EDIT_USERNAME_ICON);
        clickToElement(driver, GeneralSettingUI.EDIT_USERNAME_ICON);
    }

    public void clearDataOfFieldOnUserName() {
        removeTextOnElement(driver, GeneralSettingUI.USERNAME_FIELD);
    }

    public void inputValueToFieldOnUserName(String userName) {
        waitElementToVisible(driver, GeneralSettingUI.USERNAME_FIELD);
        sendKeyToElement(driver, GeneralSettingUI.USERNAME_FIELD, userName);
    }

    public void clickToButtonSaveChangeUserName() {
        waitElementToClickAble(driver, GeneralSettingUI.BUTTON_SAVE_USERNAME);
        clickToElement(driver, GeneralSettingUI.BUTTON_SAVE_USERNAME);
    }

    public String getErrMessOnUsername() {
        waitElementToVisible(driver, GeneralSettingUI.MESSAGE_VALIDATE_USERNAME);
        return getTextOfElement(driver, GeneralSettingUI.MESSAGE_VALIDATE_USERNAME);
    }


    public boolean checkIconSuccessIsDisplay() {
       return checkIsDisplayedElement(driver, GeneralSettingUI.ICON_SUCCESS_MESSAGE_OF_USERNAME);
    }
    public boolean checkIconErrorIsDisplay() {
        return checkIsDisplayedElement(driver, GeneralSettingUI.ICON_ERROR_MESSAGE_OF_USERNAME);
    }

    public boolean checkStatusSaveChangeUserNameButton() {
        return checkIsDisplayedElement(driver, GeneralSettingUI.BUTTON_SAVE_USERNAME);
    }


    public Object checkUserNameIsDisplay() {
        return null;
    }

    public boolean checkGeneralAccountSettingTabIsDisplay(WebDriver driver, String fullName) {
        waitElementToVisible(driver,GeneralSettingUI.FULL_NAME_DATA);
        return getTitlePage(driver).contains("Cài đặt tài khoản | Hahalolo") && getTextOfElement(driver,GeneralSettingUI.FULL_NAME_DATA).contains(fullName) && checkIsDisplayedElement(driver, GeneralSettingUI.TITLE_OF_TAB,"setting_general");
    }
}
