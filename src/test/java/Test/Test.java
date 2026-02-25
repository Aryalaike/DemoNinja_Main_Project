package Test;

import org.testng.ITestResult;
import org.testng.annotations.*;

import Base.Base;
import Pages.*;

import com.aventstack.extentreports.*;

public class Test extends Base {

    ExtentTest test;


    @org.testng.annotations.Test(priority = 0)
    public void registerTest() throws InterruptedException {

        test = extent.createTest("Register Test");

        Home h = new Home(driver);
        h.clickMyAccount();
        h.clickRegister();

        Register r = new Register(driver);
        r.enterDetails();
        r.clickPolicy();
        r.clickContinue();

        Thread.sleep(2000);
    }


    @org.testng.annotations.Test(priority = 1)
    public void wishlistTest() throws InterruptedException {

        test = extent.createTest("Wishlist Test");

        Home h = new Home(driver);
        h.searchProduct("Samsung Galaxy Tab 10.1");

        Product p = new Product(driver);
        p.selectSamsung();

        Thread.sleep(2000);
        p.addToWishlist();
        Thread.sleep(2000);
    }


    @org.testng.annotations.Test(priority = 2)
    public void checkoutTest() throws InterruptedException {

        test = extent.createTest("Checkout Test");

        Home h = new Home(driver);
        h.searchProduct("MacBook");

        Product p = new Product(driver);
        p.macbook();

        Thread.sleep(2000);
        p.addToCart();
        Thread.sleep(2000);

        Cart c = new Cart(driver);
        c.openCart();
        c.clickCheckout();

        Thread.sleep(2000);

        Checkout co = new Checkout(driver);
        co.continueBilling();
        co.acceptTerms();
        co.confirmOrder();

        Thread.sleep(3000);

        c.Continue_Shopping();
    }


    @org.testng.annotations.Test(priority = 3)
    public void contactTest() {

        test = extent.createTest("Contact Test");

        Contact c = new Contact(driver);

        c.openContact();

        c.enterDetails(
                "Arya",
                "arya@mail.com",
                "Palakkunnel"
        );

        c.clickSubmit();
    }


    @org.testng.annotations.Test(priority = 4)
    public void logout() {

        test = extent.createTest("Logout Test");

        Home h = new Home(driver);
        h.logout();
    }


    @org.testng.annotations.Test(priority = 5)
    public void loginTest() {

        test = extent.createTest("Login Test");

        Home h = new Home(driver);

        h.clickMyAccount();
        h.clickLogin();

        Login l = new Login(driver);
        l.login("arya@mail.com", "12345");
    }


    @AfterMethod
    public void getResult(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {

            test.log(Status.PASS, "Test Passed: " + result.getName());
        }
        else {

            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }
    }

}