package Newsfeed.UserSetting;

public class AccountSettingUI {

    public static final String TITLE_PAGE = "//div[@class = 'pageUI-header__title']";
    public static final String ACCOUNT_FUNCTION_TAB = "//a[contains(@class, '%s')]";

    public static final String TITLE_OF_TAB = "//div[@id= '%s']//div[@class = 'pageUI-about-heading']";

    public static final String FULL_NAME_DATA = "//label[contains(text(),'Họ và tên')]/following-sibling::div//div[contains(@data-bind, 'userProfileVM.fullName')]";

    public static final String EDIT_FULL_NAME_BUTTON ="//label[contains(text(),'Họ và tên')]/following-sibling::div//i[@class = 'far fa-edit']";
    public static final String FIRSTNAME = "//input[@name = 'firstName']";
    public static final String LASTNAME = "//input[@name = 'lastName']";
    public static final String MIDDLENAME = "//input[@name = 'middleName']";
    public static final String ERROR_MESSAGE_OF_FIRSTNAME = "//input[@name = 'firstName']/following-sibling::div";
    public static final String ERROR_MESSAGE_OF_LASTNAME = "//input[@name = 'lastName']/following-sibling::div";
    public static final String MESSAGE_CHANGE_FULL_NAME = "//p[@id = 'js-result']";

    public static final String SAVE_CHANGE_FULL_NAME = "//button[contains(@data-bind,'onConfirmSaveName')]";
    public static final String CANCEL_CHANGE_FULL_NAME = "//button[contains(@data-bind,'onCancelSaveName')]";

    public static final String CONFIRM_PASS_POPUP = "//div[@id = 'modalConfirmPw']";
    public static final String CONFIRM_PASS = "//input[@name = 'confirmPwd']";
    public static final String BUTTON_CLOSE_CONFIRM_POPUP = "//div[@id= 'modalConfirmPw']//button[@class = 'close']";
    public static final String ERROR_MESSAGE_OF_CONFIRM_PASS = "//input[@name = 'confirmPwd']/following-sibling::div";
    public static final String CONFIRM_PASS_BUTTON= "//button[@id = 'act-confirm-pwd']";
    public static final String CANCEL_CONFIRM_PASS_BUTTON= "//div[@id= 'modalConfirmPw']//button[text() = 'Hủy bỏ']";


    public static final String EDIT_USERNAME_BUTTON = "//label[contains(text(),'Tên người dùng')]/following-sibling::div//i[@class = 'far fa-edit']";
    public static final String USERNAME = "//input[contains(@data-bind,'valUsername')]";
    public static final String MESSAGE_VALIDATE_USERNAME = "//div[@id ='jsLoadMsg']//span";
    public static final String BUTTON_SAVE_USERNAME = "//button[@id = 'js_btn_save_username']";
    public static final String BUTTON_CANCEL_CHANGE_USERNAME = "//div[@id = 'js_body_username']/following-sibling::form//button[text()='Hủy bỏ']";
}
