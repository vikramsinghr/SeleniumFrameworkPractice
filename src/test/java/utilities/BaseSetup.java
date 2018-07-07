package utilities;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetup {
    private static WebDriver driver;

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching chrome browser..");
        System.setProperty("webdriver.chrome.driver", Constants.chromePath + "chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Driver session ID :" + ((ChromeDriver) driver).getSessionId());
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching firefox driver..");
        //TODO
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(String browserName, String appURL) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("Browser not found");
        }
    }

    @Parameters({"browserName", "appURL"})
    @BeforeClass
    public void initializeBaseSetup(String browserName, String appURL) {
        try {
            setDriver(browserName, appURL);
        } catch (Exception ex) {
            System.out.println("Exception :" + ex.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
