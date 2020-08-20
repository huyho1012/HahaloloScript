package Newsfeed.HeaderMenu.UserSetting.PageObject;

import Newsfeed.HeaderMenu.UserSetting.AccountSettingUI;
import org.openqa.selenium.WebDriver;

public class GeneralSetting extends CommonAccountSetting {

    WebDriver driver;
    public GeneralSetting(WebDriver webDriver){
        driver = webDriver;
    }

    // Tab Overview
    public String getFullNameIsDisplay() {
        waitElementToVisible(driver, AccountSettingUI.FULL_NAME_DATA);
        return getTextOfElement(driver,AccountSettingUI.FULL_NAME_DATA);
    }
    public String getUserIdentityNameDisplay(WebDriver driver){
        waitElementToVisible(driver,AccountSettingUI.FULL_NAME_DATA);
        return  getTextOfElement(driver,AccountSettingUI.FULL_NAME_DATA);
    }

    public void inputFirstName(WebDriver driver, String firstName){
        waitElementToVisible(driver, AccountSettingUI.FIRSTNAME);
        sendKeyToElement(driver, AccountSettingUI.FIRSTNAME, firstName);
    }
    public void inputLastName(WebDriver driver, String lastName){
        waitElementToVisible(driver, AccountSettingUI.LASTNAME);
        sendKeyToElement(driver, AccountSettingUI.LASTNAME, lastName);
    }
    public void inputMiddleName(WebDriver driver, String middleName){
        waitElementToVisible(driver, AccountSettingUI.MIDDLENAME);
        sendKeyToElement(driver, AccountSettingUI.MIDDLENAME, middleName);
    }

    public void inputConfirmPass(WebDriver driver, String confirmPass){
        waitElementToVisible(driver, AccountSettingUI.CONFIRM_PASS);
        sendKeyToElement(driver,AccountSettingUI.CONFIRM_PASS,confirmPass);
    }

    public void clickSaveChangeFullName(WebDriver driver){
        waitElementToClickAble(driver,AccountSettingUI.SAVE_CHANGE_FULL_NAME);
        clickToElement(driver,AccountSettingUI.SAVE_CHANGE_FULL_NAME);
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
}
