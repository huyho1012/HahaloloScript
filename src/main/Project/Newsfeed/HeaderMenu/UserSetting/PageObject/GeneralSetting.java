package Newsfeed.HeaderMenu.UserSetting.PageObject;

import Newsfeed.HeaderMenu.UserSetting.AccountSettingUI;
import org.openqa.selenium.WebDriver;

public class GeneralSetting extends CommonAccountSetting {

    WebDriver driver;
    public GeneralSetting(WebDriver webDriver){
        driver = webDriver;
    }

    // Function Thay đổi tên hiển thị của người dùng (FUll name)
    public String getFullNameIsDisplay() {
        waitElementToVisible(driver, AccountSettingUI.FULL_NAME_DATA);
        return getTextOfElement(driver,AccountSettingUI.FULL_NAME_DATA);
    }

    public void editFullNameFunction(WebDriver driver){
        waitElementToClickAble(driver, AccountSettingUI.EDIT_FULL_NAME_BUTTON);
        clickToElement(driver,AccountSettingUI.EDIT_FULL_NAME_BUTTON);
    }

    public void clearDataOfFieldOnFullNameFunction(WebDriver driver, String fieldName) {
        removeTextOnElement(driver, AccountSettingUI.DYNAMIC_FIELD_ON_FULL_NAME, fieldName);
    }
    public void inputDataOfFieldOnFullNameFunction(WebDriver driver, String fieldName, String value) {
        waitElementToVisible(driver, AccountSettingUI.DYNAMIC_FIELD_ON_FULL_NAME, fieldName);
        waitElementToVisible(driver, AccountSettingUI.DYNAMIC_FIELD_ON_FULL_NAME, ,value, fieldName);
    }

    public String getErrorValidateMesOfFieldOnFullName(WebDriver driver, String fieldName) {
        waitElementToVisible(driver,AccountSettingUI.ERROR_MESSAGE_OF_DYNAMIC_FIELD_ON_FULL_NAME,fieldName);
        return getTextOfElement(driver,AccountSettingUI.ERROR_MESSAGE_OF_DYNAMIC_FIELD_ON_FULL_NAME,fieldName);
    }

    public void clickSaveChangeFullName(WebDriver driver){
        waitElementToClickAble(driver,AccountSettingUI.SAVE_CHANGE_FULL_NAME);
        clickToElement(driver,AccountSettingUI.SAVE_CHANGE_FULL_NAME);
    }

    public boolean checkFormConfirmPasswordIsDisplay() {
        return checkIsDisplayedElement(driver,AccountSettingUI.CONFIRM_PASS_POPUP);
    }

    public void clickConfirmButton() {
        waitElementToClickAble(driver,AccountSettingUI.CONFIRM_PASS_BUTTON);
        clickToElement(driver,AccountSettingUI.CONFIRM_PASS_BUTTON);
    }



    // Function thay đổi định danh người dùng
    public String getUserIdentityNameDisplay(WebDriver driver){
        waitElementToVisible(driver,AccountSettingUI.FULL_NAME_DATA);
        return  getTextOfElement(driver,AccountSettingUI.FULL_NAME_DATA);
    }



    public void clickConfirmButtonOnPopup(WebDriver driver){
        waitElementToClickAble(driver,AccountSettingUI.CONFIRM_PASS_BUTTON);
        clickToElement(driver,AccountSettingUI.CONFIRM_PASS_BUTTON);
    }
    public String getMessageChangeFullName(WebDriver driver){
        waitElementToVisible(driver,AccountSettingUI.MESSAGE_CHANGE_FULL_NAME);
        return getTextOfElement(driver,AccountSettingUI.MESSAGE_CHANGE_FULL_NAME);
    }
    public String getErrorMessageOfFirstName(WebDriver driver){
        waitElementToVisible(driver,AccountSettingUI.ERROR_MESSAGE_OF_FIRSTNAME);
        return getTextOfElement(driver,AccountSettingUI.ERROR_MESSAGE_OF_FIRSTNAME);
    }
    public String getErrorMessageOfLastName(WebDriver driver){
        waitElementToVisible(driver,AccountSettingUI.ERROR_MESSAGE_OF_LASTNAME);
        return getTextOfElement(driver,AccountSettingUI.ERROR_MESSAGE_OF_LASTNAME);
    }

    public String getErrorMessageOfConfirmPass(WebDriver driver){
        waitElementToVisible(driver,AccountSettingUI.ERROR_MESSAGE_OF_CONFIRM_PASS);
        return getTextOfElement(driver,AccountSettingUI.ERROR_MESSAGE_OF_CONFIRM_PASS);
    }

    public void clickEditButton() {
    }



}
