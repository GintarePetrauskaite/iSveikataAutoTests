package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorPage extends WebPage {

    private String URL = "http://localhost:3000/#/gydytojas";
    public DoctorPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "doctorViewPatient")
    private WebElement viewPatientListButton;
    @FindBy(id = "doctorViewStatistic")
    private WebElement viewWorkStatisrics;
    @FindBy(id = "doctorChangePassword")
    private WebElement changePasswordButton;

    public void goToPatientList(){
        viewPatientListButton.click();
    }
    public void goToStatisticsPage(){
        viewWorkStatisrics.click();
    }
    public void goToChangePasswordForm(){
        changePasswordButton.click();
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
