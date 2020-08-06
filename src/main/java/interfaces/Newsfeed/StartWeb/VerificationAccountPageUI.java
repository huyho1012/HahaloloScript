package interfaces.Newsfeed.StartWeb;

public class VerificationAccountPageUI {
    public static final String TITLE_VERIFY_ACCOUNT_PAGE_BY = "//h3[@class ='text-center'][contains(text(),'Xác minh tài khoản bằng %s')]";
    public static final String CONTENT_VERIFY = "//p[@class ='text-center']";

    public static final String VERIFY_CODE_TEXT_BOX = "//input[@name = 'code']";
    public static final String VERIFY_BUTTON = "//button[@type = 'submit']";
    public static final String VERIFY_MESSAGE_CODE = "//div[@id = 'verify_success']/h6";
}
