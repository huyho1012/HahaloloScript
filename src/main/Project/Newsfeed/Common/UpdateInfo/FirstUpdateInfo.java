package Newsfeed.Common.UpdateInfo;

import Newsfeed.Common.FeedCommon;
import org.openqa.selenium.WebDriver;

public class FirstUpdateInfo extends FeedCommon {

    WebDriver driver;
    public FirstUpdateInfo(WebDriver webDriver){
        driver = webDriver;
    }

    // Update
    public void clickCancelUpdateNewInfo() {
        waitElementToClickAble(driver, FirstUpdatePopUpUI.BUTTON_CANCEL);
        clickToElement(driver,FirstUpdatePopUpUI.BUTTON_CANCEL);
    }

    public void clickUpdateButton() {
        waitElementToClickAble(driver,FirstUpdatePopUpUI.BUTTON_UPDATE);
        clickToElement(driver,FirstUpdatePopUpUI.BUTTON_UPDATE);
    }

    public void updateBirthday(WebDriver driver, String dayItem, String monthItem, String yearItem) {
        waitElementToClickAble(driver,FirstUpdatePopUpUI.DATE_SELECTED_DROPDOWN,"Ngày");
        clickToElement(driver, FirstUpdatePopUpUI.DATE_SELECTED_DROPDOWN,"Ngày");
        clickToElement(driver, FirstUpdatePopUpUI.DATE_SELECTED_ITEM,"Ngày",dayItem);
        setTimeDelay(1);
        clickToElement(driver, FirstUpdatePopUpUI.DATE_SELECTED_DROPDOWN,"Tháng");
        clickToElement(driver, FirstUpdatePopUpUI.DATE_SELECTED_ITEM,"Tháng",monthItem);
        setTimeDelay(1);
        clickToElement(driver, FirstUpdatePopUpUI.DATE_SELECTED_DROPDOWN,"Năm");
        clickToElement(driver, FirstUpdatePopUpUI.DATE_SELECTED_ITEM,"Năm",yearItem);
    }

    public void updateGender(WebDriver driver , String genderValue) {
        waitElementToClickAble(driver,FirstUpdatePopUpUI.GENDER_OPTION,genderValue);
        clickToElement(driver,FirstUpdatePopUpUI.GENDER_OPTION,genderValue);
    }
    public void updateCountry(WebDriver driver, String countryItem) {
        selectItemInCustomDropdown(driver,FirstUpdatePopUpUI.COUNTRY_DROPDOWN,FirstUpdatePopUpUI.COUNTRY_ITEM,countryItem);
    }

}
