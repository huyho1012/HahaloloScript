package interfaces.Newsfeed.PageFeed;

public class NewsFeedPageIU {
    public static final String NORMAL_POST_FUNCTION = "//a[@id='act-nav-single']";
    public static final String EXPERIENCE_POST_FUNCTION = "//a[@id='act-nav-addvance']";

    public static final String UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Cập nhật')]";
    public static final String CANCEL_UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Bỏ qua')]";


    public static final String SELECTED_DAY_DROP_DOWN = "//select[@name= 'day']";
    public static final String SELECTED_DAY_ITEM = "//select[@name= 'day']//following-sibling::div/div[contains(@class,'selectize-dropdown')]//div[contains(@class,'option')]";
    public static final String SELECTED_MONTH_DROP_DOWN = "//select[@name= 'month']";
    public static final String SELECTED_MONTH_ITEM = "//select[@name= 'month']//following-sibling::div/div[contains(@class,'selectize-dropdown')]//div[contains(@class,'option')]";
    public static final String SELECTED_YEAR_DROP_DOWN = "//select[@name= 'year']";
    public static final String SELECTED_YEAR_ITEM = "//select[@name= 'year']//following-sibling::div/div[contains(@class,'selectize-dropdown')]//div[contains(@class,'option')]";


}
