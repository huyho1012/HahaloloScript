package Newsfeed.TabFeed;

import Newsfeed.Common.FeedCommon;
import Newsfeed.Widget.SidebarRight.Footer.Footer;
import org.openqa.selenium.WebDriver;

public class NewsFeedTab extends FeedCommon {

    WebDriver driver;
    public NewsFeedTab(WebDriver webDriver){
        Footer footer = new Footer();
        driver = webDriver;
    }

}
