package EditorPro;


import actions.common.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class postConfig extends AbstractPage {
    WebDriver driver;
    public postConfig(WebDriver webDriver){
        driver = webDriver;
    }

   public boolean checkPlaceholderPostNormalDisplay(String attributeName, String value){
       return getAttributeOfElement(driver,EditorDemoUI.PLACEHOLDER,attributeName).contains(value);
   }
    public void clickResetButton() {
        waitElementToVisible(driver, EditorDemoUI.RESET_BUTTON);
        clickToElement(driver,EditorDemoUI.RESET_BUTTON);
    }

    public void enterToPostContent(String postContent) {
        waitElementToVisible(driver, EditorDemoUI.CONTENT_TEXT_AREA);
        sendKeyToElement(driver,EditorDemoUI.CONTENT_TEXT_AREA,postContent);
    }

}
