package PageObject;

import Interface.Register_PageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Register_PageObject extends StartUp_PageObject{

    WebDriver driver;

    private String parentID;
    public Register_PageObject(WebDriver webdriver) {
        super(webdriver);
        driver = webdriver;
        parentID = driver.getWindowHandle();
    }

    public void enterFirstNameToRegister(String firstname){
        waitElementToVisible(driver, Register_PageUI.FIELD_FIRST_NAME);
        sendKeyToElement(driver, Register_PageUI.FIELD_FIRST_NAME,firstname);
    }
    public void enterLastNameToRegister(String lastname){
        waitElementToVisible(driver, Register_PageUI.FIELD_LAST_NAME);
        sendKeyToElement(driver, Register_PageUI.FIELD_LAST_NAME,lastname);
    }
    public void enterUsernameToRegister(String username){
        waitElementToVisible(driver, Register_PageUI.FIELD_EMAIL);
        sendKeyToElement(driver, Register_PageUI.FIELD_EMAIL,username);
    }
    public void enterPasswordToRegister(String password){
        waitElementToVisible(driver, Register_PageUI.FIELD_PASSWORD);
        sendKeyToElement(driver, Register_PageUI.FIELD_PASSWORD,password);
    }
    public void enterConfirmPassToRegister(String confirmPass){
        waitElementToVisible(driver, Register_PageUI.FIELD_CONFIRM_PASS);
        sendKeyToElement(driver, Register_PageUI.FIELD_CONFIRM_PASS,confirmPass);
    }

    public void clickToButtonRegister(){
        waitElementToClickAble(driver, Register_PageUI.BUTTON_REGISTER);
        clickToElement(driver, Register_PageUI.BUTTON_REGISTER);
    }

    public String getVerificationCode(String email){
        openNewWindow(driver,"https://www.mailinator.com");
        switchToAnotherWindowByID(driver,parentID);
        waitElementToVisible(driver,"//input[@id='addOverlay']");
        sendKeyToElement(driver,"//input[@id='addOverlay']",email);
        String currentId = driver.getWindowHandle();
        sendKeyboardToElement(driver,"//input[@id='addOverlay']", Keys.ENTER);
        setTimeDelay(2);
        waitElementToClickAble(driver, "//td[contains(text(),'Xác thực tài khoản Hahalolo')]");
        clickToElement(driver, "//td[contains(text(),'Xác thực tài khoản Hahalolo')]");
        setTimeDelay(2);
        switchToFrameOrIFrame(driver,"//iframe[@id='html_msg_body']");
        String text =  getTextOfElement(driver,"//p[contains(text(),'Bạn có thể được yêu cầu nhập mã xác nhận này:')]/following-sibling::h2");
        switchToAnotherWindowByID(driver,currentId);
        return text;
    }

    public void enterVerifyCodeToRegister(String verifyCode) {
        waitElementToVisible(driver, Register_PageUI.FIELD_VERIFY_CODE);
        sendKeyToElement(driver,Register_PageUI.FIELD_VERIFY_CODE,verifyCode);
    }

    public void clickToButtonVerify() {
        waitElementToClickAble(driver,  Register_PageUI.BUTTON_VERIFY);
        clickToElement(driver, Register_PageUI.BUTTON_VERIFY);
    }
}
