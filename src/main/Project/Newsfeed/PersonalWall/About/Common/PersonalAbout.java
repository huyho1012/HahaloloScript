package About.Common;

import About.BasicInfoTab.BasicInfoPageObject;
import About.DetailsAboutYou.DetailsAboutYouPageObject;
import About.OverviewTab.OverviewPageObject;
import About.LivingPlaceTab.PlaceLivingPageObject;
import About.WorkAndEducation.WorkAndEducationPageObject;
import Function.AbstractPage;
import Function.PageGenerator;
import PersonalWall.About.Common.PersonalAboutUI;
import org.openqa.selenium.WebDriver;

public class PersonalAbout extends AbstractPage {
    WebDriver driver;
    public PersonalAbout(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkDataValueAccount(WebDriver driver, String valuePer, String valueData){
        waitElementToVisible(driver, PersonalAboutUI.VALUE_OF_PERSONAL,valuePer);
        if(getTextOfElement(driver,PersonalAboutUI.VALUE_OF_PERSONAL,valuePer).equals(valueData)){
            return true;
        }else
            return false;
    }

    public OverviewPageObject clickToOverViewTab(){
        waitElementToVisible(driver,PersonalAboutUI.OVERVIEW_TAB);
        clickToElement(driver,PersonalAboutUI.OVERVIEW_TAB);
        return PageGenerator.getPersonalOverviewTab(driver);
    }

    public WorkAndEducationPageObject clickToWorkAndEduTab(){
        waitElementToVisible(driver,PersonalAboutUI.EDUCATION_WORK_TAB);
        clickToElement(driver,PersonalAboutUI.EDUCATION_WORK_TAB);
        return PageGenerator.getPersonalEducationTab(driver);
    }

    public BasicInfoPageObject clickToBasicInfoTab(){
        waitElementToVisible(driver,PersonalAboutUI.BASIC_INFO_TAB);
        clickToElement(driver,PersonalAboutUI.BASIC_INFO_TAB);
        return PageGenerator.getPersonalAboutBasicInfo(driver);
    }

    public PlaceLivingPageObject clickToPlaceLivingTab(){
        waitElementToVisible(driver,PersonalAboutUI.LIVING_PLACE_TAB);
        clickToElement(driver,PersonalAboutUI.LIVING_PLACE_TAB);
        return PageGenerator.getPersonalPlaceLivingTab(driver);
    }
    public DetailsAboutYouPageObject clickToDetailAboutYouTab(){
        waitElementToVisible(driver,PersonalAboutUI.DETAILS_ABOUT_TAB);
        clickToElement(driver,PersonalAboutUI.DETAILS_ABOUT_TAB);
        return PageGenerator.getPersonalDetailAboutTab(driver);
    }
}
