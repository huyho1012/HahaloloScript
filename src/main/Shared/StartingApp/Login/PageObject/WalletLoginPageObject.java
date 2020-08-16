package StartingApp.Login.PageObject;

import HeaderMain.HeaderMenu;
import StartingApp.Login.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class WalletLoginPageObject extends HeaderMenu {
    WebDriver driver;
    public WalletLoginPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterDataToUsername(WebDriver driver, String userName) {
        waitElementToVisible(driver, LoginPageUI.USER_NAME);
        sendKeyToElement(driver,LoginPageUI.USER_NAME,userName);
    }

    public void enterDataToPassword(WebDriver driver, String passWord) {
        waitElementToVisible(driver, LoginPageUI.PASSWORD);
        sendKeyToElement(driver,LoginPageUI.PASSWORD, passWord);
    }

    public String getValidateErrorMessageOnUserName(WebDriver driver){
        waitElementToVisible(driver, LoginPageUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
        return getTextOfElement(driver, LoginPageUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
    }
    public String getValidateErrorMessageOnPassword(WebDriver driver){
        waitElementToVisible(driver, LoginPageUI.VALIDATE_PASS_WORD_ERROR_MESSAGE);
        return getTextOfElement(driver, LoginPageUI.VALIDATE_PASS_WORD_ERROR_MESSAGE);
    }


}
