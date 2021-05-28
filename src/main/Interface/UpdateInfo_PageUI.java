package Interface;

public class UpdateInfo_PageUI {
    public static final String DROPDOWN_DAY = "//select[@name = 'day']/following-sibling::div//input";
    public static final String DROPDOWN_MONTH= "//select[@name = 'month']/following-sibling::div//input";
    public static final String DROPDOWN_YEAR = "//select[@name = 'year']/following-sibling::div//input";

    public static final String FEMALE_GENDER = "//input[@id = 'female']/following-sibling::label" ;
    public static final String MALE_GENDER = "//input[@id = 'male']/following-sibling::label" ;
    public static final String OTHER_GENDER = "//input[@id = 'other']/following-sibling::label" ;
    public static final String DROPDOWN_COUNTRY = "//select[@id = 'select-country']/following-sibling::div" ;
    public static final String BUTTON_UPDATE = "//button[contains(@data-bind,'onSaveInfo')]";
    public static final String OPTION_COUNTRY = " //select[@id = 'select-country']/following-sibling::div//div[@class='option']";
}
