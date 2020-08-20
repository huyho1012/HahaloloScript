package Newsfeed.PersonalWall.TimeLine;

import Newsfeed.HeaderMenu.HeaderMenu;
import MediaManager.MediaManagerUI;
import Newsfeed.PersonalWall.PersonalCommonUI;
import org.openqa.selenium.WebDriver;


public class PersonalCommon extends HeaderMenu {
    WebDriver driver;
    public void clickToTabOnPersonalMenu(WebDriver driver, String tabMenu){
        waitElementToClickAble(driver, PersonalCommonUI.PERSONAL_TAB_MENU,tabMenu);
        clickToElement(driver,PersonalCommonUI.PERSONAL_TAB_MENU, tabMenu);
    }
    public void uploadCoverByLocalImage(WebDriver driver, String urlImage){
        waitElementToClickAble(driver,PersonalCommonUI.CHANGE_COVER);
        clickToElement(driver, PersonalCommonUI.CHANGE_COVER);
        clickToElement(driver,PersonalCommonUI.CHANGE_COVER_BY_LOCAL);
        uploadOneFileByAutoIT(driver,urlImage);
    }
    public void uploadCoverByMediaManager(WebDriver driver, String indexImage){
        waitElementToClickAble(driver,PersonalCommonUI.CHANGE_COVER);
        clickToElement(driver, PersonalCommonUI.CHANGE_COVER);
        clickToElement(driver, PersonalCommonUI.CHANGE_COVER_BY_MEDIA);
        // Thực chọn ảnh trong Media Management
        waitElementToVisible(driver, MediaManagerUI.TITLE_MEDIA_MANAGER);
        clickToElement(driver, MediaManagerUI.IMAGE_ROOT_ITEM, indexImage);
        clickToElement(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
        setTimeDelay(1);
        clickToElement(driver,PersonalCommonUI.SAVE_COVER_CROP_BUTTON);
    }

    public void uploadAvatarByMediaManager(WebDriver driver, String indexImage){
        waitElementToClickAble(driver,PersonalCommonUI.CHANGE_AVATAR);
        clickToElement(driver, PersonalCommonUI.CHANGE_AVATAR);
        // Thực chọn ảnh trong Media Management
        waitElementToVisible(driver, MediaManagerUI.TITLE_MEDIA_MANAGER);
        clickToElement(driver, MediaManagerUI.IMAGE_ROOT_ITEM, indexImage);
        clickToElement(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
        setTimeDelay(1);
        clickToElement(driver,PersonalCommonUI.SAVE_AVATAR_CROP_BUTTON);
    }

    public void copyLinkUserProfile(WebDriver driver){
        clickToElement(driver,"//i[@class ='ic ic-ellipsis-h']");
        clickToElement(driver,PersonalCommonUI.COPY_USER_LINK);
    }
}
