package steps.com.productssteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.com.productspages.OrderPage;
import pages.com.productspages.ProductsLoginPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class ProductsSteps {
    WebDriver driver;
    ProductsLoginPage loginPage;
    OrderPage orderPage;

    @Given("user is on product website home page")
    public void user_is_on_product_website_home_page() {
        driver= Driver.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        loginPage=new ProductsLoginPage(driver);
        loginPage.login(ConfigReader.getProperty("productsUsername"),ConfigReader.getProperty("productsPassword"));
    }
    @Then("user enters product info {string} and {string}")
    public void user_enters_product_info_and(String productName, String quantity) {
        orderPage=new OrderPage(driver);
        orderPage.clickOrder();
        orderPage.sendProductInfo(productName,quantity);
    }
    @Then("user enters the address info {string}, {string}, {string}, {string}, {string}")
    public void user_enters_the_address_info(String customerName, String street, String city, String state, String zip) {
        orderPage.sendAddressInfo(customerName,street,city,state,zip);
    }
    @Then("user enters card info {string}, {string}, {string}")
    public void user_enters_card_info(String cardType, String cardNumber, String expiteDate) {
        orderPage.sendPaymentInfo(cardType,cardNumber,expiteDate);
        orderPage.clickProcess();
    }
    @Then("user validates success message")
    public void user_validates_success_message() {
        String actualMessage=orderPage.getMessageText();
        Assert.assertEquals("New order has been successfully added.",actualMessage);
    }
    @Then("user validates product details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_validates_product_details(String productName, String quantity, String name, String street, String city, String state, String zip, String cardType, String cardNumber, String expireDate) {
        orderPage.clickAllOrders();
        List<WebElement> details= orderPage.productInfo;

        Assert.assertEquals(details.get(1).getText().trim(),name);
        Assert.assertEquals(details.get(2).getText().trim(),productName);
        Assert.assertEquals(details.get(3).getText().trim(),quantity);
        Assert.assertEquals(details.get(5).getText().trim(),street);
        Assert.assertEquals(details.get(6).getText().trim(),city);
        Assert.assertEquals(details.get(7).getText().trim(),state);
        Assert.assertEquals(details.get(8).getText().trim(),zip);
        Assert.assertEquals(details.get(9).getText().trim(),cardType);
        Assert.assertEquals(details.get(10).getText().trim(),cardNumber);
        Assert.assertEquals(details.get(11).getText().trim(),expireDate);
    }
}
