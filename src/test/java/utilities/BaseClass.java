package utilities;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCus;

    public static String randomEmail(){
        String randomEm = RandomStringUtils.randomAlphabetic(5);
        return (randomEm);
    }
}
