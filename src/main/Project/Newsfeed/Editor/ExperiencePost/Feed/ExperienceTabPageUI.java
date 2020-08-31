package Newsfeed.Editor.ExperiencePost.Feed;

public class ExperienceTabPageUI {
    public static final String SEARCH_FORM_EXPERIENCE = "//button[@id ='js_btn_search_exp']";
    public static final String EXPERIENCE_SEARCH_FIELD = "//input[@class='form-control form-search-exp__input']";

    public static final String LIST_EXPERIENCE_SEARCH_RESULT = "//div[@id='js_list_search_exp']";
    public static final String ICON_LOADING_RESULT = "//div[@id='js_loading_search_exp']/div[@class = 'spinner-border text-secondary']";
    public static final String ITEM_RESULT = "//div[@id='js_list_search_exp']//div[contains(@class,'menu__item ')][position()='%s']";
    public static final String MESSAGE_NOT_FOUND_SEARCH_EXP = "//div[@id = 'js_data_not_found_exp']";

    public static final String RESULT_EXP = "//h4[@class = 'img-cover-label__item'][contains(text(),'%s)]";
}
