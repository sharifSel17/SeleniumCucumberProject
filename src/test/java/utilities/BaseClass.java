package utilities;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.logging.Logger;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCus;
    public SearchCustomerPage sp;
    public static Logger logger;

    public static String randomEmail(){
        String randomEm = RandomStringUtils.randomAlphabetic(5);
        return (randomEm);
    }
}
