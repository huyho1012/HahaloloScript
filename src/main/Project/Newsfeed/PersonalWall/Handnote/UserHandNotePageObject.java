package Newsfeed.PersonalWall.Handnote;

import Newsfeed.HeaderMenu.HeaderMenu;
import Newsfeed.PersonalWall.PersonalCommonUI;
import org.openqa.selenium.WebDriver;

public class UserHandNotePageObject extends HeaderMenu{
    WebDriver driver;
    public UserHandNotePageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkHandnoteTourTabIsDisplay(String username) {
        return getTextOfElement(driver, PersonalCommonUI.PERSONAL_NAME).contains(username)
                && getTextOfElement(driver, UserHandnoteUI.TITTLE_HAND_NOTES).contains("Sổ tay")
                && checkIsDisplayedElement(driver,UserHandnoteUI.TAB_TOUR_HAND_NOTES);

    }
}
