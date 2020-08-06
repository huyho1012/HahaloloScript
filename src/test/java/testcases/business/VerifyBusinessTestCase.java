package testcases.business;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class VerifyBusinessTestCase {
    WebDriver driver;
    BusinessPage business;
    @Test
    public void resend(){
        business=  new BusinessPage();
        business.SendVerifyRequestWithTypeBusi("hahalolo","hahalolo","hahalolo","1012166","Huy","Ho Chi Minh City, Vietnam","11111","0936709449","hahalolo@gmail.com","hahalolo");
    }

}
