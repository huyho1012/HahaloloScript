package interfaces.Newsfeed.Editor;

public class EditorUI {
    public static final String EXPERIENCE_POST = "//a[@id ='act-nav-addvance']";
    public static final String NORMAL_POST = "//a[@id ='act-nav-single']";

    public static final String NORMAL_POST_CONTENT = "//div[@class = 'note-editable']";
    public static final String EXP_POST_CONTENT = "//div[@class = 'note-editable']/p";

    public static final String LIST_IMAGE_ATTACHMENT = "//div[@class = 'editor-attachment__item']";
    public static final String ADD_MORE_IMAGE = "//div[@class = 'editor-attachment__add-photo']";
    public static final String LOADING_PROCESSING_BAR = "";

    public static final String EXP_POST_TITLE = "//input[@id = 'js-title-advance']";
    public static final String UPLOAD_COVER = "//div[@id= 'js-cover-editor-upload']";
    public static final String UPLOAD_COVER_ICON = "//div[@id= 'js-cover-toolbar']";
    public static final String REMOVE_COVER_ICON = "//i[@class='far fa-trash-alt']";

    public static final String TAGGING_FUNCTION = "//i[@class = 'ic ic-user-tag']";
    public static final String EMOJI_INSERT_FUNCTION = "//i[@class= 'ic ic-smile']";
    public static final String ADD_LOCATION_FUNCTION = "//i[@class= 'ic ic-location']";
    public static final String ADD_IMAGE_FUNCTION = "//i[@class= 'ic ic-photos']";
    public static final String ADD_FELLING_FUNCTION = "//i[@class= 'ic ic-grin']";
    public static final String POST_SCOPE = "//div[@class='dropdown dropdown-privacy']";
    public static final String SCOPE_ITEM = "//div[@class='dropdown dropdown-privacy']//div[contains(@class,'dropdown-item')]/span";
    public static final String CREATE_BUTTON = "//button[@id ='btn-save-post']";
    public static final String CLOSE_MODEL_BUTTON = "//button[@id ='js_btn_nav_editor_close']";


    public static final String TITLE_MODEL_CONFIRM_CLOSE_POST = "//div[@id ='js-modal-closePost']//h6";
    public static final String CONTENT_MODEL_CONFIRM_CLOSE_POST = "//div[@id ='js-modal-closePost']//div[@class= 'modal-body']/div";
    public static final String BACK_TO_EDITOR = "//button[contains(text(),'Quay lại bài viết')]";
    public static final String CONFIRM_CLOSE_EDITOR = "//button[contains(text(),'Rời khỏi')]";
    public static final String CANCEL_CLOSE_EDITOR = "//div[@id= 'js-modal-closePost']//button[@class = 'close']";

}
