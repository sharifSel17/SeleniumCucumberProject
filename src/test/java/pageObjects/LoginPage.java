package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver dr;
    public LoginPage(WebDriver driver ){
        dr = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id="Password")
    @CacheLookup
    WebElement password;

    @FindBy(xpath="//input[@value='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText="Logout")
    @CacheLookup
    WebElement lnkLogout;

    public void setUserEmail(String userEmail){
        txtEmail.clear();;
        txtEmail.sendKeys(userEmail);
    }
    public void setUserPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }
    public void submit(){
        btnLogin.click();
    }
    public void logout(){
        lnkLogout.click();
    }
}
