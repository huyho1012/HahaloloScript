package Newsfeed.HeaderMenu.SecurityAndLogin;

public class SecurityAndLoginUI {

        public static final String LOGOUT_ALL_BUTTON= "//a[contains(@data-bind,'logOutAllDevice')]  ";

    public static final String HEADER_OF_POPUP_CONFIRM_LOGOUT_ALL ="//div[contains(@id , 'modal__delete-common')]//h6";

    public static final String CONFIRM_BUTTON ="//div[contains(@id , 'modal__delete-common')]//button[contains(@data-bind ,'onConfirm')]";
    public static final String CANCEL_BUTTON = "//div[contains(@id , 'modal__delete-common')]//button[contains(@data-bind ,'onCancel')]";
    public static final String ICON_REMOVE_POPUP_CONFIRM_LOGOUT_ALL = "//div[contains(@id , 'modal__delete-common')]//button[@class='close']/span";

    public static final String BUTTON_CHANG_PASS= "//div[@id='setting_security_and_login']//i[@class ='far fa-edit']";
    public static final String DYNAMIC_FIELD_ON_CHANGE_PASS ="//input[@name= '%s']";
    public static final String VALIDATE_ERROR_DYNAMIC_FIELD_ON_CHANGE_PASS ="//input[@name= '%s']/following-sibling::div[contains(@class,'invalid-feedback')]";
    public static final String SAVE_CHANGES_BUTTON ="//button[contains(@data-bind ,'onSavePassword')]";
    public static final String CANCEL_CHANGE_PASS_BUTTON = "//button[contains(@data-bind ,'onCancelSavePwd')]";
    public static final String FORGOT_LINK = "//a[contains(@data-bind ,'forgotpw')]";
}
