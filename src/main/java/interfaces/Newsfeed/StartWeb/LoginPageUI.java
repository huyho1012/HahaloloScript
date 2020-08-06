package interfaces.Newsfeed.StartWeb;

public class LoginPageUI {

    public static final String USER_NAME_LOGIN_TEXT_BOX = "//input[@id ='signin-identity']";
    public static final String PASSWORD_LOGIN_TEXT_BOX = "//input[@id ='password']";
    public static final String LOGIN_BUTTON ="//button[@class ='btn btn-success btn-login']";
    public static final String VALIDATE_ERROR_MESSAGE_USERNAME ="//input[@id ='signin-identity']/following-sibling::div";
    public static final String VALIDATE_ERROR_MESSAGE_PASSWORD ="//input[@id ='password']/following-sibling::div";
    public static final String FORGOT_LINK = "//a[@class='forgotpw']";

    public static final String FIRST_NAME_TEXT_BOX = "//input[@name = 'nv104']";
    public static final String LAST_NAME_TEXT_BOX = "//input[@name = 'nv103']";
    public static final String PHONE_EMAIL_TEXT_BOX = "//input[@name = 'nv108']";
    public static final String PASSWORD_TEXT_BOX = "//input[@name = 'nv109']";
    public static final String CONFIRM_PASSWORD_TEXT_BOX = "//input[@name = 'repeatPassword']";
    public static final String PHONE_CODE_AREA = "//div[@class = 'selectize-input items has-options full has-items']";
    public static final String SIGN_UP_BUTTON = "//button[@id = 'signUpButton']";

    public static final String VALIDATE_ERROR_MESSAGE_FROM_FIRST_NAME = "//input[@name = 'nv104']/following-sibling::div";
    public static final String VALIDATE_ERROR_MESSAGE_FROM_LAST_NAME = "//input[@name = 'nv103']/following-sibling::div";
    public static final String VALIDATE_ERROR_MESSAGE_FROM_PHONE_EMAIL = "//input[@name = 'nv108']/following-sibling::div";
    public static final String VALIDATE_ERROR_MESSAGE_FROM_PASS_WORD = "//input[@name = 'nv109']/following-sibling::div";
    public static final String VALIDATE_ERROR_MESSAGE_FROM_CONFIRM_PASS = "//input[@name = 'repeatPassword']/following-sibling::div";

    public static final String ENGLISH_BUTTON = "//span[text() = 'English']";
    public static final String VIETNAMESE_BUTTON = "//span[text() = 'Tiếng Việt']";

    public static final String TITLE_REGISTER_FORM = "//div[@class = 'form-signup-header']/div[contains(text(),'Tham gia Hahalolo ngay!')]";

}
