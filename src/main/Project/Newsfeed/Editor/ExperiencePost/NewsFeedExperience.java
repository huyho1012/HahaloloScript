package Newsfeed.Editor.ExperiencePost;

import HeaderMain.HeaderMenu;
import Newsfeed.Editor.ExperiencePost.ExperienceTabPageUI;
import org.openqa.selenium.WebDriver;

public class NewsFeedExperience extends HeaderMenu {
    WebDriver driver;
    public NewsFeedExperience(WebDriver webDriver){
       driver = webDriver;
   }

   public boolean checkExperienceTabSelected(){
       waitElementToVisible(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
       return checkIsDisplayedElement(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
   }
}
