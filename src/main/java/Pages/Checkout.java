package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Checkout {

    public WebDriver driver;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement ContinueBilling;

    @FindBy(name="agree")
    WebElement Terms;

    @FindBy(xpath="//input[@value='Confirm Order']")
    WebElement ConfirmOrder;

    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void continueBilling() {
        ContinueBilling.click();
    }

    public void acceptTerms() {
        Terms.click();
    }

    public void confirmOrder() {
        ConfirmOrder.click();
    }

    // Assertion
    public void verifyCheckoutVisible() {
        Assert.assertTrue(ContinueBilling.isDisplayed(), "Checkout is visible");
    }
}