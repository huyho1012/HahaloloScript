package interfaces.Common;

public class MediaManagerUI {
    public static String TITLE_MEDIA_MANAGER = "//h6[@id='modal-title__media']";
    public static String UPLOAD_IMAGE_TO_MEDIA_BUTTON = "";
    public static String SELECT_IMAGE_BUTTON = "//button[@id='js-btn-select']";
    public static String IMAGE_ROOT_ITEM ="//i[@class = 'fas fa-plus']/ancestor::div[@id= 'view-media-manager']/div[2]//div[@class = 'media-list__item'][position()='%s']";

    public static String REMOVE_IMAGE_ROOT_ITEM = "//i[@class = 'fas fa-plus']/ancestor::div[@id= 'view-media-manager']/div[2]//div[@class = 'media-list__item'][position()='%s']//span[@class = 'media-remove-btn']";

}
