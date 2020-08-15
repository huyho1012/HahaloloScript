package testcases.newsfeed.PostFunction.NormalPost;

import actions.PageObject.Newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.Newsfeed.PageFeed.PostFunction.NormalPostEditor;
import actions.PageObject.Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import actions.PageObject.Newsfeed.Starting.NewsFeedLogin;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestcaseOfPost extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    NewsFeedLogin loginPage;
    NewsFeedHomepage newsFeedPage;
    NormalPostEditor normalPostEditor;
    PersonalTimelinePageObject perTimelinePage;
    String contentPost = "Hahalolo này còn ai đẹp hơn ta";
    String updateContent = "Xiến chi 19 tủi";
    String authorName = "Chúa Tể Khô";
    String file1 =  "image1.jpg";
    String file2 = "image2.jpg";
    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 01 - Open Browser");
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginPage= PageGenerator.getLoginPage(driver);
        log.info("Precondition - Step 02 - Enter Username");
        loginPage.enterDataToTextBoxField(driver,"identity",GlobalVariables.FEED_EMAIL_ACCOUNT);
        log.info("Precondition - Step 03 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"password",GlobalVariables.FEED_EMAIL_PASSWORD);
        log.info("Precondition - Step 04 - Click Login button");
        loginPage.clickToLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Precondition - Step 05 - Verify Login successfully");
        verifyTrue(newsFeedPage.checkLoginSuccess());
    }
//    @Test
//    public void TC01_Check_Display_of_Editor_Case_New_Post() {
//        log.info("Check Title of post normal");
//        verifyEquals(normalPostEditor.getTitleOfNormalPost(driver),"Tạo bài viết");
//        log.info("Check placeholder of post normal");
//        verifyEquals(normalPostEditor.getPlaceHolderPostNormal(),"Haha, hôm nay bạn thế nào?");
//        log.info("Check status of button Share post");
//        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));
//        log.info("Check default Scope dropdown");
//        verifyEquals(normalPostEditor.getScopeDisplayOnDropdown(driver),"Công khai");
//        log.info("Check function display on post normal");
//        verifyTrue(normalPostEditor.checkFunctionInsertEmojiIsDisplay());
//        verifyTrue(normalPostEditor.checkFunctionTaggingUserIsDisplay());
//        verifyTrue(normalPostEditor.checkFunctionAddLocationIsDisplay());
//        verifyTrue(normalPostEditor.checkFunctionAddImageIsDisplay());
//        verifyTrue(normalPostEditor.checkFunctionAddFeelingIsDisplay());
//    }

