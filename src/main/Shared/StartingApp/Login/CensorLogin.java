package Login;

import Common.GlobalVariables;
import Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CensorLogin extends AbstractPage {
    WebDriver driver;
    public CensorLogin(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsername(String userName, String valueField) {
        waitElementToVisible(driver, CensorLoginUI.USER_NAME);
        sendKeyToElement(driver, CensorLoginUI.USER_NAME, GlobalVariables.BACKEND_USER_NAME);
    }
    public void enterPassword(String passWord) {
        waitElementToVisible(driver, CensorLoginUI.PASSWORD);
        sendKeyToElement(driver, CensorLoginUI.PASSWORD, GlobalVariables.BACKEND_PASSWORD);
    }

    public CensorHomePage clickLoginButton() {
        waitElementToClickAble(driver, CensorLoginUI.LOGIN_BUTTON);
        clickToElement(driver, CensorLoginUI.LOGIN_BUTTON);
    }

    public boolean checkLogoutSuccess() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, CensorLoginUI.LOGIN_BUTTON);
        return checkAreElementsIsDisplay(driver, CensorLoginUI.LOGIN_BUTTON);
    }
}
