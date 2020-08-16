package StartingApp.Register;

public class RegisterPageUI {

    public static final String ENGLISH_BUTTON = "//span[text() = 'English']";
    public static final String VIETNAMESE_BUTTON = "//span[text() = 'Tiếng Việt']";
    public static final String TITLE_REGISTER_FORM = "//div[@class = 'form-signup-header']/div[contains(text(),'Tham gia Hahalolo ngay!')]";


    public static final String FIRST_NAME = "";
    public static final String LAST_NAME = "";
    public static final String USERNAME = "";
    public static final String PASSWORD = "";
    public static final String CONFIRM_PASSWORD = "";
    public static final String PHONE_CODE = "//div[@class = 'selectize-input items has-options full has-items']";
    public static final String PHONE_CODE_ITEM = "//span[@class ='phone-code']";

    public static final String ERROR_MESSAGE_OF_FIRST_NAME = "";
    public static final String ERROR_MESSAGE_OF_LAST_NAME = "";
    public static final String ERROR_MESSAGE_OF_USERNAME = "";
    public static final String ERROR_MESSAGE_OF_PASSWORD = "";
    public static final String ERROR_MESSAGE_OF_CONFIRM_PASS = "";
    public static final String ERROR_MESSAGE_OF_PHONE_CODE = "";

    public static final String SIGN_UP_BUTTON = "//button[@id = 'signUpButton']";

    public static final String TITLE_VERIFY_ACCOUNT_PAGE_BY = "//h3[@class ='text-center'][contains(text(),'Xác minh tài khoản bằng %s')]";
    public static final String CONTENT_VERIFY = "//p[@class ='text-center']";
    public static final String VERIFY_CODE_TEXT_BOX = "//input[@name = 'code']";
    public static final String VERIFY_BUTTON = "//button[@type = 'submit']";
    public static final String VERIFY_MESSAGE_CODE = "//div[@id = 'verify_success']/h6";
}
