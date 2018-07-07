package testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import utilities.BaseSetup;
/**
 * Test to login on word press website
 * */
public class LoginTest extends BaseSetup {
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver =getDriver();
    }

    @Parameters({"userName","password"})
    @Test
    public void login(String userName, String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterDetails(userName, password);
    }
}
