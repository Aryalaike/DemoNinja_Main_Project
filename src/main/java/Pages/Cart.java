package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Cart {

    public WebDriver driver;

    @FindBy(xpath="//span[@id='cart-total']")
    WebElement CartButton;

    @FindBy(xpath="//strong[text()='View Cart']")
    WebElement ViewCart;

    @FindBy(xpath="//a[text()='Checkout']")
    WebElement Checkout;

    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueShopping;

    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        CartButton.click();
        ViewCart.click();
    }

    public void clickCheckout() {
        Checkout.click();
    }

    public void Continue_Shopping() {
        continueShopping.click();
    }

    // Assertion
    public void verifyCartOpened() {
        Assert.assertTrue(CartButton.isDisplayed(), "Cart is visible");
    }
}