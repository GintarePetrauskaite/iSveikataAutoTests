package sveikata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForPatientPage extends WebPage {

    private String URL = "http://localhost:8080/#/";
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
    public void fillInPatientId(String id){
        patientIdInput.sendKeys(id);
    }
    public void fillInPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void ClickSubmit(){
        submitButton.click();
    }
    public WebElement getErrorMsg(){
        return errorMsg;
    }

    public void login(String id, String password){
        patientIdInput.sendKeys(id);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
