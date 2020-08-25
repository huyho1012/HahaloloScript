package StartingApp.Login;

import CommonHelper.Function.AbstractPage;
import StartingApp.Register.RegisterPageUI;
import org.openqa.selenium.WebDriver;

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

    public void enterUserNameToLogin(WebDriver driver, String userName){
        waitElementToVisible(driver, CommonLoginUI.USER_NAME, userName);
        sendKeyToElement(driver, CommonLoginUI.USER_NAME, userName);
    }

    public void enterPasswordToLogin(WebDriver driver, String passWord){
        waitElementToVisible(driver, CommonLoginUI.PASSWORD, passWord);
        sendKeyToElement(driver, CommonLoginUI.PASSWORD, passWord);
    }

    public void clickLoginButton(){
        waitElementToClickAble(driver, CommonLoginUI.LOGIN_BUTTON);
        clickToElement(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    public boolean checkLoginNewsfeedPageIsDisplay() {
        waitElementToVisible(driver, CommonLoginUI.LOGIN_BUTTON);
        return checkIsDisplayedElement(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    public void enterDataOnDynamicTextField(String nameField, String nameData){
        waitElementToVisible(driver, RegisterPageUI.TEXT_FIELD_DYNAMIC,nameField);
        sendKeyToElement(driver, RegisterPageUI.TEXT_FIELD_DYNAMIC,nameData, nameField);
    }


    public void clickSignUpButton() {
        waitElementToClickAble(driver, RegisterPageUI.SIGN_UP_BUTTON);
        clickToElement(driver, RegisterPageUI.SIGN_UP_BUTTON);
    }

    public void changePhoneCode(String phoneCode) {
        selectItemInCustomDropdown(driver, RegisterPageUI.PHONE_CODE, RegisterPageUI.PHONE_CODE_ITEM,phoneCode);

    }

    public String getErrorValidationOfTextField(String nameField){
        waitElementToVisible(driver, RegisterPageUI.ERROR_MESSAGE_OF_TEXT_FIELD, nameField);
        return getTextOfElement(driver, RegisterPageUI.ERROR_MESSAGE_OF_TEXT_FIELD, nameField);
    }
    public String getErrValidationOfPhoneCode(){
        waitElementToVisible(driver,RegisterPageUI.ERROR_MESSAGE_OF_PHONE_CODE);
        return getTextOfElement(driver,RegisterPageUI.ERROR_MESSAGE_OF_PHONE_CODE);
    }

    public void removePhoneCode() {
        waitElementToVisible(driver, RegisterPageUI.PHONE_CODE);
        removeTextOnElement(driver, RegisterPageUI.PHONE_CODE);
    }

    public String getTitleOfsignUpForm() {
        return null;
    }

    public void doActionLogin(WebDriver driver, String userName, String passWord) {
        sendKeyToElement(driver,CommonLoginUI.USER_NAME,userName);
        sendKeyToElement(driver, CommonLoginUI.PASSWORD ,passWord);
        clickToElement(driver, CommonLoginUI.LOGIN_BUTTON);
    }

    public Object getPlaceholderOfDynamicField() {
        return null;
    }

    public Object getContentOfSignUpButton() {
        return null;
    }

    public void getColorOfTitleOfSignUpForm() {
    }

    public void getColorOfSignUpButton() {
    }

    public void changeLanguageSystemToEng() {
    }
}
