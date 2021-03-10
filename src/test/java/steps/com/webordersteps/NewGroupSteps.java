package steps.com.webordersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.com.weborderpages.GroupOrderPage;
import pages.com.weborderpages.HomePage;
import pages.com.weborderpages.LoginPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;

public class NewGroupSteps {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    GroupOrderPage groupOrderPage;

    @Given("user is on WebOrder home page")
    public void user_is_on_web_order_home_page() {
        driver= Driver.getDriver();
        loginPage=new LoginPage(driver);
        driver.navigate().to(ConfigReader.getProperty("webOrderUrl"));
        loginPage.login(ConfigReader.getProperty("webOrderUsername"),ConfigReader.getProperty("webOrderPassword"));
    }
    @When("user selects {string} option")
    public void user_selects_option(String text) {
        homePage=new HomePage(driver);
        BrowserUtils.selectByText(homePage.deliveryOptions, text);
    }
    @When("user is on the group order page")
    public void user_is_on_the_group_order_page() {
        homePage.groupOrder.click();
        homePage.nextButton.click();
    }
    @Then("user sends invitees note {string}")
    public void user_sends_invitees_note(String note) {
        groupOrderPage=new GroupOrderPage(driver);
        groupOrderPage.sendInviteeNote(note);
    }
    @Then("user send invite list {string} and {string}")
    public void user_send_invite_list_and(String person1, String person2) {
        groupOrderPage.sendInviteeList(person1+","+person2);
        groupOrderPage.clickCreateGroup();
    }
    @Then("user validates {string} text")
    public void user_validates_text(String expectedText) throws InterruptedException {
        Thread.sleep(500);
        String actualText=groupOrderPage.viewGroupOrderHeader.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Then("user validates total participant is {int}")
    public void user_validates_total_participant_is(Integer int1) {
        Integer participantNumber=groupOrderPage.getParticipantNumber();
        Assert.assertEquals(int1,participantNumber);
    }
}
