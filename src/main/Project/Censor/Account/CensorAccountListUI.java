package Account;

public class CensorAccountListUI {
    public static final String TITLE_ACCOUNT_MODERATOR = "//h4[@title = 'Kiểm duyệt người dùng']";
    public static final String ACCOUNT_SEARCH_FIELD = "//input[contains(@data-bind ,'valSearch')]";
    public static final String TITLE_CONFIRM_PASS_POPUP = "//h5[@class = 'modal-title'][text()='Xác nhận mật khẩu']";
    public static final String CONFIRM_PASS_FIELD = "//input[@type = 'password']";
    public static final String CONFIRM_BUTTON = "//button[text()= 'Xác nhận']";
    public static final String BLOCKED_STATUS = "//span[contains(text(),'Email')]/following-sibling::span[contains(text(),'%s')]/ancestor::td[@data-title = 'Thông tin']/preceding-sibling::td[@data-title = 'Name']//span[contains(text(),'%s')]";
}