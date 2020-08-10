package actions.PageObject.newsfeed.Starting;

import actions.PageObject.Backend.BackendLoginPageObject;
import actions.PageObject.Censor.CensorLogin;
import actions.PageObject.newsfeed.Common.HeaderMenu;
import actions.PageObject.newsfeed.PageFeed.NewsFeedHomepage;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import interfaces.Newsfeed.StartWeb.LoginPageUI;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class NewsFeedLogin extends HeaderMenu {
    WebDriver driver;
    public NewsFeedLogin(WebDriver webDriver){
        driver = webDriver;
    }
    public void enterDataToTextBoxField(WebDriver driver, String nameField ,String dataValue) {
        waitElementToVisible(driver, LoginPageUI.DYNAMIC_TEXT_BOX, nameField);
        sendKeyToElement(driver,LoginPageUI.DYNAMIC_TEXT_BOX,dataValue, nameField);
    }

    public String getValidateErrMessage(WebDriver driver, String nameField) {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE,nameField);
        return getTextOfElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE,nameField);
    }
    public NewsFeedHomepage clickToLoginButton() {
        waitElementToClickAble(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return new NewsFeedHomepage(driver);
    }

    public NewsFeedVerifyAccount clickSignUpButton() {
        waitElementToClickAble(driver,LoginPageUI.SIGN_UP_BUTTON);
        clickToElement(driver,LoginPageUI.SIGN_UP_BUTTON);
        return PageGenerator.getVerifyAccountPage(driver);
    }

    public void changeLanguageSystemToVI(){
        waitElementToVisible(driver, LoginPageUI.VIETNAMESE_BUTTON);
        if(!checkIsDisplayedElement(driver, LoginPageUI.VIETNAMESE_BUTTON)){
            clickToElement(driver,LoginPageUI.VIETNAMESE_BUTTON);
        }
    }

    public boolean changePhoneCode(String phoneCode) {
        waitElementToClickAble(driver,LoginPageUI.PHONE_CODE_AREA);
        if(checkIsDisplayedElement(driver,LoginPageUI.PHONE_CODE_AREA)){
            selectItemInCustomDropdown(driver,LoginPageUI.PHONE_CODE_AREA,"//span[@class ='phone-code']",phoneCode);
            return true;
        }return false;
    }

    public boolean checkLogoutSuccess() {
        waitElementToVisible(driver,LoginPageUI.TITLE_REGISTER_FORM);
        return checkIsDisplayedElement(driver,LoginPageUI.TITLE_REGISTER_FORM);
    }

    public BackendLoginPageObject goToBackendLoginPage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, GlobalVariables.URL_BACKEND_LOGIN);
        return PageGenerator.getLoginBackendPage(driver);
    }

    public CensorLogin gotoCensorLoginPage(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, GlobalVariables.URL_CENSOR_LINK);
        return  PageGenerator.getCensorLoginPage(driver);
    }

    public boolean checkNewsFeedLoginPageDisplay() {
        waitForPageLoading(driver);
        waitElementToVisible(driver,LoginPageUI.TITLE_REGISTER_FORM);
        return checkIsDisplayedElement(driver,LoginPageUI.TITLE_REGISTER_FORM);
    }
}
