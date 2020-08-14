package interfaces.Newsfeed.TabFeed;

public class NewsFeedPageIU {
    public static final String NORMAL_POST_FUNCTION = "//a[@id='act-nav-single']";
    public static final String EXPERIENCE_POST_FUNCTION = "//a[@id='act-nav-addvance']";

    public static final String UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Cập nhật')]";
    public static final String CANCEL_UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Bỏ qua')]";

    public static final String FORM_UPDATE_INFO = "//form[@class ='form-verify-account-info']";

    public static final String SELECTED_DAY_DROP_DOWN = "//input[@placeholder ='Ngày']";
    public static final String SELECTED_DAY_ITEM = "//input[@placeholder ='Ngày']/parent::div/following-sibling::div/div[contains(@class,'selectize-dropdown')]//div[contains(@class,'option')]";
    public static final String SELECTED_MONTH_DROP_DOWN = "//input[@placeholder ='Tháng']";
    public static final String SELECTED_MONTH_ITEM = "//input[@placeholder ='Tháng']/parent::div/following-sibling::div/div[contains(@class,'selectize-dropdown')]//div[contains(@class,'option')]";
    public static final String SELECTED_YEAR_DROP_DOWN = "//input[@placeholder ='Năm']";
    public static final String SELECTED_YEAR_ITEM = "//input[@placeholder ='Năm']/parent::div/following-sibling::div/div[contains(@class,'selectize-dropdown')]//div[contains(@class,'option')]";

    public static final String GENDER_OPTION = "//input[@id = '%s']/following-sibling::label";
    public static final String COUNTRY_DROPDOWN = "//select[@id ='select-country']/following-sibling::div";
    public static final String COUNTRY_ITEM = "//input[@id = 'select-country-selectized']/parent::div/following-sibling::div//div[@class= 'option']";
    public static final String UPLOAD_BUTTON = "//button[contains(text(),'Cập nhật')]";

    public static final String React_Button = "//span[@class = 'fbUI fbUI__rac js-reaction fbUI__rac--']";
}
