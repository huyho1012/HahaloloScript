package actions.PageObject.Censor;

import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import interfaces.Censor.CensorLoginUI;
import org.openqa.selenium.WebDriver;

public class CensorLogin extends AbstractPage {
    WebDriver driver;
    public CensorLogin(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsername(String userName) {
        waitElementToVisible(driver, CensorLoginUI.USER_NAME);
        sendKeyToElement(driver,CensorLoginUI.USER_NAME, GlobalVariables.BACKEND_USER_NAME);
    }
    public void enterPassword(String passWord) {
        waitElementToVisible(driver, CensorLoginUI.PASSWORD);
        sendKeyToElement(driver,CensorLoginUI.PASSWORD, GlobalVariables.BACKEND_PASSWORD);
    }

    public CensorHomePage clickLoginButton() {
        waitElementToClickAble(driver,CensorLoginUI.LOGIN_BUTTON);
        clickToElement(driver,CensorLoginUI.LOGIN_BUTTON);
        return PageGenerator.getCensorHomePage(driver);
    }

    public boolean checkLogoutSuccess() {
        waitForPageLoading(driver);
        waitElementToVisible(driver,CensorLoginUI.LOGIN_BUTTON);
        return checkAreElementsIsDisplay(driver,CensorLoginUI.LOGIN_BUTTON);
    }
}
