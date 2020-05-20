package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    public WebDriver dr;
    public AddCustomerPage(WebDriver driver ){
        dr = driver;
        PageFactory.initElements(driver,this);
    }
    By customers_menu = By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
    By customers_menuItem = By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
    By btnAddNew = By.xpath("//a[@class='btn bg-blue']");

    By txtEmail = By.xpath("//input[@id='Email']");
    By texPassword = By.xpath("//input[@id='Password']");
    By fName = By.xpath("//input[@id='FirstName']");
    By lName = By.xpath("//input/[@id='LastName']");
    By rdMaleGender = By.id("Gender_Male");
    By rdFemaleGender = By.id("Gender_Female");
    By DoB = By.xpath("//input[@id='DateOfBirth']");
    By customerRole = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
    By roleAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
    By roleRegister = By.xpath("//li[contains(text(),'Registered')]");
    By roleGuests = By.xpath("//li[contains(text(),'Guests')]");
    By roleVendors = By.xpath("//li[contains(text(),'Vendors')]");

    By listVendors = By.xpath("//*[@id='VendorId']");
    By companyName = By.xpath("//input/[@id='Company']");
    By txtArea = By.xpath("//textarea[@id='AdminComment']");
    By submit = By.xpath("//button[@name='save']");

    public void clickCustomerMenu(){
        dr.findElement(customers_menu).click();
    }
    public void clickCustomerMenuItems(){
        dr.findElement(customers_menuItem).click();
    }
    public void clickAddBtn(){
        dr.findElement(btnAddNew).click();
    }
    public void setEmail(String email){
        dr.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String password){
        dr.findElement(texPassword).sendKeys(password);
    }
    public void setFirstName(String firstName){
        dr.findElement(fName).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        dr.findElement(lName).sendKeys(lastName);
    }
    public void gMale(String male){
        dr.findElement(rdMaleGender).sendKeys(male);
    }
    public void gFemale(String feMale){
        dr.findElement(rdFemaleGender).sendKeys(feMale);
    }
    public void datOfBirth(String dob){
        dr.findElement(DoB).sendKeys(dob);
    }
    public void setCompanyName(String cName){
        dr.findElement(companyName).sendKeys(cName);
    }
    public void setCustomerRole(String role){
        if(!role.equals("Vendors")){
            dr.findElement(By.xpath("//select[@id=\"SelectedCustomerRoleIds\"]/option"));
        }
    }










}
