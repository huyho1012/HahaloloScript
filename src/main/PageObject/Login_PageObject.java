package PageObject;

import Interface.Login_PageUI;
import Interface.Register_PageUI;
import common.GeneralHandler.AbstractPage;
import common.Utils.ReadConfigLanguageFile;
import org.openqa.selenium.WebDriver;
import sun.rmi.runtime.Log;

import static common.Utils.ReadConfigLanguageFile.CONFIG_RESOURCE;

public class Login_PageObject extends AbstractPage {


    WebDriver driver;
    ReadConfigLanguageFile langConfig;

    public Login_PageObject(WebDriver webDriver){
        driver = webDriver;

    }

    public String getLanguageOnHahalolo(WebDriver driver){
        if(checkIsDisplayedElement(driver, Login_PageUI.ICON_EMG_LANG)|| checkIsDisplayedElement(driver,Login_PageUI.ICON_VI_LANG)){
            if(getAttributeOfElement(driver,Login_PageUI.ICON_EMG_LANG,"class").contains("nav-item active")){
                return "en";
            }
            else if(getAttributeOfElement(driver,Login_PageUI.ICON_EMG_LANG,"class").contains("nav-item active")) {
                return "vi";
            }else {
                return "Không xác đinh";
            }
        }else {
            System.out.println("Không load dc dữ liệu ngôn ngữ");
            return null;
        }
    }

    public void enterUsernameForLogin(String userName){
        waitElementToVisible(driver, Login_PageUI.FIELD_USER_NAME);
        sendKeyToElement(driver, Login_PageUI.FIELD_USER_NAME,userName);
    }

    public void enterPasswordForLogin(String password){
        System.out.println("Góa trị là:  123 " +System.getProperty("language"));
        waitElementToVisible(driver, Login_PageUI.FIELD_PASSWORD);
        sendKeyToElement(driver, Login_PageUI.FIELD_PASSWORD,password);
    }

    public void clickToButtonLogin(){
        waitElementToClickAble(driver, Login_PageUI.BUTTON_LOGIN);
        clickToElement(driver,Login_PageUI.BUTTON_LOGIN);
    }

    private String getPlaceholderOfFieldUsernameOnFormLogin(){
        waitElementToVisible(driver, Login_PageUI.FIELD_USER_NAME);
        String valueText = getAttributeOfElement(driver,Login_PageUI.FIELD_USER_NAME,"value");
        if(!valueText.isEmpty()){
            System.out.println("Đang chứa dữ liệu");
            return null;
        }else {
            return getAttributeOfElement(driver,Login_PageUI.FIELD_USER_NAME,"placeholder");
        }
    }

    public boolean checkPlaceholderOfFieldUsernameIsDisplayedCorrectly(){
        String placeholder = getPlaceholderOfFieldUsernameOnFormLogin();
        String expectedPlaceholder = CONFIG_RESOURCE.getValue("placeholderUsername");
        if(placeholder.equals(expectedPlaceholder)){
            return true;
        }else {
            System.out.println("Không trùng khớp");
            System.out.println("Giá trị placer hiện tại: " + placeholder);
            System.out.println("Giá trị placeholder mong muống: " + expectedPlaceholder);
            return false;
        }
    }

    private String getPlaceholderOfFieldPasswordOnFormLogin(){
        waitElementToVisible(driver, Login_PageUI.FIELD_PASSWORD);
        String valueText = getAttributeOfElement(driver,Login_PageUI.FIELD_PASSWORD,"value");
        if(!valueText.isEmpty()){
            System.out.println("Đang chứa dữ liệu");
            return null;
        }else {
            return getAttributeOfElement(driver,Login_PageUI.FIELD_PASSWORD,"placeholder");
        }
    }

    public boolean checkPlaceholderOfFieldPasswordIsDisplayedCorrectly(){
        String placeholder = getPlaceholderOfFieldPasswordOnFormLogin();
        String expectedPlaceholder = CONFIG_RESOURCE.getValue("placeholderPassword");
        if(placeholder.equals(expectedPlaceholder)){
            return true;
        }else {
            System.out.println("Không trùng khớp");
            System.out.println("Giá trị placer hiện tại: " + placeholder);
            System.out.println("Giá trị placeholder mong muống: " + expectedPlaceholder);
            return false;
        }
    }



}
