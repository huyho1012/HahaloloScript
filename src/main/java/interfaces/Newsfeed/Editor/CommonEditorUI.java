package interfaces.Newsfeed.Editor;

public class CommonEditorUI {

    public static final String NORMAL_POST = "//a[@id ='act-nav-single']";
    public static final String DEFAULT_SCOPE = "//span[contains(@data-bind,'scopeSelect().name')]";

    public static final String NORMAL_POST_CONTENT = "//div[@class = 'note-editable']";


    public static final String LIST_IMAGE_ATTACHMENT = "//div[@class = 'editor-attachment__item']";
    public static final String ADD_MORE_IMAGE = "//div[@class = 'editor-attachment__add-photo']";
    public static final String LOADING_PROCESSING_BAR = "";



    public static final String TAGGING_FUNCTION = "//i[@class = 'ic ic-user-tag']";

    public static final String ADD_LOCATION_FUNCTION = "//i[@class= 'ic ic-location']";
    public static final String ADD_IMAGE_FUNCTION = "//i[@class= 'ic ic-photos']";

    public static final String ADD_FELLING_FUNCTION = "//i[@class= 'ic ic-grin']";
    public static final String FEELING_FUNCTION = "//div[@id= 'js-feeling-activity']";
    public static final String SEARCH_USER_FEELING = "//div[@id = 'js_tagger_input_feeling']/input";
    public static final String FEELING_ITEM = "//div[contains(@class,'feeling-item')]//div[contains(text(),'%s')]";
    public static final String DISPLAYED_FEELING = "//span[@class = 'tag-area__emotion']/a[contains(text(),'%s')]";
    public static final String ICON_REMOVE_FELLING = "//span[@class= 'tagger__remove']";

    public static final String EMOJI_INSERT_FUNCTION = "//i[@class= 'ic ic-smile']";
    public static final String EMOJI_POP_UP = "//div[@id = 'js-popup-emoji']";
    public static final String EMOJI_ITEM = "//a[@class = 'emoji-list__item'][last()]";

    public static final String SEARCH_USER_TAGGING = "//div[@id = '_input_friends']/input";
    public static final String USER_TAGGING_LIST = "//div[@id= 'js-list-user-tagin']";
    public static final String USER_ITEM = "//div[contains(@class,'list-item-user')][position()='%s']";
    public static final String DISPLAYED_TAGGER_USER = "//span[@class = 'tag-area__friends']//a";
    public static final String ICON_REMOVE_TAGGER_USER = "//span[@class ='tagger-list'][position()='%s']//a[@class= 'tagger-list__remove']";

    public static final String SEARCH_LOCATION = "//div[@id= '_input_locations']/input";
    public static final String LOCATION_LIST = "//div[@id='js-list-location-tagin']";
    public static final String LOCATION_ITEM = "//div[contains(@class,'list-item-location')]//b[contains(text(),'%s')]";
    public static final String DISPLAYED_LOCATION = "//span[@class = 'tag-area__locate']/a[contains(text(),'%s')]";
    public static final String ICON_REMOVE_LOCATION = "//span[contains(text(),'%s')]/following-sibling::a[@class= 'tagger-list__remove']";


    public static final String SCOPE_POST_DROPDOWN = "//div[@class='dropdown dropdown-privacy']";
    public static final String SCOPE_POST_ITEM = "//div[@class='dropdown dropdown-privacy']//div[contains(@class,'dropdown-item')]/span";
    public static final String CREATE_BUTTON = "//button[@id ='btn-save-post']";
    public static final String BUTTON_CLOSE_EDITOR = "//button[@id ='js_btn_nav_editor_close']";


    public static final String TITLE_MODEL_CONFIRM_CLOSE_POST = "//div[@id ='js-modal-closePost']//h6";
    public static final String CONTENT_MODEL_CONFIRM_CLOSE_POST = "//div[@id ='js-modal-closePost']//div[@class= 'modal-body']/div";
    public static final String BACK_TO_EDITOR = "//button[contains(text(),'Quay lại bài viết')]";
    public static final String CONFIRM_CLOSE_EDITOR = "//button[contains(text(),'Rời khỏi')]";
    public static final String CANCEL_CLOSE_EDITOR = "//div[@id= 'js-modal-closePost']//button[@class = 'close']";

    public static final String BUTTON_REMOVE_ITEM_IMAGE = "//div[@class='editor-attachment__item'][position()='%s']//i[contains(@class,'attachment__remove')]";
    public static final String ITEM_IMAGE = "//div[@class='editor-attachment__item'][position()='%s']";


    public static final String MESSAGE_VALIDATION_POST_NORMAL = "//div[@class = 'modal fade modal__delete-common show']//div[@class = 'modal-body']/p";
    public static final String BUTTON_OK = "//button[text()='Đồng ý']";

    // Popup Confirm Cancel Editor
    public static final String CONFIRM_CANCEL_CHANGE_POPUP = "";
}
