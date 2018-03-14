package sveikata.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    @FindBy(id = "description")
    private WebElement descriptionOfPrescriptionInput;
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement successMsg;
    @FindBy(css = "label:nth-of-type(2)")
    private WebElement label;

    public void clickOnGenerateListBtn(){
        generatePatientListBtn.click();
    }
    public void clickDownloadListBtn(){
        downloadListBtn.click();
    }
    public void selectToViewFirstPatient(String id){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody > tr"));
        for (WebElement row : rows
             ) {
            if(row.getText().contains(id)){
                WebElement viewBtn = row.findElement(By.cssSelector("td:nth-of-type(4) > a"));
                viewBtn.click();
                break;
            }
        }
    }
    public void clickNewRecordInsidePatient(){
        newRecordBtnInsidePatient.click();
    }
    public void selectIcdCode(String icdCode){
        Select selectCode = new Select(icdCodeDropdown);
        selectCode.selectByVisibleText(icdCode);
    }
    public void fillInRecord(String record){
        descriptionOfVisitInput.sendKeys(record);
        descriptionOfVisitInput.click();
    }
    public void checkCompensatedCheckbox(){
        visitCompensatedCheckbox.click();
    }
    public void checkRepeatVisitCheckbox(){
        repeatVisitCheckbox.click();
    }
    public void inputVisitDuration(String duration){
        visitDuration.sendKeys(duration);
        visitDuration.click();
    }
    public void clickLabel(){
        label.click();
    }
    public void clickNewPrescriptionInsidePatient(){
        newPrescriptionBtnInsidePatient.click();
    }
    public void selectValidityPeriod(String validity){
        Select selectPeriod = new Select(prescriptionValidityPeriod);
        selectPeriod.selectByVisibleText(validity);
    }
    public void selectSubstance(String substance){
        Select selectSubstance = new Select(substanceDropdown);
        selectSubstance.selectByVisibleText(substance);
    }
    public void inputSubtanceAmount(String amount){
        substanceAmount.sendKeys(amount);
    }
    public void inputPrescriptionDescription(String description){
        descriptionOfPrescriptionInput.sendKeys(description);
    }
    public void clickSubmitBtn(){
        submitBtn.click();
    }

    public WebElement getSuccessMsg() {
        return successMsg;
    }

    public WebElement getGeneratePatientListBtn() {
        return generatePatientListBtn;
    }

    public WebElement getDownloadListBtn() {
        return downloadListBtn;
    }

    @Override
    public String getUrl() {
        return null;
    }
}
