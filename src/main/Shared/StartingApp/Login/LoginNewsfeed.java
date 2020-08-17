package StartingApp.Login;

import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Register.RegisterPageUI;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LoginNewsfeed extends AbstractPage {
    WebDriver driver;
    public LoginNewsfeed(WebDriver webDriver){
        driver = webDriver;
    }


    // Kiểm tra trang có phải tiếng việt chưa (False -> Chuyển đồi ngôn ngữ hệ thống)
    public void changeLanguageSystemToVI(){
        waitElementToVisible(driver, RegisterPageUI.VIETNAMESE_BUTTON);
        if(!checkIsDisplayedElement(driver, RegisterPageUI.VIETNAMESE_BUTTON)){
            clickToElement(driver, RegisterPageUI.VIETNAMESE_BUTTON);
        }
    }

    // Hàm nhập tài khoản login
    public void enterUsernameToLogin(String username){
        waitElementToVisible(driver, CommonLoginUI.USER_NAME);
        sendKeyToElement(driver, CommonLoginUI.USER_NAME, username);
    }

    // Hàm nhập mật khẩu tài khoản
    public void enterPasswordToLogin(String password){
        waitElementToVisible(driver, CommonLoginUI.PASSWORD);
        sendKeyToElement(driver, CommonLoginUI.PASSWORD, password);
    }

    // Login và đều hướng sang trang NF
    public void clickLoginButton(){
        waitElementToClickAble(driver, CommonLoginUI.LOGIN_BUTTON);
        clickToElement(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    // Lấy
    public String getErrorMessageOfUsername(){
        waitElementToVisible(driver, CommonLoginUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
        return getTextOfElement(driver, CommonLoginUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
    }

    public String getErrorMessageOfPassword(){
        waitElementToVisible(driver, CommonLoginUI.VALIDATE_PASS_WORD_ERROR_MESSAGE);
        return getTextOfElement(driver, CommonLoginUI.VALIDATE_USER_NAME_ERROR_MESSAGE);
    }

    public boolean checkLoginNewsfeedPageIsDisplay() {
        waitElementToVisible(driver, CommonLoginUI.LOGIN_BUTTON);
        return checkIsDisplayedElement(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    public void enterFirstNameForRegister(String firstName){
        waitElementToVisible(driver, RegisterPageUI.FIRST_NAME);
        sendKeyToElement(driver, RegisterPageUI.FIRST_NAME, firstName);
    }

    public void enterLastNameForRegister(String lastName){
        waitElementToVisible(driver, RegisterPageUI.LAST_NAME);
        sendKeyToElement(driver, RegisterPageUI.LAST_NAME, lastName);
    }
    public void enterNewAccountForRegister(String accountName){
        waitElementToVisible(driver, RegisterPageUI.USERNAME);
        sendKeyToElement(driver, RegisterPageUI.USERNAME, accountName);
    }
    public void enterPasswordForRegister(String passWord){
        waitElementToVisible(driver, RegisterPageUI.PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD, passWord);
    }
    public void enterConfirmPasswordForRegister(String confirmPass){
        waitElementToVisible(driver, RegisterPageUI.CONFIRM_PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD, confirmPass);
    }
    public void clickSignUpButton() {
        waitElementToClickAble(driver, RegisterPageUI.SIGN_UP_BUTTON);
        clickToElement(driver, RegisterPageUI.SIGN_UP_BUTTON);
    }

    public boolean changePhoneCode(String phoneCode) {
        waitElementToClickAble(driver, RegisterPageUI.PHONE_CODE);
        if(checkIsDisplayedElement(driver, RegisterPageUI.PHONE_CODE)){
            selectItemInCustomDropdown(driver, RegisterPageUI.PHONE_CODE, RegisterPageUI.PHONE_CODE_ITEM,phoneCode);
            return true;
        }return false;
    }


    public String getErrorValidationOfFirstName(){
        waitElementToVisible(driver,RegisterPageUI.ERROR_MESSAGE_OF_FIRST_NAME);
        return getTextOfElement(driver,RegisterPageUI.ERROR_MESSAGE_OF_FIRST_NAME);
    }
    public String getErrorValidationOfLastName(){
        waitElementToVisible(driver,RegisterPageUI.ERROR_MESSAGE_OF_LAST_NAME);
        return getTextOfElement(driver,RegisterPageUI.ERROR_MESSAGE_OF_LAST_NAME);
    }
    public String getErrorValidationOfNewUsername(){
        waitElementToVisible(driver,RegisterPageUI.ERROR_MESSAGE_OF_USERNAME);
        return getTextOfElement(driver,RegisterPageUI.ERROR_MESSAGE_OF_USERNAME);
    }
    public String getErrorValidationOfNewPassword(){
        waitElementToVisible(driver,RegisterPageUI.ERROR_MESSAGE_OF_PASSWORD);
        return getTextOfElement(driver,RegisterPageUI.ERROR_MESSAGE_OF_PASSWORD);
    }
    public String getErrValidationOfConfirmPass(){
        waitElementToVisible(driver,RegisterPageUI.ERROR_MESSAGE_OF_CONFIRM_PASS);
        return getTextOfElement(driver,RegisterPageUI.ERROR_MESSAGE_OF_CONFIRM_PASS);
    }

    public String getErrValidationOfPhoneCode(){
        waitElementToVisible(driver,RegisterPageUI.ERROR_MESSAGE_OF_PHONE_CODE);
        return getTextOfElement(driver,RegisterPageUI.ERROR_MESSAGE_OF_PHONE_CODE);
    }
}
