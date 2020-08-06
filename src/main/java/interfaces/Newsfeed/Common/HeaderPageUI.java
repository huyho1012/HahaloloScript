package interfaces.Newsfeed.Common;

public class HeaderPageUI {
    public static final String MAIN_SEARCH_FIELD = "//div[@id = 'js-search-tmp']";

    public static final String PERSONAL_URL_LINK = "//div[@class= 'uri-name']";
    public static final String NEWS_FEED_HOMEPAGE_LINK = "//a[contains(text(), 'Trang chủ')]";

    public static final String MESSAGE_FUNCTION = "//i[@class = 'ic ic-chat-primary']";
    public static final String SYS_NOTIFICATION_FUNCTION = "//i[@class = 'ic ic-bell-primary']";
    public static final String FRIEND_NOTIFICATION_FUNCTION = "//i[@class = 'ic ic-friends-primary']";
    public static final String HELPER_FUNCTION = "//i[@class = 'ic ic-question-circle-primary']";
    public static final String SETTING_FUNCTION = "//i[@class = 'ic ic-caret-down primary']";

    public static final String CURRENCY_SETTING_HEADER = "//div[@class = 'topnav-item setcurrency']";
    public static final String WALLET_FUNCTION = "//i[@class = 'ic ic-wallet-primary']";
    public static final String CART_FUNCTION = "//i[@class = 'ic ic-cart-primary']";

    public static final String SETTING_ITEM_FUNCTION = "//i[@class = 'ic ic-caret-down primary']/parent::span/following-sibling::div//i[@class ='ic %s']";
    public static final String NEWS_FEED_MENU = "//nav[@id = 'menu-primary']//a[contains(text(),'%s')]";
    public static final String HELPER_ITEM_FUNCTION = "//i[@class = 'ic ic-question-circle-primary']/parent::span/following-sibling::div/a[text() = '%s']";
}
