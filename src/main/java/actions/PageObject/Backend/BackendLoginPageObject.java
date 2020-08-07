package actions.PageObject.Backend;


import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import interfaces.Backend.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class BackendLoginPageObject extends AbstractPage {
    WebDriver driver;
    public BackendLoginPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterDataToUsernameTextBox(String userName) {
        waitElementToVisible(driver, LoginPageUI.USERNAME_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TEXT_BOX,userName);
    }
    public void enterDataToPasswordTextBox(String passWord) {
        waitElementToVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX,passWord);
    }

    public backendDashboardPageObject clickLoginButton() {
        waitElementToClickAble(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getBackendDashboardPage(driver);
    }
}
