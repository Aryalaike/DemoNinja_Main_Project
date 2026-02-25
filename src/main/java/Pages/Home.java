package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home {

    WebDriver driver;

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement register;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement login;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;

    @FindBy(name = "search")
    WebElement searchBox;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchBtn;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMyAccount() {
        myAccount.click();
    }

    public void clickRegister() {
        register.click();
    }

    public void clickLogin() {
        login.click();
    }

    public void logout() {
        myAccount.click();
        logout.click();
    }

    public void searchProduct(String product) {
        searchBox.clear();
        searchBox.sendKeys(product);
        searchBtn.click();
    }

    // Assertion
    public void verifyLoginVisible() {
        Assert.assertTrue(login.isDisplayed(), "Login link is visible");
    }
}