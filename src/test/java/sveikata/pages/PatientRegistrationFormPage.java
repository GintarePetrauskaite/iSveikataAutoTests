package sveikata.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import sveikata.models.Credentials;

public class PatientRegistrationFormPage extends WebPage {

    private static String URL = "http://localhost:8080/#/admin/create/patient";

    @FindBy(css = "div[class='panel-heading'] h4")
    private WebElement patientFormTitle;
    @FindBy(id = "patientId")
    private WebElement patientIdInput;
    @FindBy(css = "input[name='firstName']")
    private WebElement firstNameInput;
    @FindBy(css = "input[name='lastName']")
    private WebElement lastNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement sumbitButton;
    @FindBy(css = "div.alert.alert-success > strong")
    private WebElement successMessage;
    @FindBy(css = "div.alert.alert-danger > strong")
    private WebElement errorMessage;
    @FindBy(css = "div.form-group.has-feedback.has-error > div > span.help-block")
    private WebElement checkIdMsg;
    @FindBy(id = "logout")
    private WebElement logout;

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
    public Credentials registerNewPatient(String id, String firstName, String lastName){
        patientIdInput.sendKeys(id);
        patientIdInput.click();
        firstNameInput.sendKeys(firstName);
        firstNameInput.click();
        lastNameInput.sendKeys(lastName);
        lastNameInput.click();
        passwordInput.click();
        Credentials credentials = new Credentials();
        credentials.setPassword(getPassword());
        credentials.setUsername(getId());
        sumbitButton.click();
        return credentials;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public String getPassword(){
        passwordInput.click();
        return passwordInput.getAttribute("value");
    }

    public String getId() {
        return patientIdInput.getAttribute("value");
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
    public WebElement getPageFormTitle(){
        return patientFormTitle;
    }
    public void fillInPatientId(String patientId){
        patientIdInput.sendKeys(patientId);
    }
    public void fillInFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }
    public void fillInLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }
    public void clickPasswordInput(){
        passwordInput.click();
    }
    public void clickSubmitButton(){
        sumbitButton.click();
    }

    public WebElement getCheckIdMsg() {
        return checkIdMsg;
    }

    public void logout(){
        logout.click();
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
