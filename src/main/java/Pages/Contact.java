
package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {

    public WebDriver driver;

    @FindBy(linkText = "Contact Us")
    WebElement contactLink;

    @FindBy(id = "input-name")
    WebElement name;

    @FindBy(id = "input-email")
    WebElement email;

    @FindBy(id = "input-enquiry")
    WebElement enquiry;

    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//p[contains(text(),'Your enquiry has been successfully sent')]")
    WebElement successMsg;

    public Contact(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openContact() {
        contactLink.click();
    }

    public void enterDetails(String uname, String uemail, String msg) {
        name.clear();
        name.sendKeys(uname);

        email.clear();
        email.sendKeys(uemail);

        enquiry.clear();
        enquiry.sendKeys(msg);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public String getSuccessMessage() {
        return successMsg.getText();
    }
}
