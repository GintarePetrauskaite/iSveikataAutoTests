package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {

    private static String URL = "http://localhost:3000/#";

    @FindBy(id = "loginPatient")
    private WebElement loginForPatientsLink;

    @FindBy(id = "loginUsers")
    private WebElement loginForSystemUsersLink;

    @FindBy(id = "publicStatistic")
    private WebElement publicStatisticsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void goToLoginForPatients(){
        loginForPatientsLink.click();
    }

    public void goToLoginForSystemUsers(){
        loginForSystemUsersLink.click();
    }

    @Override
    public String getUrl() {
        return URL;
    }
}
