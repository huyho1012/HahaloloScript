package CommonHelper.Function;
import About.DetailsAboutYou.DetailsAboutYouPageObject;
import About.LivingPlaceTab.PlaceLivingPageObject;
import About.WorkAndEducation.WorkAndEducationPageObject;
import Backend.Dashboard.BackendDashboardPageObject;
import Business.Business.Dashboard.BusinessDashboard;
import Business.Business.Overview.BusinessOverviewPageObject;
import Censor.AccountManager.CensorAccountList;
import Censor.Dashboard.CensorDashboard;
import Newsfeed.Common.UpdateInfo.FirstUpdateInfo;
import Newsfeed.Editor.NormalPost.NormalPostEditor;
import Newsfeed.Editor.ExperiencePost.Feed.NewsFeedExperience;
import Newsfeed.Flight.NewsFeedFlight;
import Newsfeed.Hotel.NewsFeedHotel;
import Newsfeed.PersonalWall.About.BasicInfoTab.BasicInfoPageObject;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.PersonalWall.Friends.PersonalFriend;
import Newsfeed.PersonalWall.Haha.PersonalHaha;
import Newsfeed.PersonalWall.Handnote.UserHandNotePageObject;
import Newsfeed.PersonalWall.Photo.PersonalPhoto;
import Newsfeed.PersonalWall.Reviews.PersonalReview;
import Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import Newsfeed.PersonalWall.Video.PersonalVideo;
import Newsfeed.Shop.NewsFeedShopping;
import Newsfeed.TabFeed.NewsFeedTab;
import Newsfeed.Tour.NewsFeedTour;
import StartingApp.Login.*;
import StartingApp.Register.VerifyAccountPageObject;
import Newsfeed.UserSetting.PageObject.GeneralSettingAccount;
import Newsfeed.Editor.ExperiencePost.ExperienceEditor;
import ForgotPassword.ForgotPassWordPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    // Khởi tạo Newsfeed Start App
    public static LoginNewsfeed createLoginNewsfeedPage(WebDriver driver){
        return new LoginNewsfeed(driver);
    }
    public static ForgotPassWordPageObject getForgotPassWord (WebDriver driver){
        return  new ForgotPassWordPageObject(driver);
    }
    public static VerifyAccountPageObject createVerifyAccountPage(WebDriver driver){
        return new VerifyAccountPageObject(driver);
    }
    public static NewsFeedExperience createTabExperienceFeed(WebDriver driver){
        return new NewsFeedExperience(driver);
    }

    public static NewsFeedFlight createTabFlightFeed(WebDriver driver){
        return new NewsFeedFlight(driver);
    }
    public static NewsFeedHotel createTabHotelFeed(WebDriver driver){
        return new NewsFeedHotel(driver);
    }
    public static NewsFeedShopping createTabShopFeed(WebDriver driver){
        return new NewsFeedShopping(driver);
    }
    public static NewsFeedTab getNewsFeedPage(WebDriver driver){
        return new NewsFeedTab(driver);
    }

    public static BusinessDashboard getBusinessDashboardPage(WebDriver driver){
        return new BusinessDashboard(driver);
    }

    public static LoginBackend getLoginBackendPage(WebDriver driver){
        return new LoginBackend(driver);
    }
    // Censor
    public static BackendDashboardPageObject getBackendDashboardPage(WebDriver driver){
        return new BackendDashboardPageObject(driver);
    }
    public static LoginCensor getCensorLoginPage(WebDriver driver){
        return new LoginCensor(driver);
    }
    public static CensorAccountList getAccountManagerList(WebDriver driver){
        return new CensorAccountList(driver);
    }

    // Khởi tạo tab cho Personal Wall
    public static UserHandNotePageObject createUserHandNotePage(WebDriver driver){
        return new UserHandNotePageObject(driver);
    }
    public static PersonalTimelinePageObject getPersonalTimeLinePage(WebDriver driver){
        return new PersonalTimelinePageObject(driver);
    }
    public static PersonalFriend getPersonalFriendTab(WebDriver driver){
        return new PersonalFriend(driver);
    }
    public static PersonalVideo getPersonalVideoTab(WebDriver driver){
        return new PersonalVideo(driver);
    }
    public static PersonalPhoto getPersonalPhoto(WebDriver driver){
        return new PersonalPhoto(driver);
    }
    public static PersonalReview getPersonalReview(WebDriver driver){
        return new PersonalReview(driver);
    }
    public static PersonalHaha getPersonalHahaTab(WebDriver driver){
        return new PersonalHaha(driver);
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
    public static LoginWallet createWalletLoginPage(WebDriver driver){
        return new LoginWallet(driver);
    }
    // Account Setting

    // Business
    public static BusinessOverviewPageObject createBusinessOverviewPage(WebDriver driver){
        return new BusinessOverviewPageObject(driver);
    }

    public static GeneralSettingAccount createAccountSettingGeneralTab(WebDriver driver) {
        return new GeneralSettingAccount(driver);
    }

    // Hàm khởi tạo Model Editor
    public static ExperienceEditor openExperienceEditor (WebDriver driver){
        return new ExperienceEditor(driver);
    }
    public static NormalPostEditor openNormalPostEditor(WebDriver driver){
        return new NormalPostEditor(driver);
    }

    public static CensorDashboard createCensorDashboardPage(WebDriver driver) {
        return new CensorDashboard(driver);
    }

    public static NewsFeedTab createTabNewsfeed(WebDriver driver) {
        return new NewsFeedTab(driver);
    }

    public static NewsFeedTour createTabTourFeed(WebDriver driver) {
        return new NewsFeedTour(driver);
    }

    public static FirstUpdateInfo createUpdateInfoPopup(WebDriver driver) {
        return new FirstUpdateInfo(driver);
    }
}

