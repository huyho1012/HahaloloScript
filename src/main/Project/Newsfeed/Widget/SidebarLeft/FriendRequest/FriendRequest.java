package Newsfeed.Widget.SidebarLeft.FriendRequest;

import CommonHelper.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class FriendRequest extends AbstractPage {
WebDriver driver;

    public void viewMoreListFriendRequest(){
        waitElementToVisible(driver,FriendRequestUI.VIEW_LIST_REQUEST_BUTTON);
        clickToElement(driver,FriendRequestUI.VIEW_LIST_REQUEST_BUTTON);
    }

    public void viewMutualFriendPopup(){
        waitElementToVisible(driver,FriendRequestUI.VIEW_MUTUAL_LIST);
        clickToElement(driver,FriendRequestUI.VIEW_MUTUAL_LIST);
    }


    public boolean checkMutualFriendPopupDisplay(){
        waitElementToVisible(driver,FriendRequestUI.MUTUAL_FRIEND_POPUP);
        return checkIsDisplayedElement(driver,FriendRequestUI.MUTUAL_FRIEND_POPUP);
    }

    public void clickToButtonOnFriendRequest(String indexRequest, String buttonName){
        waitElementToVisible(driver,FriendRequestUI.TYPE_BUTTON,indexRequest,buttonName);
        clickToElement(driver,FriendRequestUI.TYPE_BUTTON,indexRequest,buttonName);
    }
    public boolean checkButtonIsDisplayed(String indexRequest, String buttonName){
        return checkIsDisplayedElement(driver,FriendRequestUI.TYPE_BUTTON, indexRequest, buttonName);
    }

    public String getUsernameOfRequest(String indexRequest){
        return getTextOfElement(driver,FriendRequestUI.FULL_NAME_OF_REQUEST,indexRequest);
    }
}
