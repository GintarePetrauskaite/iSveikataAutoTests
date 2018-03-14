package sveikata.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminAssignDoctorToPatientPage extends WebPage {

    private String URL = "http://localhost:8080/#/admin/bind";
    @FindBy(id = "searchFormInput")
    private WebElement searchInput;
    @FindBy(id = "searchFormSubmit")
    private WebElement searchSubmitBtn;

    public void selectFirstDoctorFromList(String lastName){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody > tr"));
        for (WebElement row:rows
             ) {
            if(row.getText().contains(lastName)){
                WebElement button = row.findElement(By.cssSelector("td:nth-of-type(4) > a"));
                button.click();
                break;
            }
        }
    }
    public void selectFirstPatientFromList(String id){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody > tr:nth-of-type(1)"));
        for (WebElement row:rows
             ) {
            if(row.getText().contains(id)){
                WebElement button = row.findElement(By.cssSelector("td:nth-of-type(4) > p"));
                button.click();
                break;
            }
        }
    }

    public AdminAssignDoctorToPatientPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }
}