//    @Test
//    public void TC02_Check_Action_Close_Normal() {
//
//        normalPostEditor.clickOVerPopup(driver);
//        verifyTrue(newsFeedPage.checkSharePostButtonIsDisplay(driver));
//        log.info("Click close icon when no input");
//        newsFeedPage = normalPostEditor.clickClosePostEditor();
//        verifyFalse(newsFeedPage.checkSharePostButtonIsDisplay());
//
//        log.info("Reload Page To create new TC");
//        newsFeedPage.refreshPage(driver);
//
//    }
//    @Test
//    public void TC03_Button_Share_Check_Status_Button(){
//        log.info("Step 1 - Check default status button");
//        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));
//
//        log.info("Step 1 - Check status button when user input data");
//        normalPostEditor.inputPostNormalContent(driver,contentPost);
//        verifyTrue(normalPostEditor.checkStatusOfShareButton(driver));
//
//        log.info("Step 2 - Check status button when user remove data");
//        normalPostEditor.inputPostNormalContent(driver,"");
//        normalPostEditor.setTimeDelay(2);
//        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));
//
//        log.info("Step 3 - Check status button when user insert emoji");
//        normalPostEditor.insertEmoji(driver,4);
//        verifyTrue(normalPostEditor.checkStatusOfShareButton(driver));
//
//        log.info("Step 3 - Check status button when user add feeling - case noInput");
//        normalPostEditor.chooseFeeling(driver,"thú vị");
//        normalPostEditor.inputPostNormalContent(driver,"");
//        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));
//
//        log.info("Step 4 - Check status button when user add location - case noInput");
//        normalPostEditor.chooseLocationAddress(driver,"Ho Chi Minh City");
//        normalPostEditor.inputPostNormalContent(driver,"");
//        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));
//
//        log.info("Step 5 - Check status button when user tag friend - case noInput");
//        normalPostEditor.chooseUserTagging(driver,"Huy Hồ","1");
//        normalPostEditor.inputPostNormalContent(driver,"");
//        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));
//
//        log.info("Step 6 - Check status button when user add image");
//        normalPostEditor.chooseImageToInsert(driver, file1,file2);
//        normalPostEditor.setTimeDelay(3);
//        verifyTrue(normalPostEditor.checkStatusOfShareButton(driver));
//        normalPostEditor.removeImage(driver);
//        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));
//        normalPostEditor.removeFeeling(driver,"thú vị");
//        normalPostEditor.removeLocation(driver,"Ho Chi Minh City");
//        normalPostEditor.removeOneUserTagging(driver,1);
//        newsFeedPage = normalPostEditor.clickClosePostEditor();
//    }
    @Test
    public void TC04_VALIDATE_POST_CONTENT(){
        log.info("Step 1 - Check post content - Not input");
        log.info("Step 1.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 1.2 - Do not input ");
        normalPostEditor.inputNormalPostContent(driver,"");
        log.info("Step 1.3 - Check status of Share post button");
        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));

        System.out.println("Complete 1");

        log.info("Step 2 - Check post content - Case Input All Whitespace");
        log.info("Step 2.1 - Input content");
        normalPostEditor.inputNormalPostContent(driver,"          ");
        log.info("Step 2.2 - Check status of Share post button");
        verifyFalse(normalPostEditor.checkStatusOfShareButton(driver));

        System.out.println("Complete 2");

        log.info("Step 3 - Check post content - Case > 100000 character");
        log.info("Step 3.1 - Input content");
        normalPostEditor.inputNormalPostContent(driver,randomSentence(10001));
        log.info("Step 3.2 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        log.info("Step 3.3 - Check error message");
        verifyEquals(normalPostEditor.getMessageErrLimitChar(),"Giới hạn tối đa của bài viết là 10000");
        normalPostEditor.clickButtonOk(driver);
        System.out.println("Complete 3");

        log.info("Step 4 - Check post  - Valid content");
        log.info("Step 4.1 - Input valid content");
        normalPostEditor.inputNormalPostContent(driver,contentPost);
        log.info("Step 4.2 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 2.3 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 2.4 - Check post has been created successfully");
        perTimelinePage.checkCreatedPostSuccessfully(driver,"",contentPost);
        log.info("Step 2.5 - Back to newsfeed");
        perTimelinePage.backPreviousPage(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        System.out.println("Complete 4");

        log.info("Step 4 - Check post content -  100000 characters");
        log.info("Step 4.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 4.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,randomSentence(10000));
        log.info("Step 4.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 4.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        perTimelinePage.checkCreatedPostSuccessfully(driver,"",contentPost);
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.backPreviousPage(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 5 - Check post content - one paragraph");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,randomParagraphs(1));
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 3 - Check post content -  >= 2 paragraphs");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,randomParagraphs(2));
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Check post content - HTML code");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,GlobalVariables.HTML_CODE);
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Check post content - Script code");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,GlobalVariables.SCRIPT_CODE);
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Check post content with only Emoji");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input Emoji");
        normalPostEditor.insertEmoji(driver,2);
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Check post content with Content + Emoji");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,contentPost);
        log.info("Step 5.2 - Input Emoji");
        normalPostEditor.insertEmoji(driver,2);
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Check post content - special Character");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,"@@@ $$@ASdas $@# $@34q");
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Check post content - Whitespace before and after");
        log.info("Step 5.1 - Open Normal Post Editor");
        newsFeedPage.clickToNormalPostFunction();
        normalPostEditor = PageGenerator.openNormalPostEditor(driver);
        log.info("Step 5.2 - Input content");
        normalPostEditor.inputNormalPostContent(driver,"  Hahaha Bạn tôi ơi  ");
        log.info("Step 5.3 - Click Share post button");
        normalPostEditor.clickToCreatePost();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 5.4 - Go to Personal Timeline");
        newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        log.info("Step 4.5 - Check post has been created successfully");
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,"",""));
        log.info("Step 4.6 - Back to newsfeed");
        perTimelinePage.clickToLogoHahalolo(driver);
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
    }
//    @Test
//    public void TC_01_CreateNewNormalPost(){
//        log.info("Create Post - Step 01 - Open Editor function");
//        postPage = newsFeedPage.clickToNormalPostFunction();
//        postPage = PageGenerator.openNormalPostEditor(driver);
//
//        log.info("Create Post - Step 02 - Check Editor Post normal display");||||
//        verifyTrue(postPage.checkCreatePostModalIsDisplay());
//
//        log.info("Create Post - Step 03 - Enter content");
//        postPage.inputPostNormalContent(contentPost);
//        postPage.setTimeDelay(1);
//
//        log.info("Create Post - Step 04 - Insert emoji");
//        postPage.chooseFunctionIcon("ic-smile");
//        postPage.insertEmoji(10,"9");
//
//        log.info("Create Post - Step 05 - Insert tagging");
//        postPage.chooseFunctionIcon("ic-user-tag");
//        postPage.chooseUserTagging("Al");
//
//        log.info("Create Post - Step 06 - Insert location");
//        postPage.chooseFunctionIcon("ic-location");
//        postPage.chooseLocationAddress("Ho Chi Minh");
//
//        log.info("Create Post - Step 07 - Insert Image");
//        postPage.chooseFunctionIcon("ic-photos");
//        postPage.uploadMultipleFileByAutoIT(driver,file1);
//        verifyTrue(newsFeedPage.checkAreElementsIsDisplay(driver, PostModelUI.LIST_UPLOADED_IMAGE));
//
//        log.info("Create Post - Step 08 - Insert Feeling");
//        postPage.chooseFunctionIcon("ic-grin");
//        postPage.chooseFeeling("2");
//
//        log.info("Create Post - Step 09 - Choose a post scope");
//        postPage.clickChooseScopeDropdown("fa-user-friends");
//
//        log.info("Create Post - Step 10 - Click to create post");
//        postPage.clickToSharePostButton();
//        newsFeedPage = PageGenerator.getNewsFeed(driver);
//
//        log.info("Create Post - Step 11 - Click to go homepage");
//        newsFeedPage.setTimeDelay(1);
//        perTimelinePage = newsFeedPage.clickToUserHomePage();
//        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
//        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,authorName,contentPost));
//   }
//    @Test
//    public void NormalPost_03_Check_Button_Share_Post_When_User_Do_Not_Input_Content(){
//        log.info("Check Share Post button - Step 01 - Open Editor function");
//        newsFeedPage.clickToNormalPostFunction();
//        postPage = PageGenerator.openNormalPostEditor(driver);
//
//        log.info("Check Button Share Post - Step 02 - Verify Normal Post Display");
//        verifyTrue(postPage.checkNormalPostEditorDisplay());
//
//        log.info("Check Button Share Post - Step 03 - Check button Share Post disable");
//        verifyTrue(postPage.checkSharedButtonIsDisable());
//
//        log.info("Check Button Share Post - Step 04 - Close Post Normal Editor");
//        postPage.closeNormalPostEditor();
//    }
//   @Test
//    public void TC02_Edit_Normal_Post(){
//       log.info("Edit Normal Post - Step 01 - Click edit Personal Wall");
//       postPage.openFunction(driver,contentPost,authorName,"fa-edit");
//       verifyTrue(postPage.checkEditPostModalIsDisplay());
//
//       log.info("Edit Normal Post - Step 03 - Update content");
//       newsFeedPage.setTimeDelay(2);
//       postPage.inputPostNormalContent(updateContent);
//       postPage.clickChooseScopeDropdown("fa-globe-asia");
//
//       log.info("Edit Normal Post - Step 04 - Edit post");
//       perTimelinePage = postPage.clickToSharePostButton();
//       perTimelinePage= PageGenerator.getPersonalTimeLinePage(driver);
//
//       log.info("Edit Normal Post - Step 04 - Check Edit post with new content ");
//       verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,authorName,updateContent));
//   }
//   @Test
//   public void TC_03_Remove_Post() {
//       log.info("Edit Normal Post - Step 01 - Click remove post");
//       postPage.openFunction(driver, contentPost, authorName, "fa-trash-alt");
//       verifyTrue(postPage.checkConfirmDeletePostPopup());
//       perTimelinePage= postPage.clickDeleteButton();
//       verifyFalse(perTimelinePage.checkCreatedPostSuccessfully(driver,authorName,updateContent));
//   }
//    @Test
//    public void createNewExperiencePost(){
//        log.info("Create Post - Step 01 - Open Experience post");
//        newsFeedPage.clickToExperienceEditor();
//        verifyTrue(newsFeedPage.checkToExperienceEditorDisplay());
//
//        log.info("Create Post - Step 02 - Upload cover Experience post");
//        newsFeedPage.clickUploadCoverButton();
//        newsFeedPage.uploadMultipleFileByAutoIT(driver,file2);
//        newsFeedPage.setTimeDelay(4);
//
//        log.info("Create Post - Step 03 - Enter a Title Experience");
//        newsFeedPage.inputExperienceTitle("Test Experience post");
//        newsFeedPage.setTimeDelay(1);
//
//        log.info("Create Post - Step 04 - Create Experience content ");
//        newsFeedPage.inputExperienceContent(randomParagraphs(5));
//        newsFeedPage.setTimeDelay(1);
//
//        log.info("Create Post - Step 05 - Insert emoji");
//        newsFeedPage.clickToPostFunction("ic-smile");
//        newsFeedPage.insertEmoji("9");
//
//        log.info("Create Post - Step 06 - Insert Image");
//        newsFeedPage.clickToPostFunction("ic-photos");
//        newsFeedPage.chooseImageToInsert("1");
//
//        log.info("Create Post - Step 07 - Insert tagging");
//        newsFeedPage.clickToPostFunction("ic-user-tag");
//        newsFeedPage.chooseUserTagging("Al");
//
//        log.info("Create Post - Step 08 - Insert location");
//        newsFeedPage.clickToPostFunction("ic-location");
//        newsFeedPage.chooseLocationAddress("Ho Chi Minh");
//
//        log.info("Create Post - Step 09 - Choose a post scope");
//        newsFeedPage.clickChooseScopeDropdown("fa-user-friends");
//
//        log.info("Create Post - Step 09 - Click to create post");
//        newsFeedPage.clickToSharePostButton();
//    }
//    public void Edit_Normal_Post_With_Not_Image(){
//        perTimelinePage = newsFeedPage.clickToUserHomePage();
//        perTimelinePage.openFunction(driver,contentPostNormal,authorName,"fa-edit");
//        perTimelinePage.clickPostMenu();
//        perTimelinePage.chooseEditPostNormal();
//        perTimelinePage.editPostContent();
//        perTimelinePage.editTagging();
//        perTimelinePage.editLocation();
//        perTimelinePage.insertNewEmoji();
//        perTimelinePage.changePostScope();
//        perTimelinePage.saveChangePost();
//    }


}
