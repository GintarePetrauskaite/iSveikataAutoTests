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




    public void selectSpecialization(String value){
        new Select(selectSpecialization).selectByValue(value);
    }
    public void selectCompanyType(String value){
        new Select(selectCompanyType).selectByValue(value);
    }


    public SystemUserRegistrationFormPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public String getUrl() {
        return URL;
    }
}
