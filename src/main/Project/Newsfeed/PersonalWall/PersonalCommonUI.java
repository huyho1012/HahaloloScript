package Newsfeed.PersonalWall;

public class PersonalCommonUI {

    public static final String PERSONAL_NAME = "//div[@class = 'p-info__name']/span";

    public static final String PERSONAL_INTRODUCE = "//div[@class = 'p-info__desc']/span";
    public static final String CHANGE_COVER = "//div[@id = 'js-timeline-cover']//i[@class='ic ic-camera-white']";
    public static final String CHANGE_AVATAR = "//div[@id = 'js-timeline-avatar']//i[@class='ic ic-camera-white']";
    public static final String CHANGE_COVER_BY_MEDIA = "//div[@id = 'js-timeline-cover']//div[contains(@data-bind,'onSelectCoverFromMediaManager')]";
    public static final String CHANGE_COVER_BY_LOCAL = "//div[@id = 'js-timeline-cover']//div[contains(@data-bind,'onSelectCoverFromLocal')]";
    public static final String COPY_USER_LINK = "//div[@class='p-intro']//i[@class = 'ic ic-link']";
    public static final String EDIT_PROFILE_BUTTON = "//div[@class='p-intro']//i[@class = 'ic ic-user-edit']";

    public static final String PERSONAL_TAB_MENU = "//nav[@class='p-menu']/a[contains(@data-bind,'%s')]";

    //Model Crop Avatar
    public static final String SAVE_AVATAR_CROP_BUTTON = "//button[contains(@data-bind,'onSaveAvatarCropp')]";
    public static final String CROP_AVATAR_POPUP = "//div[@id = 'js_crop_media']";

    public static final String SAVE_COVER_CROP_BUTTON = "//button[@id = 'js-save-cover']";

}
