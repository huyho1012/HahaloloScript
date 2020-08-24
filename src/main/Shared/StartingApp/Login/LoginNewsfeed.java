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
    // Login và đều hướng sang trang NF
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
}
