package ChangeCurrency;

import CommonHelper.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ChangeCurrencyModel extends AbstractPage {
    WebDriver driver;
    public String getTitleOfChangeCurrencyPopup(){
        waitElementToVisible(driver, CurrencyModelUI.CHANGE_CURRENCY_POPUP);
        return getTextOfElement(driver, CurrencyModelUI.CHANGE_CURRENCY_POPUP);
    }
    public void changeCurrencyOfSystem(String currencyCode){
        waitElementToVisible(driver,CurrencyModelUI.CURRENCY_CODE,currencyCode);
        clickToElement(driver,CurrencyModelUI.CURRENCY_CODE,currencyCode);
    }
    public void closeChangeCurrencyPopupByClickCloseButton(){
        waitElementToClickAble(driver,CurrencyModelUI.BUTTON_CLOSE);
        clickToElement(driver, CurrencyModelUI.BUTTON_CLOSE);

    }
    public void closeChangeCurrencyPopupByClickIconClose(){
        waitElementToClickAble(driver,CurrencyModelUI.ICON_CLOSE);
        clickToElement(driver, CurrencyModelUI.ICON_CLOSE);
    }
}
