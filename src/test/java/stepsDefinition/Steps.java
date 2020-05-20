package stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import utilities.BaseClass;

public class Steps extends BaseClass {

    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }

    @When("User open URL {string}")
    public void user_open_URL(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        lp.setUserEmail(email);
        lp.setUserPassword(password);
    }

    @When("Click on Login")
    public void click_on_Login() throws InterruptedException {
        lp.submit();
        Thread.sleep(3000);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }else {
            Assert.assertEquals(title,driver.getTitle());
        }
    }

    @When("User click on Log out link")
    public void user_click_on_Log_out_link() throws InterruptedException {
        lp.logout();
    }

    @Then("Page Title should be {string}")
    public void page_Title_should_be(String title) {

    }
    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    //customer feature steps definition

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() {
        addCus = new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCus.getPageTitle());

    }

    @When("User click on Customers Menu")
    public void user_click_on_Customers_Menu() throws InterruptedException {
        Thread.sleep(3000);
        addCus.clickCustomerMenu();
    }

    @When("User click on Customers Menu Item")
    public void user_click_on_Customers_Menu_Item() throws InterruptedException {
        Thread.sleep(2000);
        addCus.clickCustomerMenuItems();
    }
    @When("Click on Add new button")
    public void click_on_Add_new_button() {
        addCus.clickAddBtn();
    }

    @Then("Customer can view and Add new customer page")
    public void customer_can_view_and_Add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCus.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = randomEmail()+"@gmail.com";
        addCus.setEmail(email);
        addCus.setPassword("adbc123");
        addCus.setFirstName("sharif");
        addCus.setLastName("uddin");
        addCus.setGender("Male");
        addCus.setDob("10/20/2019");
        addCus.setCompanyName("Toyota");
        addCus.setCustomerRole("Guest");
        addCus.setVendors("Vendor 2");
        addCus.setContent("This is for testing purpose-----");

    }

    @When("Click on Save button")
    public void click_on_Save_button() throws InterruptedException {
        addCus.clickSave();
        Thread.sleep(3000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
    }

}
