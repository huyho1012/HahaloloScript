package Newsfeed.Editor.ExperiencePost.Feed;

import Newsfeed.Common.FeedCommon;
import Newsfeed.Editor.ExperiencePost.Feed.ExperienceTabPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewsFeedExperience extends FeedCommon {
    WebDriver driver;
    public NewsFeedExperience(WebDriver webDriver){
       driver = webDriver;
   }

   public boolean checkExperienceTabSelected(){
       waitElementToVisible(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
       return checkIsDisplayedElement(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
   }

   public void openExperienceSearch(){
        waitElementToClickAble(driver,ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
        clickToElement(driver,ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
   }
    public void inputDataToSearchExperience(String keyWord, String){
        waitElementToVisible(driver,ExperienceTabPageUI.EXPERIENCE_SEARCH_FIELD);
        sendKeyToElement(driver,ExperienceTabPageUI.EXPERIENCE_SEARCH_FIELD,keyWord);
    }

    public void chooseExperience(String indexExp){
        waitElementToInvisible(driver,ExperienceTabPageUI.ICON_LOADING_RESULT);
        clickToElement(driver,ExperienceTabPageUI.ITEM_RESULT,indexExp);
    }
    public String getTextErrorNoSearchDExpMatch(){
        waitElementToInvisible(driver,ExperienceTabPageUI.ICON_LOADING_RESULT);
        return getTextOfElement(driver, ExperienceTabPageUI.MESSAGE_NOT_FOUND_SEARCH_EXP);
    }

    public boolean checkExperienceSearchIsSearchingSuccess(String expPostTitle){
        waitForPageLoading(driver);
        return checkIsDisplayedElement(driver,ExperienceTabPageUI.RESULT_EXP,expPostTitle);
    }
}
