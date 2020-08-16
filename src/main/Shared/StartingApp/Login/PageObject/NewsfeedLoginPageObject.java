package StartingApp.Login.PageObject;

import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Login.LoginPageUI;
import StartingApp.Register.RegisterPageUI;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class NewsfeedLoginPageObject extends AbstractPage {
    WebDriver driver;
    public NewsfeedLoginPageObject (WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsernameToLogin(WebDriver driver , String username){
        waitElementToVisible(driver, LoginPageUI.USER_NAME);
        sendKeyToElement(driver, LoginPageUI.USER_NAME, username);
    }

    public void enterPasswordToLogin(WebDriver driver , String password){
        waitElementToVisible(driver, LoginPageUI.PASSWORD);
        sendKeyToElement(driver, LoginPageUI.PASSWORD, password);
    }

    public NewsFeedTabPageObject clickLoginButton(WebDriver driver){
        waitElementToClickAble(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.createNewsfeedTab(driver);
    }

    public String getErrorMessageOfUsername(WebDriver driver){
        waitElementToVisible(driver, LoginPageUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
        return getTextOfElement(driver, LoginPageUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageOfPassword(WebDriver driver){
        waitElementToVisible(driver, LoginPageUI.VALIDATE_PASS_WORD_ERROR_MESSAGE);
        return getTextOfElement(driver, LoginPageUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
    }

    public boolean checkLogoutSuccess() {
        waitElementToVisible(driver,LoginPageUI.PASSWORD);
        return checkIsDisplayedElement(driver,LoginPageUI.PASSWORD);
    }

    public BackendLoginPageObject goToBackendLoginPage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, Common.GlobalVariables.URL_BACKEND_LOGIN);
        return PageGenerator.getLoginBackendPage(driver);
    }

    public CensorLoginPageObject gotoCensorLoginPage(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, Common.GlobalVariables.URL_CENSOR_LINK);
        return  PageGenerator.getCensorLoginPage(driver);
    }
    public void changeLanguageSystemToVI(){
        waitElementToVisible(driver, RegisterPageUI.VIETNAMESE_BUTTON);
        if(!checkIsDisplayedElement(driver, RegisterPageUI.VIETNAMESE_BUTTON)){
            clickToElement(driver, RegisterPageUI.VIETNAMESE_BUTTON);
        }
    }
}
