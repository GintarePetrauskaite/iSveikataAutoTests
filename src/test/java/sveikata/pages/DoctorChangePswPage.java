package sveikata.pages;

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
    @FindBy(css = "div[class='alert alert-success']")
    private WebElement successMsg;

    public void inputOldPassword(String oldPassword){
        oldPasswordInput.sendKeys(oldPassword);
        oldPasswordInput.click();
    }
    public void inputNewPassword(String newPassword){
        newPasswordInput.sendKeys(newPassword);
        newPasswordInput.click();
    }
    public void inputRepeatNewPassword(String repeatNewPassword){
        newPasswordRepeatInput.sendKeys(repeatNewPassword);
        newPasswordRepeatInput.click();
    }
    public void clickSubmitBtn(){
        submitBtn.click();
    }

    public WebElement getSuccessMsg() {
        return successMsg;
    }

    @Override
    public String getUrl() {
        return null;
    }
}
