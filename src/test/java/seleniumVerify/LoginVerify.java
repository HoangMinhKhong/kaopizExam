package seleniumVerify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import seleniumtesting.seleniumAction.BasePage;
import seleniumtesting.seleniumAction.LoginPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginVerify extends BasePage {

    public LoginVerify(WebDriver driver) {
        super(driver);
    }

    //    Hàm verify placeholder của email
    public void verifyPlaceholderEmail() throws InterruptedException {
        Thread.sleep(5000);
        String placeholderEmail = driver.findElement(By.name("email")).getAttribute("placeholder");
        assertEquals(placeholderEmail, "Email");
    }

    //    Hàm verify placeholder của password
    public void verifyPlaceholderPassWord() throws InterruptedException {
        Thread.sleep(5000);
        String placeholderEmail = driver.findElement(By.name("password")).getAttribute("placeholder");
        assertEquals(placeholderEmail, "Password");
    }

    //    Ham verify checkbox remember me
    public void verifyCheckBoxRememberMe() throws InterruptedException {
        Thread.sleep(5000);
        assertTrue(driver.findElement(By.xpath("//label[text()='Remember Me']")).isSelected());
    }
}
