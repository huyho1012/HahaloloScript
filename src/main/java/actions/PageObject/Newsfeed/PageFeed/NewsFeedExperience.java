package actions.PageObject.Newsfeed.PageFeed;

import actions.PageObject.Newsfeed.Common.HeaderMenu;
import interfaces.Newsfeed.TabFeed.ExperienceTabPageUI;
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
