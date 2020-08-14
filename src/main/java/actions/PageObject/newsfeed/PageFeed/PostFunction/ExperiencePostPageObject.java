package actions.PageObject.Newsfeed.PageFeed.PostFunction;

import interfaces.Common.MediaManagerUI;
import interfaces.Newsfeed.Editor.EditorUI;
import interfaces.Newsfeed.TabFeed.PostModelUI;
import org.openqa.selenium.WebDriver;

public class ExperiencePostPageObject extends EditorPostPageObject{
    WebDriver driver;
    public ExperiencePostPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkToExperienceEditorDisplay() {
        waitElementToVisible(driver, PostModelUI.UPLOAD_COVER_EXPERIENCE_BUTTON);
        return checkIsDisplayedElement(driver,PostModelUI.UPLOAD_COVER_EXPERIENCE_BUTTON);
    }

    public void updateCoverOfPostExperience(){

    }
    public void enterTitleOfPostExperience(String titleEXp){
        waitElementToVisible(driver, EditorUI.EXP_POST_TITLE);
        sendKeyToElement(driver, EditorUI.EXP_POST_TITLE, titleEXp);
    }

    public void inputContentOfPostExperience(String contentExp){
        waitElementToVisible(driver,EditorUI.EXP_POST_CONTENT);
        sendKeyToElement(driver, EditorUI.EXP_POST_CONTENT,contentExp);
    }

    public void insertImageTExpContent(){
        waitElementToClickAble(driver,EditorUI.ADD_IMAGE_FUNCTION);
        waitElementToVisible(driver, MediaManagerUI.TITLE_MEDIA_MANAGER);
        clickToElement(driver,MediaManagerUI.IMAGE_ROOT_ITEM,"1");
        clickToElement(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
    }

    public void removeCoverImage(){
        waitElementToClickAble(driver,EditorUI.REMOVE_COVER_ICON);
        clickToElement(driver,EditorUI.REMOVE_COVER_ICON);
    }

    public void chooseImageToInsert(String indexImage) {
        waitElementToVisible(driver, MediaManagerUI.TITLE_MEDIA_MANAGER);
        waitElementToVisible(driver,MediaManagerUI.IMAGE_ROOT_ITEM,indexImage);
        clickToElement(driver,MediaManagerUI.IMAGE_ROOT_ITEM,indexImage);
        setTimeDelay(1);
        waitElementToVisible(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
        clickToElement(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
    }

}

