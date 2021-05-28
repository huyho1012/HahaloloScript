package PageObject.Newsfeed;

import Interface.UpdateInfo_PageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class UpdateInfo_PageObject extends Newsfeed_PageObject{
    WebDriver driver;
    public UpdateInfo_PageObject(WebDriver webDriver){
        super(webDriver);
        driver = webDriver;
    }

    public void chooseDay(String date){
        waitElementToClickAble(driver, UpdateInfo_PageUI.DROPDOWN_DAY);
        sendKeyToElementByJS(driver, UpdateInfo_PageUI.DROPDOWN_DAY,date);
        sendKeyboardToElement(driver,UpdateInfo_PageUI.DROPDOWN_DAY, Keys.ENTER);
    }

    public void chooseMonth(String month){
        waitElementToClickAble(driver, UpdateInfo_PageUI.DROPDOWN_MONTH);
        sendKeyToElementByJS(driver, UpdateInfo_PageUI.DROPDOWN_MONTH,month);
        sendKeyboardToElement(driver,UpdateInfo_PageUI.DROPDOWN_MONTH, Keys.ENTER);
    }

    public void chooseYear(String year){
        waitElementToClickAble(driver, UpdateInfo_PageUI.DROPDOWN_YEAR);
        sendKeyToElementByJS(driver, UpdateInfo_PageUI.DROPDOWN_YEAR,year);
        sendKeyboardToElement(driver,UpdateInfo_PageUI.DROPDOWN_YEAR, Keys.ENTER);
    }

    public void chooseGender(String genderType){
        if(genderType.equals("Female")){
            waitElementToClickAble(driver,UpdateInfo_PageUI.FEMALE_GENDER);
            clickToElement(driver, UpdateInfo_PageUI.FEMALE_GENDER);
        } else if(genderType.equals("Male")){
            waitElementToClickAble(driver,UpdateInfo_PageUI.MALE_GENDER);
            clickToElement(driver, UpdateInfo_PageUI.MALE_GENDER);
        } else {
            waitElementToClickAble(driver,UpdateInfo_PageUI.OTHER_GENDER);
            clickToElement(driver, UpdateInfo_PageUI.OTHER_GENDER);
        }
    }

    public void chooseNationality(String country){
        waitElementToClickAble(driver, UpdateInfo_PageUI.DROPDOWN_COUNTRY);
        selectItemInCustomDropdown(driver,UpdateInfo_PageUI.DROPDOWN_COUNTRY,UpdateInfo_PageUI.OPTION_COUNTRY, country);
    }

    public void clickButtonUpdateNewInfo(){
        waitElementToClickAble(driver, UpdateInfo_PageUI.BUTTON_UPDATE);
        clickToElement(driver,UpdateInfo_PageUI.BUTTON_UPDATE);
    }
}
