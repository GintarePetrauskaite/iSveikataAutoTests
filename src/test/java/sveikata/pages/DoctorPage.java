package sveikata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorPage extends WebPage {

    private String URL = "http://localhost:8080/#/gydytojas";
    public DoctorPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "doctorViewPatient")
    private WebElement viewPatientListButton;
    @FindBy(id = "doctorPatient")
    private WebElement patientsLink;
    @FindBy(id = "doctorViewStatistic")
    private WebElement viewWorkStatistics;
    @FindBy(id = "doctorChangePassword")
    private WebElement changePasswordButton;

    public void goToPatientList(){
        patientsLink.click();
    }
    public void goToStatisticsPage(){
        viewWorkStatistics.click();
    }
    public void goToChangePasswordForm(){
        changePasswordButton.click();
    }

    public WebElement getViewPatientListButton() {
        return viewPatientListButton;
    }

    public WebElement getViewWorkStatistics() {
        return viewWorkStatistics;
    }

    public WebElement getChangePasswordButton() {
        return changePasswordButton;
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
