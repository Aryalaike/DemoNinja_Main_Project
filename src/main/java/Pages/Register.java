package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

    public WebDriver driver;

    @FindBy(id="input-firstname")
    WebElement FirstName;

    @FindBy(id="input-lastname")
    WebElement LastName;

    @FindBy(id="input-email")
    WebElement Email;

    @FindBy(id="input-telephone")
    WebElement Telephone;

    @FindBy(id="input-password")
    WebElement Password;

    @FindBy(id="input-confirm")
    WebElement ConfirmPassword;

    @FindBy(name="agree")
    WebElement PrivacyPolicy;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement ContinueBtn;

    public Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterDetails() {
        FirstName.sendKeys("Arya");
        LastName.sendKeys("Lekshmi");
        Email.sendKeys("arya" + System.currentTimeMillis() + "@gmail.com");
        Telephone.sendKeys("9999999999");
        Password.sendKeys("Arya123");
        ConfirmPassword.sendKeys("Arya123");
    }

    public void clickPolicy() {
        PrivacyPolicy.click();
    }

    public void clickContinue() {
        ContinueBtn.click();
    }
}
