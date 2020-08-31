package Newsfeed.PersonalWall.About.BasicInfoTab;

import Newsfeed.PersonalWall.About.Common.PersonalAbout;
import org.openqa.selenium.WebDriver;

public class BasicInfoPageObject extends PersonalAbout {
    WebDriver driver;
    public BasicInfoPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
