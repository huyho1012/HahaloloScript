package StartingApp.Login;

import Censor.Dashboard.CensorDashboard;
import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LoginBackend extends AbstractPage {
    WebDriver driver;
    public LoginBackend(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsername(WebDriver driver, String userName) {
        waitElementToVisible(driver, CommonLoginUI.USER_NAME);
        sendKeyToElement(driver, CommonLoginUI.USER_NAME, userName);
    }
    public void enterPasswordToLogin(WebDriver driver, String passWord) {
        waitElementToVisible(driver, CommonLoginUI.PASSWORD);
        sendKeyToElement(driver, CommonLoginUI.PASSWORD, passWord);
    }

    public CensorDashboard clickLoginButton(WebDriver driver) {
        waitElementToClickAble(driver, CommonLoginUI.LOGIN_BUTTON);
        clickToElement(driver, CommonLoginUI.LOGIN_BUTTON);
        return PageGenerator.createCensorDashboardPage(driver);
    }

    public boolean checkLogoutCensorSuccess(WebDriver driver) {
        waitForPageLoading(driver);
        waitElementToVisible(driver, CommonLoginUI.LOGIN_BUTTON);
        return checkAreElementsIsDisplay(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    public LoginBackend goToBackendLoginPage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, Common.GlobalVariables.URL_BACKEND_LOGIN);
        return PageGenerator.getLoginBackendPage(driver);
    }
}
