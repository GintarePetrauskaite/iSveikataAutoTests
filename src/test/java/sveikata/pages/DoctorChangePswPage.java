package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorChangePswPage extends WebPage {

    public DoctorChangePswPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "oldPassword")
    private WebElement oldPasswordInput;
    @FindBy(id = "newPassword")
    private WebElement newPasswordInput;
    @FindBy(id = "newPasswordRepeat")
    private WebElement newPasswordRepeatInput;
    @FindBy(id = "pasFormNSubmit")
    private WebElement submitBtn;

    @Override
    public String getUrl() {
        return null;
    }
}
