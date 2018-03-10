package pages;

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



    @Override
    public String getUrl() {
        return null;
    }
}
