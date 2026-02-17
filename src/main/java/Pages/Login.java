package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    WebElement accountText;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String userEmail, String userPassword) {
        email.clear();
        email.sendKeys(userEmail);

        password.clear();
        password.sendKeys(userPassword);

        loginBtn.click();
    }

    public String getAccountText() {
        return accountText.getText();
    }
}
