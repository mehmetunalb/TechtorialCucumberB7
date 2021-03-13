package steps.com.herokuappsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.com.herokuapppages.FramePage;
import utils.Driver;

public class FrameSteps {
    WebDriver driver;
    FramePage framePage;
    @Given("user opens herokuapp frames page")
    public void user_opens_herokuapp_frames_page() {
        driver=Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Then("user sends paragraph")
    public void user_sends_paragraph(String docString) {
        framePage=new FramePage(driver);
        driver.switchTo().frame("mce_0_ifr");
        framePage.sendKey(docString);
    }
}
