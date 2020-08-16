package StartingApp.Login.PageObject;

import Censor.Dashboard.CensorDashboardPageObject;
import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import StartingApp.Login.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class BackendLoginPageObject extends AbstractPage {
    WebDriver driver;
    public BackendLoginPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsername(WebDriver driver, String userName) {
        waitElementToVisible(driver, LoginPageUI.USER_NAME);
        sendKeyToElement(driver, LoginPageUI.USER_NAME, userName);
    }
    public void enterPasswordToLogin(WebDriver driver, String passWord) {
        waitElementToVisible(driver, LoginPageUI.PASSWORD);
        sendKeyToElement(driver, LoginPageUI.PASSWORD, passWord);
    }

    public CensorDashboardPageObject clickLoginButton(WebDriver driver) {
        waitElementToClickAble(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.createCensorDashboardPage(driver);
    }

    public boolean checkLogoutCensorSuccess(WebDriver driver) {
        waitForPageLoading(driver);
        waitElementToVisible(driver, LoginPageUI.LOGIN_BUTTON);
        return checkAreElementsIsDisplay(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
