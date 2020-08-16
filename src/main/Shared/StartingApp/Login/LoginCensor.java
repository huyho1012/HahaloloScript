package StartingApp.Login;

import Censor.Dashboard.CensorDashboardPageObject;
import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LoginCensor extends AbstractPage {
    WebDriver driver;
    public LoginCensor(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsername(String userName) {
        waitElementToVisible(driver, CommonLoginUI.USER_NAME);
        sendKeyToElement(driver, CommonLoginUI.USER_NAME, userName);
    }
    public void enterPassword(String passWord) {
        waitElementToVisible(driver, CommonLoginUI.PASSWORD);
        sendKeyToElement(driver, CommonLoginUI.PASSWORD, passWord);
    }

    public void clickLoginButton() {
        waitElementToClickAble(driver, CommonLoginUI.LOGIN_BUTTON);
        clickToElement(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    public boolean checkLogoutCensorSuccess() {
        waitForPageLoading(driver);
        waitElementToVisible(driver, CommonLoginUI.LOGIN_BUTTON);
        return checkAreElementsIsDisplay(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    public void gotoCensorLoginPage(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, Common.GlobalVariables.URL_CENSOR_LINK);
    }
}
