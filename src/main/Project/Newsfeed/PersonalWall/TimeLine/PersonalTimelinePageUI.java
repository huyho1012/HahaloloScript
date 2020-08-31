package Newsfeed.PersonalWall.TimeLine;

public class PersonalTimelinePageUI {

    public static final String BUTTON_EDIT = "//div[@class ='body-binding-post'][contains(text(),'%s')]/ancestor::div[@class = 'post-body']/preceding-sibling::div//a[@class = 'post-author'][contains(text(),'%s')]/ancestor::div[@class ='post-head__content']/following-sibling::div//div[contains(@data-bind,'editPost')]" ;
    public static final String DIRECT_POST_WITH_CONTENT_AND_AUTHOR= "//div[@class ='body-binding-post'][contains(text(),'%s')]/ancestor::div[@class = 'post-body']/preceding-sibling::div//a[@class = 'post-author'][contains(text(),'%s')]";

}
