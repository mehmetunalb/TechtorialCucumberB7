package pages.com.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GroupOrderPage {

    public GroupOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "InviteNote")
    public WebElement inviteeNote;

    @FindBy(id = "InviteList")
    public WebElement inviteeList;

    @FindBy(id = "createGroupOrder")
    public WebElement createGroupOrder;

    @FindBy(className = "topBannerHeader")
    public WebElement viewGroupOrderHeader;

    @FindBy(xpath = "//label[.='Total Participants:']/following-sibling::div")
    public WebElement participants;

    public void sendInviteeNote(String note){
        inviteeNote.sendKeys(note);
    }

    public void sendInviteeList(String list){
        inviteeList.sendKeys(list);
    }

    public void clickCreateGroup(){
        createGroupOrder.click();
    }

    public int getParticipantNumber(){
        return Integer.parseInt(participants.getText().trim());
    }
}
