package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;
    @FindBy(id = "user_login")
    private WebElement email;
    @FindBy(id = "user_pass")
    private WebElement pass;
    @FindBy(id = "wp-submit")
    private WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterDetails(String userName, String password){
        email.sendKeys(userName);
        pass.sendKeys(password);
        loginBtn.click();
    }
}
