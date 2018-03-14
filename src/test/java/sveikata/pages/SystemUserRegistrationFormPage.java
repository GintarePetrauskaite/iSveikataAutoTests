package sveikata.pages;

import sveikata.models.Credentials;
import sveikata.models.Person;
import sveikata.models.Pharmacist;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SystemUserRegistrationFormPage extends WebPage {

    private static String URL = "http://localhost:8080/#/admin/create/user";

    @FindBy(css = "input[value='doctor']")
    private WebElement radioButtonDoctor;
    @FindBy(css = "input[value='admin']")
    private WebElement radioButtonAdmin;
    @FindBy(css = "input[value='druggist']")
    private WebElement radioButtonDruggist;
    @FindBy(css = "input[name='firstName']")
    private WebElement inputFirstName;
    @FindBy(css = "input[name='lastName']")
    private WebElement inputLastName;
    @FindBy(css = "select[class='form-control']")
    private WebElement selectSpecialization;
    @FindBy(id = "newTitle")
    private WebElement specializationInput;
    @FindBy(css = "button[type='submit']")
    private WebElement buttonSubmit;
    @FindBy(css = "select[name='companyType']")
    private WebElement selectCompanyType;
    @FindBy(css = "input[name='companyName']")
    private WebElement inputCompanyName;
    @FindBy(css = "div[class='alert alert-success'] > strong")
    private WebElement successMsg;
    @FindBy(css = "div[class='alert alert-danger'] > strong")
    private WebElement errorMsg;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "userName")
    private WebElement usernameInput;
    @FindBy(id = "logout")
    private WebElement logout;


    public SystemUserRegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public void registerNewDoctor(String firstName, String lastName, String specialization){
        radioButtonDoctor.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        new Select(selectSpecialization).selectByValue("kita");
        specializationInput.sendKeys(specialization);
        buttonSubmit.click();
    }
    public Credentials registerNewDruggist(String firstName, String lastName, String companyType, String companyName){
        radioButtonDruggist.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        new Select(selectCompanyType).selectByValue(companyType);
        inputCompanyName.sendKeys(companyName);
        Credentials credentials = new Credentials();
        credentials.setPassword(getPassword());
        credentials.setUsername(getUsername());
        buttonSubmit.click();
        return credentials;
    }

    public Credentials registerNewDruggist(Pharmacist pharmacist){
        return registerNewDruggist(
                pharmacist.getFirstName(),
                pharmacist.getLastName(),
                pharmacist.getBusinessType(),
                pharmacist.getFirstName());
    }

    public void registerNewAdmin(Person person){
        radioButtonAdmin.click();
        inputFirstName.sendKeys(person.getFirstName());
        inputLastName.sendKeys(person.getLastName());
        buttonSubmit.click();
    }

    public void logout(){
        logout.click();
    }
    public void chooseDoctorRadioButton(){
        radioButtonDoctor.click();
    }
    public void choosePharmacistRadioButton(){
        radioButtonDruggist.click();
    }
    public void chooseAdminRadioButton(){
        radioButtonAdmin.click();
    }
    public void clickSubmit(){
        buttonSubmit.click();
    }

    public String getPassword(){
        passwordInput.click();
        return passwordInput.getAttribute("value");
    }

    public String getUsername() {
        usernameInput.click();
        return usernameInput.getAttribute("value");
    }

    public WebElement getSuccessMsg() {
        return successMsg;
    }
    public WebElement getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
