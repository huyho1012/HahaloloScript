package actions.common.Function;


import actions.PageObject.Backend.BackendLoginPageObject;
import actions.PageObject.Backend.backendDashboardPageObject;
import actions.PageObject.Censor.AccountManager.CensorAccountList;
import actions.PageObject.Censor.CensorHomePage;
import actions.PageObject.Censor.CensorLogin;
import actions.PageObject.business.Business.BusinessDashboard;
import actions.PageObject.newsfeed.AccountSetting.NewsFeedAccSettingGeneral;
import actions.PageObject.newsfeed.PageFeed.*;
import actions.PageObject.newsfeed.PageFeed.PostFunction.EditorFunction;
import actions.PageObject.newsfeed.PersonalWall.Handnote.NewsFeedHandnoteTour;
import actions.PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import actions.PageObject.newsfeed.Starting.NewsFeedLogin;
import actions.PageObject.newsfeed.Starting.NewsFeedVerifyAccount;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static NewsFeedVerifyAccount getVerifyAccountPage (WebDriver driver){
        return new NewsFeedVerifyAccount(driver);
    }
    public static NewsFeedExperience getExperienceFeed(WebDriver driver){
        return new NewsFeedExperience(driver);
    }
    public static NewsFeedLogin getLoginPage(WebDriver driver){
        return new NewsFeedLogin(driver);
    }
    public static NewsFeedFlight getFlightFeed(WebDriver driver){
        return new NewsFeedFlight(driver);
    }
    public static NewsFeedHotel getHotelFeed(WebDriver driver){
        return new NewsFeedHotel(driver);
    }
    public static NewsFeedShopping getShoppingFeed(WebDriver driver){
        return new NewsFeedShopping(driver);
    }
    public static NewsFeedHomepage getNewsFeedPage(WebDriver driver){
        return new NewsFeedHomepage(driver);
    }
    public static NewsFeedTour getTourFeed(WebDriver driver){
        return new NewsFeedTour(driver);
    }
    public static NewsFeedHandnoteTour tourHandNotePage(WebDriver driver){
        return new NewsFeedHandnoteTour(driver);
    }
    public static NewsFeedAccSettingGeneral getAccountSettingPage(WebDriver driver){
        return new NewsFeedAccSettingGeneral(driver);
    }
    public static BusinessDashboard getBusinessDashboardPage(WebDriver driver){
        return new BusinessDashboard(driver);
    }
    public static PersonalTimelinePageObject getPersonalTimeLinePage(WebDriver driver){
        return new PersonalTimelinePageObject(driver);
    }
    // Khởi tạo model Editor
    public static EditorFunction openNormalPostEditor(WebDriver driver){
        return new EditorFunction(driver);
    }
    public static EditorFunction openExperiencePostEditor(WebDriver driver){
        return new EditorFunction(driver);
    }

    public static BackendLoginPageObject getLoginBackendPage(WebDriver driver){
        return new BackendLoginPageObject(driver);
    }
    public static backendDashboardPageObject getBackendDashboardPage(WebDriver driver){
        return new backendDashboardPageObject(driver);
    }

    public static CensorLogin getCensorLoginPage(WebDriver driver){
        return new CensorLogin(driver);
    }
    public static CensorHomePage getCensorHomePage(WebDriver driver){
        return new CensorHomePage(driver);
    }

    public static CensorAccountList getAccountManagerList(WebDriver driver){
        return new CensorAccountList(driver);
    }
}

