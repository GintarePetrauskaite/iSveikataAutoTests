package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientRegistrationFormPage extends WebPage {

    private static String URL = "http://localhost:3000/#/admin/create/patient";

    @FindBy(css = "div[class='panel-heading'] h4")
        private WebElement patientFormTitle;
    @FindBy(css = "input[name='patientId']")
        private WebElement patientIdInput;
    @FindBy(css = "input[name='firstName']")
        private WebElement firstNameInput;
    @FindBy(css = "input[name='lastName']")
        private WebElement lastNameInput;
    @FindBy(css = "input[type='password']")
        private WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
        private WebElement sumbitButton;
    @FindBy(css = "div.alert.alert-success > strong")
        private WebElement successMessage;

    public PatientRegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public void fillInPatientRegFormCorrectly(String patientId, String firstName, String lastName){
        patientIdInput.sendKeys(patientId);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.click();
        sumbitButton.click();
    }
    public WebElement GetSuccessMessage() {
        return successMessage;
    }
    public WebElement GetPageFormTitle(){
        return patientFormTitle;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
