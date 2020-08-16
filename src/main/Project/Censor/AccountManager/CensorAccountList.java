package Censor.AccountManager;

import Account.CensorAccountListUI;
import Censor.Dashboard.CensorHomeUI;
import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import StartingApp.Login.PageObject.CensorLoginPageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CensorAccountList extends AbstractPage {
    WebDriver driver;
    public CensorAccountList(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAccountManagerPageIsDisplay() {
        waitElementToVisible(driver, CensorAccountListUI.TITLE_ACCOUNT_MODERATOR);
        return checkIsDisplayedElement(driver, CensorAccountListUI.TITLE_ACCOUNT_MODERATOR);
    }

    public void searchAccount(WebDriver driver, String accountName) {
        waitElementToVisible(driver, CensorAccountListUI.ACCOUNT_SEARCH_FIELD);
        sendKeyToElement(driver, CensorAccountListUI.ACCOUNT_SEARCH_FIELD,accountName);
        sendKeyboardToElement(driver,CensorAccountListUI.ACCOUNT_SEARCH_FIELD, Keys.ENTER);
    }

    public void clickToBlockAccount(WebDriver driver, String accountName,String statusAccount, String password) {
        waitElementToVisible(driver,CensorAccountListUI.BLOCKED_STATUS,accountName,statusAccount);
        clickToElement(driver,CensorAccountListUI.BLOCKED_STATUS,accountName,statusAccount);
        waitElementToVisible(driver,CensorAccountListUI.TITLE_CONFIRM_PASS_POPUP);
        sendKeyToElement(driver,CensorAccountListUI.CONFIRM_PASS_FIELD,password);
        clickToElement(driver,CensorAccountListUI.CONFIRM_BUTTON);
    }

    public boolean checkAccountIsBlockedSuccessfully(WebDriver driver,String emailUser, String statusAccount) {
        waitElementToVisible(driver, CensorAccountListUI.BLOCKED_STATUS, emailUser,statusAccount);
        return checkIsDisplayedElement(driver, CensorAccountListUI.BLOCKED_STATUS, emailUser,statusAccount);
    }

    public CensorLoginPageObject clickLogoutButton() {
        waitElementToClickAble(driver, CensorHomeUI.LOGOUT_ICON);
        clickToElement(driver, CensorHomeUI.LOGOUT_ICON);
        return PageGenerator.getCensorLoginPage(driver);
    }
}
