package PageObject;

import common.GeneralHandler.AbstractPage;
import org.openqa.selenium.WebDriver;

public class StartUp_PageObject extends AbstractPage {
    WebDriver driver;
    public StartUp_PageObject(WebDriver webDriver){
        driver = webDriver;
    }
    public String getContent(){
        String test = driver.getCurrentUrl();
       System.out.println(test);
        return test;
    }
}
