package Newsfeed.HeaderMenu.UserSetting.PageObject;

import Newsfeed.HeaderMenu.HeaderMenu;
import Newsfeed.HeaderMenu.UserSetting.AccountSettingUI;
import org.openqa.selenium.WebDriver;

public class CommonAccountSetting extends HeaderMenu {
    public String getTitleTabSettingGeneral(WebDriver driver){
        waitElementToVisible(driver, AccountSettingUI.TITLE_OF_TAB,"setting_general");
        return getTextOfElement(driver,AccountSettingUI.TITLE_OF_TAB,"setting_general");
    };

    public String getTitleTabSecurityAndLogin(WebDriver driver){
        waitElementToVisible(driver, AccountSettingUI.TITLE_OF_TAB,"setting_security_and_login");
        return getTextOfElement(driver,AccountSettingUI.TITLE_OF_TAB,"setting_security_and_login");
    };

    public String getTitleTabLanguageAndRegion(WebDriver driver){
        waitElementToVisible(driver, AccountSettingUI.TITLE_OF_TAB,"setting_language");
        return getTextOfElement(driver,AccountSettingUI.TITLE_OF_TAB,"setting_language");
    };
    public String getTitleTabTimelineAndTagging(WebDriver driver){
        waitElementToVisible(driver, AccountSettingUI.TITLE_OF_TAB,"setting_timeline");
        return getTextOfElement(driver,AccountSettingUI.TITLE_OF_TAB,"setting_timeline");
    };

    public void clickToTabSettingGeneral(WebDriver driver){
        waitElementToClickAble(driver, AccountSettingUI.ACCOUNT_FUNCTION_TAB,"setting_general_nav");
        clickToElement(driver,AccountSettingUI.ACCOUNT_FUNCTION_TAB, "setting_general_nav");
    }

    public void clickToTabSecurityAndLogin(WebDriver driver){
        waitElementToClickAble(driver, AccountSettingUI.ACCOUNT_FUNCTION_TAB,"setting_security_and_login_nav'");
        clickToElement(driver,AccountSettingUI.ACCOUNT_FUNCTION_TAB, "setting_security_and_login_nav");
    }
    public void clickToTabLanguageAndRegion(WebDriver driver){
        waitElementToClickAble(driver, AccountSettingUI.ACCOUNT_FUNCTION_TAB,"setting_language_nav");
        clickToElement(driver,AccountSettingUI.ACCOUNT_FUNCTION_TAB, "setting_language_nav");
    }
    public void clickToTabTimelineAndTagging(WebDriver driver){
        waitElementToClickAble(driver, AccountSettingUI.ACCOUNT_FUNCTION_TAB,"setting_timeline_nav");
        clickToElement(driver,AccountSettingUI.ACCOUNT_FUNCTION_TAB, "setting_timeline_nav");
    }
}