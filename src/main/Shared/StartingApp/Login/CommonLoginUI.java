package StartingApp.Login;

public class CommonLoginUI {
    public static final String FORGOT_LINK = "//a[@class='forgotpw']";

    public static final String USER_NAME = "//input[@name = 'identity']";
    public static final String PASSWORD = "//input[@name = 'password']";
    public static final String CAPTCHA_CODE = "//input[@id='captchaCode']";
    public static final String LOGIN_BUTTON ="//button[contains(text(),'Đăng nhập')]";

    public static final String VALIDATE_USER_NAME_ERROR_MESSAGE = "//input[@name = 'identity']/following-sibling::div";
    public static final String VALIDATE_PASS_WORD_ERROR_MESSAGE = "//input[@name = 'password']/following-sibling::div";




}
