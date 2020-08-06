package actions.PageObject.newsfeed.PageFeed;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import interfaces.Newsfeed.PageFeed.ExperienceTabPageUI;
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
