package Newsfeed.Common.UpdateInfo;

public class FirstUpdatePopUpUI {
    public static final String FORM_UPDATE_INFO = "//form[@class ='form-verify-account-info']";



    public static final String BUTTON_UPDATE ="//div[@id='modal-addition-user-info']//button[contains(text(),'Cập nhật')]";
    public static final String BUTTON_CANCEL ="//div[@id='modal-addition-user-info']//button[contains(text(),'Bỏ qua')]";

    public static final String DATE_SELECTED_DROPDOWN = "//input[@placeholder ='%s']";
    public static final String DATE_SELECTED_ITEM = "//input[@placeholder ='%s']/parent::div/following-sibling::div//div[@class='option']";

    public static final String GENDER_OPTION = "//input[@id = '%s']/following-sibling::label";
    public static final String COUNTRY_DROPDOWN = "//select[@id ='select-country']/following-sibling::div";
    public static final String COUNTRY_ITEM = "//input[@id = 'select-country-selectized']/parent::div/following-sibling::div//div[@class= 'option']";

}
