package Newsfeed.HeaderMenu.GeneralSettting;

public class GeneralSettingUI {

    public static final String TITLE_PAGE = "//div[@class = 'pageUI-header__title']";
    public static final String ACCOUNT_FUNCTION_TAB = "//a[contains(@class, '%s')]";

    public static final String TITLE_OF_TAB = "//div[@id='%s']//div[@class = 'pageUI-about-heading']";
    public static final String FULL_NAME_DATA = "//label[contains(text(),'Họ và tên')]/following-sibling::div//div[contains(@data-bind, 'userProfileVM.fullName')]";

    public static final String EDIT_FULL_NAME_BUTTON ="//label[contains(text(),'Họ và tên')]/following-sibling::div//i[@class = 'far fa-edit']";
    public static final String DYNAMIC_FIELD_ON_FULL_NAME = "//input[@name = '%s']";
    public static final String ERROR_MESSAGE_OF_DYNAMIC_FIELD_ON_FULL_NAME = "//input[@name = '%s']/following-sibling::div";
    public static final String MESSAGE_CHANGE_FULL_NAME = "//p[@id = 'js-result']";

    public static final String SAVE_CHANGE_FULL_NAME = "//button[contains(@data-bind,'onConfirmSaveName')]";
    public static final String CANCEL_CHANGE_FULL_NAME = "//button[contains(@data-bind,'onCancelSaveName')]";

    public static final String CONFIRM_PASS_POPUP = "//div[@id = 'modalConfirmPw']";
    public static final String CONFIRM_PASS = "//input[@name = 'confirmPwd']";
    public static final String BUTTON_CLOSE_CONFIRM_POPUP = "//div[@id= 'modalConfirmPw']//button[@class = 'close']";
    public static final String ERROR_MESSAGE_OF_CONFIRM_PASS = "//input[@name = 'confirmPwd']/following-sibling::div";
    public static final String CONFIRM_PASS_BUTTON= "//button[@id = 'act-confirm-pwd']";
    public static final String CANCEL_CONFIRM_PASS_BUTTON= "//div[@id= 'modalConfirmPw']//button[text() = 'Hủy bỏ']";


    public static final String EDIT_USERNAME_ICON = "//label[contains(text(),'Tên người dùng')]/following-sibling::div//i[@class = 'far fa-edit']";
    public static final String USERNAME_FIELD = "//input[contains(@data-bind,'valUsername')]";
    public static final String MESSAGE_VALIDATE_USERNAME = "//div[@id ='jsLoadMsg']//span";
    public static final String BUTTON_SAVE_USERNAME = "//button[@id = 'js_btn_save_username']";
    public static final String BUTTON_CANCEL_CHANGE_USERNAME = "//div[@id = 'js_body_username']/following-sibling::form//button[text()='Hủy bỏ']";

    public static final String ICON_SUCCESS_MESSAGE_OF_USERNAME = "//div[@id='jsLoadMsg']/i[@class ='fa fa-check text-success']";
    public static final String ICON_ERROR_MESSAGE_OF_USERNAME = "//div[@id='jsLoadMsg']/i[@class ='ffa fa-times text-danger']";
    public static final String USER_NAME = "//a[contains(@data-bind,'baseUrlUsername')]";
}