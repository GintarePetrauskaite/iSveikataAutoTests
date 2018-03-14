package sveikata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends WebPage {

    @FindBy(id = "adminCreatePatient")
    private WebElement registerPatientLink;
    @FindBy(id = "adminRegisterPatient")
    private WebElement registerPatientButton;

    @FindBy(id = "adminCreateUser")
    private WebElement registerSystemUserLink;
    @FindBy(id = "adminRegisterUser")
    private WebElement registerUserButton;

    @FindBy(id = "adminBind")
    private WebElement assignDoctorToPatientLink;

    @FindBy(css = "a[class='#admin/password']")
    private WebElement changePasswordLink;

    @FindBy(id = "logout")
    private WebElement logout;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void goToSystemUserRegistrationForm(){
        registerUserButton.click();
    }
    public void goToPatientRegistrationForm(){
        registerPatientButton.click();
    }
    public void goToAssignDoctorToPatientForm(){
        assignDoctorToPatientLink.click();
    }
    public void goToChangePasswordForm(){
        changePasswordLink.click();
    }
    public void logout(){
        logout.click();
    }

    @Override
    public String getUrl() {
        return null;
    }
}
