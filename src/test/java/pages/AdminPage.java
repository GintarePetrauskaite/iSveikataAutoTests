package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends WebPage {

    @FindBy(id = "adminCreatePatient")
    private WebElement registerPatientLink;

    @FindBy(id = "adminCreateUser")
    private WebElement registerSystemUserLink;

    @FindBy(id = "adminBind")
    private WebElement assignDoctorToPatientLink;

    @FindBy(css = "a[class='#admin/password']")
    private WebElement changePasswordLink;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }
}
