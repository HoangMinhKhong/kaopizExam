package seleniumRun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import seleniumVerify.LoginVerify;
import seleniumtesting.seleniumAction.HomePage;
import seleniumtesting.seleniumAction.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    LoginVerify loginVerify = new LoginVerify(driver);

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

//    thuc hien kiem tra placecholder cua textbox email va password
//    thuc hien login
    @Test
    public void verifyPlaceholderEmaiAndPass() throws InterruptedException {
        loginPage.open();
        loginVerify.verifyPlaceholderEmail();
        loginVerify.verifyPlaceholderPassWord();
    }

//    click vao Remember Me and verify
    @Test
    public void clickRememberMeAndVerify() throws InterruptedException {
        loginPage.rememberMe();
        loginVerify.verifyCheckBoxRememberMe();
    }

//    login and verify home page
    @Test
    public void loginAndVerify() throws InterruptedException {
        loginPage.login("user@phptravels.com", "demouser");
        assertTrue(new HomePage(driver).isLoaded());
    }


    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/src/test/java/driver/chromedriver_mac64");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
