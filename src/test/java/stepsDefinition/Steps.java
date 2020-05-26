package stepsDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import utilities.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Steps extends BaseClass {

    @Before
    public void setUp() throws IOException {

        logger = Logger.getLogger("nopCommerce");
        PropertyConfigurator.configure("Log4j.properties");

        configProp = new Properties();
        FileInputStream file = new FileInputStream("config.properties");
        configProp.load(file);

        String br = configProp.getProperty("browser");
            if (br.equals("chrome")){
                System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromePath"));
                driver = new ChromeDriver();

            }else if (br.equals("firefox")){
                System.setProperty("webdriver.gecko.driver", configProp.getProperty("fireFoxPath"));
                driver = new FirefoxDriver();

            }else if(br.equals("ie")){
                System.setProperty("webdriver.chrome.driver", configProp.getProperty("iePath"));
                driver = new InternetExplorerDriver();

            }
                logger.info("======Launching browser====");

    }

    @Given("User Launch Chrome browser")
    public void user_Launch_Chrome_browser(){
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
        logger.info("======Entering Email & Password=====");
        lp.setUserEmail(email);
        lp.setUserPassword(password);
    }

    @When("Click on Login")
    public void click_on_Login() throws InterruptedException {
        logger.info("======Logged in Successful=====");
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
        logger.info("======Logout Successful=======");
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
        logger.info("======Clicking Customer Menu=====");
        Thread.sleep(3000);
        addCus.clickCustomerMenu();
    }

    @When("User click on Customers Menu Item")
    public void user_click_on_Customers_Menu_Item() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("======Clicking Customer Menu Item=====");
        addCus.clickCustomerMenuItems();
    }
    @When("Click on Add new button")
    public void click_on_Add_new_button() {
        logger.info("======Adding New Customer=====");
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
        //Thread.sleep(2000);
        //addCus.setNewsLetter("Your store name");
        addCus.setCustomerRole("Guest");
        addCus.setVendors("Vendor 2");
        addCus.setContent("This is for testing purpose-----");

    }

    @When("Click on Save button")
    public void click_on_Save_button() throws InterruptedException {
        logger.info("======Clicking Save Button=======");
        addCus.clickSave();
        Thread.sleep(3000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String message) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
    }
    //Steps for Searching By Email Id
    @When("Enter customer Email")
    public void enter_customer_Email() {
        logger.info("======Entering Customer Email=====");
        sp = new SearchCustomerPage(driver);
        sp.setTxtEmail("epYoN@gmail.com");
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        logger.info("======Clicking Search Button=====");
        sp.clickSearch();
        Thread.sleep(5000);
    }

    @Then("User should found email in the search table")
    public void user_should_found_email_in_the_search_table() {
        boolean status = sp.searchByEmail("epYoN@gmail.com");
        //Assert.assertEquals(status,true);
    }

    //Search by Customer Name
    @When("Enter customer FirstName")
    public void enter_customer_FirstName() {
        logger.info("======Entering Customer FirstName=====");
        sp = new SearchCustomerPage(driver);
        sp.setFirstName("sharif");
    }

    @When("Enter customer LastName")
    public void enter_customer_LastName() {
        logger.info("======Entering Customer LastName=====");
        sp.setLastName("uddin");
    }

    @Then("User should found Name in the search table")
    public void user_should_found_Name_in_the_search_table() {
        sp.searchByName("sharif uddin");

    }

}
