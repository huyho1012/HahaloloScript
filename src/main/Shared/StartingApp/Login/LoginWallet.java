package StartingApp.Login;

import Newsfeed.HeaderMenu.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class LoginWallet extends HeaderMenu {
    WebDriver driver;
    public LoginWallet(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterDataToUsername(WebDriver driver, String userName) {
        waitElementToVisible(driver, CommonLoginUI.USER_NAME);
        sendKeyToElement(driver, CommonLoginUI.USER_NAME,userName);
    }

    public void enterDataToPassword(WebDriver driver, String passWord) {
        waitElementToVisible(driver, CommonLoginUI.PASSWORD);
        sendKeyToElement(driver, CommonLoginUI.PASSWORD, passWord);
    }

    public String getValidateErrorMessageOnUserName(WebDriver driver){
        waitElementToVisible(driver, CommonLoginUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
        return getTextOfElement(driver, CommonLoginUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
    }
    public String getValidateErrorMessageOnPassword(WebDriver driver){
        waitElementToVisible(driver, CommonLoginUI.VALIDATE_PASS_WORD_ERROR_MESSAGE);
        return getTextOfElement(driver, CommonLoginUI.VALIDATE_PASS_WORD_ERROR_MESSAGE);
    }


}
