package testcases.Editor;

import actions.PageObject.EditorDemo.postConfig;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NormalPost extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    postConfig editorDemoPage;

    @Parameters("browser")
    @BeforeTest
    public void preconditionTest(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver("https://test-newsfeed.hahalolo.com/editor/index.html");
//        editorDemoPage = PageGenerator.getEditorDemoPage(driver);
    }
    @Test
    public void TC_01_CHECK_DEFAULT_PLACEHOLDER(){
        editorDemoPage.setTimeDelay(2);
        verifyTrue(editorDemoPage.checkPlaceholderPostNormalDisplay("style", "block"));
        editorDemoPage.enterToPostContent("haha");
        verifyTrue(editorDemoPage.checkPlaceholderPostNormalDisplay("style", "none"));
        editorDemoPage.clickResetButton();
        verifyTrue(editorDemoPage.checkPlaceholderPostNormalDisplay("style", "block"));
    }
//    @Test
//    public void TC_02_CHECK_OPTION_CHANGE_LANGUAGE(){
//        editorDemoPage.checkContentWithLanguage();
//        editorDemoPage.changeLanguage();
//        editorDemoPage.checkContentWithLanguage();
//
//    }
}
