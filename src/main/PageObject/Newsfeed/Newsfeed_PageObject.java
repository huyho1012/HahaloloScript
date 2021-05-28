package PageObject.Newsfeed;

import common.GeneralHandler.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Newsfeed_PageObject extends AbstractPage {
    WebDriver driver;
    UpdateInfo_PageObject updateInfoPage;
    public Newsfeed_PageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void updateNewInfo(String day, String month, String year){
        updateInfoPage = new UpdateInfo_PageObject(driver);
        updateInfoPage.chooseDay(day);
        updateInfoPage.chooseMonth(month);
        updateInfoPage.chooseYear(year);
        updateInfoPage.chooseGender("Female");
        updateInfoPage.chooseNationality("Afghanistan");
        updateInfoPage.clickButtonUpdateNewInfo();
    }
}
