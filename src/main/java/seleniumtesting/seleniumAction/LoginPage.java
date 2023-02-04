package seleniumtesting.seleniumAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.phptravels.net/login");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).isDisplayed();
    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
        Thread.sleep(5000);
    }

    public void rememberMe(){
        driver.findElement(By.xpath("//label[text()='Remember Me']")).click();
    }
}
