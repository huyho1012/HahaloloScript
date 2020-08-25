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
        return getTextOfElement(driver, PersonalCommonUI.PERSONAL_NAME).equals(username) && checkIsSelectedElement(driver, UserHandnoteUI.TITTLE_HANDNOTE) && checkIsSelectedElement(driver,UserHandnoteUI.TITLE_TAB_TOUR_HANDNOTE);

    }
}
