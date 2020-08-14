package actions.common;

public class GlobalVariables {

    // Tài khoản NewsFeed - Business - Wallet
    public static String FEED_EMAIL_ACCOUNT = "khotrauchien@mailinator.com";
    public static String FEED_EMAIL_PASSWORD = "111111";

    public static String FEED_PHONE_ACCOUNT = "0936709449";
    public static String FEED_PHONE_PASSWORD = "20b87bis";
    // Tài khoản Backend - Censor
    public static String BACKEND_USER_NAME = "balo_04@mailinator.com";
    public static String BACKEND_PASSWORD = "123456";

    // URL Hahalolo
    public static final String URL_NEWS_FEED_LOGIN = "https://test-newsfeed.hahalolo.com/auth/signin";
    public static final String URL_BUSINESS_PAGE = "https://test-business.hahalolo.com/";
    public static final String URL_BACKEND_LOGIN = "https://test-backend.hahalolo.com/auth/signin";
    public static final String URL_CENSOR_LINK = "https://test-censor.hahalolo.com/auth/signin";

    // Constant
    public static final long LONG_TIME_OUT = 30;
    public static final long LESS_TIME_OUT = 5;
    public static final String HTML_CODE = "<p> Hello word </p>";
    public static final String SCRIPT_CODE = "<script>destroyWebsite();</script>";

    // Đường dẫn thư mục
    public static final String ROOT_FOLDER = System.getProperty("user.dir");
    public static final String UPLOAD_FOLDER = ROOT_FOLDER+"\\SupportHelper\\FileUpload\\";
    public static final String UPLOAD_FILE_FIREFOX_PATH = GlobalVariables.ROOT_FOLDER + "\\src\\test\\Resource\\AutoIT\\chromeUploadMultiple.exe";
    public static final String UPLOAD_FILE_CHROME_PATH = GlobalVariables.ROOT_FOLDER + "\\src\\test\\Resource\\AutoIT\\firefoxUploadMultiple.exe";

    // Mailinator
    public static final String URL_MAILINATOR = "https://www.mailinator.com/";
    public static final String MAIl_SEARCH_BOX = "//input[@id = 'addOverlay']";
    public static final String SEARCH_BOX = "//button[@id = 'go-to-public']";
    public static final String EMAIL_VERIFY_ACCOUNT = "//a[contains(text(),'Xác thực tài khoản Hahalolo')]";
    public static final String FRAME_BODY_MESSAGE = "//iframe[@id = 'msg_body']";
    public static final String VERIFY_CODE_VALUE = "//p[contains(text(),'Bạn có thể được yêu cầu nhập mã xác nhận này:')]/following-sibling::h2";
}
