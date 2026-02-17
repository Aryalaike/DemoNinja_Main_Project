package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Samsung Galaxy Tab 10.1']")
    WebElement samsungProduct;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    WebElement wishlistBtn;

    @FindBy(id = "button-cart")
    WebElement addToCart;
    @FindBy(xpath = "//a[text()='iPhone']")
    WebElement iphone;

    @FindBy(xpath = "//a[text()='MacBook']")
    WebElement macbook;
    public Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        samsungProduct.click();
    }

    public void addToWishlist() {
        wishlistBtn.click();
    }

    public void addToCart() {
        addToCart.click();
    }
    public void selectIphone() {
        iphone.click();
    }

    public void selectSamsung() {
        samsungProduct.click();
    }
    public void macbook() {
    	macbook.click();
}}
