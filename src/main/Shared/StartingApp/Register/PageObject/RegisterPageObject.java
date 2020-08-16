package StartingApp.Register.PageObject;

import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import StartingApp.Register.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;
    public RegisterPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public VerifyAccountPageObject clickSignUpButton() {
        waitElementToClickAble(driver, RegisterPageUI.SIGN_UP_BUTTON);
        clickToElement(driver, RegisterPageUI.SIGN_UP_BUTTON);
        return PageGenerator.getVerifyAccountPage(driver);
    }

    public boolean changePhoneCode(String phoneCode) {
        waitElementToClickAble(driver, RegisterPageUI.PHONE_CODE);
        if(checkIsDisplayedElement(driver, RegisterPageUI.PHONE_CODE)){
            selectItemInCustomDropdown(driver, RegisterPageUI.PHONE_CODE, RegisterPageUI.PHONE_CODE_ITEM,phoneCode);
            return true;
        }return false;
    }

}
