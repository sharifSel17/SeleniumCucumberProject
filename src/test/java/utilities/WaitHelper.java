package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public WebDriver dr;

    public WaitHelper(WebDriver driver ){
        dr = driver;
        PageFactory.initElements(driver,this);
    }
    public void waitForElement(WebElement element, long timeOutSeconds){
        WebDriverWait wait = new WebDriverWait(dr,timeOutSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

}
