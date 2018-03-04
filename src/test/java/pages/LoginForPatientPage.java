package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForPatientPage extends WebPage {

    @FindBy(css = "input[name='patientId']")
    private WebElement patientIdInput;
    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;
    @FindBy(css = "a[class='#pacientams']")
    private WebElement loginForPatientsLink;

    @FindBy(css = "div[class='alert alert-danger']")
    private WebElement errorMsg;

    public LoginForPatientPage(WebDriver driver) {
        super(driver);
    }

    public void LoginAsPatient(String id, String password){
        patientIdInput.sendKeys(id);
        passwordInput.sendKeys(password);
        submitButton.click();
    }



    @Override
    public String getUrl() {
        return null;
    }
}
