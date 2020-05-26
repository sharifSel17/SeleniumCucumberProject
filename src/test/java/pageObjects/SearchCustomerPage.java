package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver dr;
    WaitHelper waitHelper;

    public SearchCustomerPage(WebDriver driver ){
        dr = driver;
        PageFactory.initElements(dr,this);
        waitHelper = new WaitHelper(dr);
    }
    @FindBy(how = How.ID,using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.ID,using = "SearchFirstName")
    @CacheLookup
    WebElement txtFName;


    @FindBy(how = How.ID,using = "SearchLastName")
    @CacheLookup
    WebElement txtLName;

    @FindBy(how = How.ID,using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement dropDob;

    @FindBy(how = How.ID,using = "SearchDayOfBirth")
    @CacheLookup
    WebElement dropDd;

    @FindBy(how = How.ID,using = "SearchCompany")
    @CacheLookup
    WebElement companyName;

    @FindBy(how = How.XPATH,using = "//div[@class='k-multiselect-wrap k-floatwrap']")
    @CacheLookup
    WebElement customerRole;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Administrators')]")
    @CacheLookup
    WebElement listAdministrators;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Registered')]")
    @CacheLookup
    WebElement listRegistered;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Guests')]")
    @CacheLookup
    WebElement listGuests;

    @FindBy(how = How.XPATH,using = "//li[contains(text(),'Vendors')]")
    @CacheLookup
    WebElement listVendors;

    @FindBy(how = How.ID,using = "search-customers")
    @CacheLookup
    WebElement searchCustomer;


    @FindBy(how = How.ID,using = "//table[@role='grid']")
    @CacheLookup
    WebElement tableSearchResult;

    @FindBy(how = How.ID,using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(how = How.ID,using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.ID,using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;

    public void setTxtEmail(String email){
        waitHelper.waitForElement(txtEmail,10);
        txtEmail.clear();;
        txtEmail.sendKeys(email);
    }
    public void setFirstName(String fName){
        waitHelper.waitForElement(txtFName,10);
        txtFName.clear();;
        txtFName.sendKeys(fName);
    }
    public void setLastName(String lName){
        waitHelper.waitForElement(txtLName,10);
        txtLName.clear();;
        txtLName.sendKeys(lName);
    }
    public void clickSearch(){
        searchCustomer.click();
        waitHelper.waitForElement(searchCustomer,20);
    }
    public int getNoOfRows(){
        return (tableRows.size());
    }
    public int getNoOfCols(){
        return (tableColumns.size());
    }
    public boolean searchByEmail(String em){
        boolean flag = false;
        for (int i=1;i<=getNoOfRows();i++){
            String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailId);
            if (emailId.equals(em)){
                flag=true;
            }
        }
        return flag;
    }


    public boolean searchByName(String Name){
        boolean flag = false;
        for (int i=1;i<=getNoOfRows();i++){
            String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
            String names[] = name.split(" ");
            if (names[0].equals(Name) && names[1].equals(Name)){
                flag=true;
            }
        }
        return flag;
    }
}
