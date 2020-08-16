package CommonHelper.Function;
import About.BasicInfoTab.BasicInfoPageObject;
import About.DetailsAboutYou.DetailsAboutYouPageObject;
import About.LivingPlaceTab.PlaceLivingPageObject;
import About.OverviewTab.OverviewPageObject;
import About.WorkAndEducation.WorkAndEducationPageObject;
import Backend.Dashboard.BackendDashboardPageObject;
import Business.Business.Overview.BusinessOverviewPageObject;
import Censor.Dashboard.CensorDashboardPageObject;
import Newsfeed.Editor.NormalPost.NormalPostEditor;
import Newsfeed.Editor.ExperiencePost.Feeds.NewsFeedExperience;
import Newsfeed.Flight.Feed.NewsFeedFlight;
import Newsfeed.Hotel.NewsFeedHotel;
import Newsfeed.Shop.NewsFeedShopping;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Login.PageObject.*;
import StartingApp.Register.PageObject.VerifyAccountPageObject;
import Newsfeed.UserSetting.PageObject.GeneralSettingPageObject;
import Newsfeed.Editor.ExperiencePost.Action.ExperiencePostPageObject;
import Handnote.UserHandNotePageObject;
import TimeLine.PersonalTimelinePageObject;
import ForgotPassword.ForgotPassWordPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    // Khởi tạo Newsfeed Start App
    public static NewsfeedLoginPageObject getLoginPage(WebDriver driver){
        return new NewsfeedLoginPageObject(driver);
    }
    public static ForgotPassWordPageObject getForgotPassWord (WebDriver driver){
        return  new ForgotPassWordPageObject(driver);
    }
    public static VerifyAccountPageObject getVerifyAccountPage (WebDriver driver){
        return new VerifyAccountPageObject(driver);
    }
    public static NewsFeedExperience getExperienceFeed(WebDriver driver){
        return new NewsFeedExperience(driver);
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
    public static NewsFeedTabPageObject getNewsFeedPage(WebDriver driver){
        return new NewsFeedTabPageObject(driver);
    }
    public static NewsFeedTour getTourFeed(WebDriver driver){
        return new NewsFeedTour(driver);
    }

    public static BusinessDashboard getBusinessDashboardPage(WebDriver driver){
        return new BusinessDashboard(driver);
    }
    public static PersonalTimelinePageObject getPersonalTimeLinePage(WebDriver driver){
        return new PersonalTimelinePageObject(driver);
    }
    public static BackendLoginPageObject getLoginBackendPage(WebDriver driver){
        return new BackendLoginPageObject(driver);
    }
    // Censor
    public static BackendDashboardPageObject getBackendDashboardPage(WebDriver driver){
        return new BackendDashboardPageObject(driver);
    }
    public static CensorLoginPageObject getCensorLoginPage(WebDriver driver){
        return new CensorLoginPageObject(driver);
    }
    public static CensorAccountList getAccountManagerList(WebDriver driver){
        return new CensorAccountList(driver);
    }

    // Khởi tạo tab cho Personal Wall
    public static UserHandNotePageObject createUserHandnotePage(WebDriver driver){
        return new UserHandNotePageObject(driver);
    }

    // Hàm khảo tạo các tab Personal - About
    public static OverviewPageObject getPersonalOverviewTab(WebDriver driver){
        return new OverviewPageObject(driver);
    }
    public static WorkAndEducationPageObject getPersonalEducationTab(WebDriver driver){
        return new WorkAndEducationPageObject(driver);
    }
    public static PlaceLivingPageObject getPersonalPlaceLivingTab(WebDriver driver){
        return new PlaceLivingPageObject(driver);
    }
    public static DetailsAboutYouPageObject getPersonalDetailAboutTab(WebDriver driver){
        return new DetailsAboutYouPageObject(driver);
    }
    public static BasicInfoPageObject getPersonalAboutBasicInfo(WebDriver driver) {
        return new BasicInfoPageObject(driver);
    }

    // Hàm khảo tạo Trang Login - Wallet
    public static WalletLoginPageObject createWalletLoginPage(WebDriver driver){
        return new WalletLoginPageObject(driver);
    }
    // Account Setting

    // Business
    public static BusinessOverviewPageObject createBusinessOverviewPage(WebDriver driver){
        return new BusinessOverviewPageObject(driver);
    }

    public static GeneralSettingPageObject createAccountSettingGeneralTab(WebDriver driver) {
        return new GeneralSettingPageObject(driver);
    }

    // Hàm khởi tạo Model Editor
    public static ExperiencePostPageObject openExperienceEditor (WebDriver driver){
        return new ExperiencePostPageObject(driver);
    }
    public static NormalPostEditor openNormalPostEditor(WebDriver driver){
        return new NormalPostEditor(driver);
    }

    public static CensorDashboardPageObject createCensorDashboardPage(WebDriver driver) {
        return new CensorDashboardPageObject(driver);
    }

    public static NewsFeedTabPageObject createNewsfeedTab(WebDriver driver) {
        return new NewsFeedTabPageObject(driver);
    }
}
