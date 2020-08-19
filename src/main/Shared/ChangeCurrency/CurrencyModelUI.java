package ChangeCurrency;

public class CurrencyModelUI {
    public static final String CURRENCY_CODE = "//span[@class = 'currency-code'][text() = '%s']";
    public static final String CURRENCY_NAME = "//span[@class = 'currency-name'][text() = '%s']";
    public static final String CHANGE_CURRENCY_POPUP = "//div[@id ='modal__change-currency']//h6[@class = 'modal-title']";
    public static final String BUTTON_CLOSE = "//div[@id ='modal__change-currency']//button[@class = 'close']";
    public static final String ICON_CLOSE = "//div[@id ='modal__change-currency']//button[contains(text(), 'Đóng')]";
}
