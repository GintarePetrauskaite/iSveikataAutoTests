package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SystemUserRegistrationFormPage extends WebPage {

    private static String URL = "http://localhost:3000/#/admin/create/user";

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

    @FindBy(css = "button[type='submit']")
        private WebElement buttonSubmit;
    @FindBy(css = "select[name='companyType']")
        private WebElement selectCompanyType;
    @FindBy(css = "input[name='companyName']")
        private WebElement inputCompanyName;

    public SystemUserRegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public void registerNewDoctor(String firstName, String lastName, String specialization){
        radioButtonDoctor.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        new Select(selectSpecialization).selectByValue(specialization);
        buttonSubmit.click();
    }
    public void registerNewDruggist(String firstName, String lastName, String companyType){
        radioButtonDruggist.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        new Select(selectCompanyType).selectByValue(companyType);
        buttonSubmit.click();
    }
    public void registerNewAdmin(String firstName, String lastName){
        radioButtonAdmin.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        buttonSubmit.click();
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
