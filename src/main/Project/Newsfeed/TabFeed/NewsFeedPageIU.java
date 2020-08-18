package Newsfeed.TabFeed;

public class NewsFeedPageIU {


    public static final String HOT_EXPERIENCE_TITLE = "//div[@id='js-widget-hot-exp']//div[@class = 'card-title']";
    public static final String linkFooterMenu = "//div[@class ='widget']//a[text()='%s']";

    public static final String LANGUAGE_BUTTON = "//div[@id='sidebar-right']//span[contains(@data-bind,'selectedLanguage')]";
    public static final String CHANGE_CURRENCY_BUTTON = "//a[@class ='small text-primary'][text() = 'Thay đổi']";

    public static final String VIEW_MORE_EXP_BUTTON = "//div[@class = 'widget js-widget-hot-exp']//a[text()='Xem thêm']";



    public static final String NAV_FEED_TAB = "//div[@class='menu menu--main']//a[text() = '%s']";
    public static final String TAB_ITEM_MY_ACCOUNT = "//div[@class= 'card card-your-info']//i[@class = '%s']";
    public static final String EDIT_PROFILE_BUTTON = "//a[contains(text(),' Chỉnh sửa trang cá nhân')]";


    public static final String UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Cập nhật')]";
    public static final String CANCEL_UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Bỏ qua')]";

    public static final String FORM_UPDATE_INFO = "//form[@class ='form-verify-account-info']";

    public static final String SELECTED_DATE_DROP_DOWN = "//input[@placeholder ='%s']";
    public static final String SELECTED_DATE_ITEM = "//input[@placeholder ='%s']/parent::div/following-sibling::div//div[@class='option']";

    public static final String GENDER_OPTION = "//input[@id = '%s']/following-sibling::label";
    public static final String COUNTRY_DROPDOWN = "//select[@id ='select-country']/following-sibling::div";
    public static final String COUNTRY_ITEM = "//input[@id = 'select-country-selectized']/parent::div/following-sibling::div//div[@class= 'option']";
    public static final String UPLOAD_BUTTON = "//button[contains(text(),'Cập nhật')]";

    public static final String React_Button = "//span[@class = 'fbUI fbUI__rac js-reaction fbUI__rac--']";
}
