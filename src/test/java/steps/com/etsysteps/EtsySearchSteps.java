package steps.com.etsysteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.com.etsypages.EtsyHomePage;
import utils.BrowserUtils;
import utils.Driver;

public class EtsySearchSteps {

    WebDriver driver;
    EtsyHomePage etsyHomePage;

    @Before
    public void beforeScenario(){
        // it will run before each scenario
        System.out.println("Before annotation");
    }
    @Before("@tc2")
    public void conditionalHook(){
        System.out.println("Conditional annotation");
    }

    @After
    public void afterScenario(Scenario scenario){
        // it will run after each scenario
        System.out.println("After annotation");
        if (scenario.isFailed()){
            BrowserUtils.takeScreenshot();
        }

    }

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        driver= Driver.getDriver();
        driver.get(url);
    }
    @When("user search with {string}")
    public void user_search_with(String searchValue) {
        etsyHomePage=new EtsyHomePage(driver);
        etsyHomePage.sendSearchKey(searchValue);
    }
    @Then("user should see the title {string}")
    public void user_should_see_the_title(String title) {
        Assert.assertEquals("Validation of Title",title,driver.getTitle());
    }
}
