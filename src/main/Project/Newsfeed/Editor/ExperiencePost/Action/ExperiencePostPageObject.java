package Newsfeed.Editor.ExperiencePost.Action;

import MediaManager.MediaManagerUI;
import Editor.Common.CommonEditorUI;
import Newsfeed.Editor.Common.FunctionPageObject;
import org.openqa.selenium.WebDriver;

public class ExperiencePostPageObject extends FunctionPageObject {
    WebDriver driver;
    public ExperiencePostPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void updateCoverOfPostExperience(WebDriver driver, String coverImageURL){
//        clickToElement(driver, );
//        uploadOneFileByAutoIT(driver,coverImageURL);
    }
    public void enterTitleOfPostExperience(String titleEXp){
        waitElementToVisible(driver, ExperiencePostUI.EXPERIENCE_TITLE);
        sendKeyToElement(driver, ExperiencePostUI.EXPERIENCE_TITLE, titleEXp);
    }

    public void inputContentOfPostExperience(String contentExp){
        waitElementToVisible(driver, ExperiencePostUI.EXPERIENCE_CONTENT);
        sendKeyToElement(driver, ExperiencePostUI.EXPERIENCE_CONTENT, contentExp);
    }

    public void uploadImageByHaloManager(){
        waitElementToClickAble(driver, CommonEditorUI.ADD_IMAGE_FUNCTION);
        clickToElement(driver, CommonEditorUI.ADD_IMAGE_FUNCTION);
        waitElementToVisible(driver, MediaManagerUI.TITLE_MEDIA_MANAGER);
        clickToElement(driver,MediaManagerUI.IMAGE_ROOT_ITEM,"1");
        clickToElement(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
    }

    public void removeCoverExperience(){
        waitElementToClickAble(driver, ExperiencePostUI.REMOVE_COVER_ICON);
        clickToElement(driver, ExperiencePostUI.REMOVE_COVER_ICON);
    }

    public String getLabelOfUploadCoverFunction(WebDriver driver){
        waitElementToClickAble(driver, ExperiencePostUI.UPLOAD_COVER_FUNCTION);
        return getTextOfElement(driver, ExperiencePostUI.UPLOAD_COVER_FUNCTION);
    }

    public String getPlaceholderOfTitleExperience(WebDriver driver){
        waitElementToVisible(driver, ExperiencePostUI.EXPERIENCE_TITLE);
        return getAttributeOfElement(driver, ExperiencePostUI.EXPERIENCE_TITLE,"placeholder");
    }
    public String getPlaceholderOfContentExperience(WebDriver driver){
        waitElementToVisible(driver, ExperiencePostUI.EXPERIENCE_CONTENT_PLACEHOLDER);
        return getTextOfElement(driver, ExperiencePostUI.EXPERIENCE_CONTENT_PLACEHOLDER);
    }
}

