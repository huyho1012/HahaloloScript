package Newsfeed.Editor.NormalPost;


import Newsfeed.Editor.Common.CommonEditorUI;

public class NormalPostUI {
    public static final String TITLE_POPUP = "//a[@id ='act-nav-single']";
    public static final String POST_CONTENT = "//div[@class = 'note-editable']";
    public static final String LIST_IMAGE_ATTACHMENT = "//div[@class = 'editor-attachment__item']";
    public static final String ADD_MORE_IMAGE = "//div[@class = 'editor-attachment__add-photo']";
    public static final String LOADING_PROCESSING_BAR = "";

    public static final String BUTTON_REMOVE_ITEM_IMAGE = "//div[@class='editor-attachment__item'][position()='%s']//i[contains(@class,'attachment__remove')]";
    public static final String ITEM_IMAGE = "//div[@class='editor-attachment__item'][position()='%s']";
}
