package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientPage extends WebPage {


    public PatientPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li[navbar-text] > h4")
    private WebElement loggedInPatientNameText;

    public WebElement getLoggedInPatientNameText(){
        return loggedInPatientNameText;
    }

    @Override
    public String getUrl() {
        return null;
    }
}
