package sveikata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorWorkStatisticsPage extends WebPage {

    public DoctorWorkStatisticsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "startDate")
    private WebElement startDateInput;
    @FindBy(id = "endDate")
    private WebElement endDateInput;
    @FindBy(id = "showDoctorStatisticButton")
    private WebElement submitBtn;
    @FindBy(css = "div > svg.recharts-surface")
    private WebElement chart;

    public void inputStartDate(String date){
        startDateInput.sendKeys(date);
    }
    public void inputEndDate(String date){
        endDateInput.sendKeys(date);
    }
    public void clickSubmitButton(){
        submitBtn.click();
    }

    public WebElement getChart() {
        return chart;
    }

    @Override
    public String getUrl() {
        return null;
    }
}
