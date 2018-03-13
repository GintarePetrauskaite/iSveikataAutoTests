package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.color.ICC_ColorSpace;

public class DoctorPatientListPage extends WebPage {

    public DoctorPatientListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "div.navbar-text > button")
    private WebElement generatePatientListBtn;
    @FindBy(css = "a[download]")
    private WebElement downloadListBtn;
    @FindBy(id = "searchFormInput")
    private WebElement searchInput;
    @FindBy(id = "searchFormSubmit")
    private WebElement searchBtn;
    @FindBy(id = "doctorResetPatientList")
    private WebElement resetListBtn;
    @FindBy(id = "doctorChangePatientList")
    private WebElement seeAllOrAssignedPatientsBtn;
    @FindBy(id = "newRecordundefined")
    private WebElement newRecordBtnInsidePatient;
    @FindBy(id = "newPrescriptionundefined")
    private WebElement newPrescriptionBtnInsidePatient;
    @FindBy(css = "div.navbar-text > button[class='btn btn-default']")
    private WebElement backButton;
    @FindBy(id = "icdCode")
    private WebElement icdCodeDropdown;
    @FindBy(id = "description")
    private WebElement descriptionOfVisitInput;
    @FindBy(id = "CheckIfCompensable")
    private WebElement visitCompensatedCheckbox;
    @FindBy(id = "CheckIfRepetitive")
    private WebElement repeatVisitCheckbox;
    @FindBy(id = "duration")
    private WebElement visitDuration;
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;
    @FindBy(id = "daysToExpiration")
    private WebElement prescriptionValidityPeriod;
    @FindBy(id = "substance")
    private WebElement substanceDropdown;
    @FindBy(id = "substanceAmount")
    private WebElement substanceAmount;


    @Override
    public String getUrl() {
        return null;
    }
}
