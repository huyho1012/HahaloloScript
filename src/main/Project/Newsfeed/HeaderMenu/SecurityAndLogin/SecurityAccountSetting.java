package Newsfeed.HeaderMenu.SecurityAndLogin;

import CommonHelper.Function.AbstractPage;
import Newsfeed.HeaderMenu.GeneralSettting.GeneralSettingUI;
import org.openqa.selenium.WebDriver;

public class SecurityAccountSetting extends AbstractPage {
    WebDriver driver;

    public void clickToButtonLogoutAll(){
        waitElementToClickAble(driver,SecurityAndLoginUI.LOGOUT_ALL_BUTTON);
        clickToElement(driver,SecurityAndLoginUI.LOGOUT_ALL_BUTTON);
    }

    public void clickToButtonConfirmLogoutAll(){
        waitElementToClickAble(driver,SecurityAndLoginUI.CONFIRM_BUTTON);
        clickToElement(driver,SecurityAndLoginUI.CONFIRM_BUTTON);
    }

    public void clickToButtonCancelLogoutAll(){
        waitElementToClickAble(driver,SecurityAndLoginUI.CANCEL_BUTTON);
        clickToElement(driver,SecurityAndLoginUI.CANCEL_BUTTON);
    }

    public void inputValueToFieldOnChangePassWord(String fieldName, String inputName){
       waitElementToInvisible(driver,SecurityAndLoginUI.DYNAMIC_FIELD_ON_CHANGE_PASS);
       sendKeyToElement(driver,SecurityAndLoginUI.DYNAMIC_FIELD_ON_CHANGE_PASS,inputName, fieldName);
    }
}
