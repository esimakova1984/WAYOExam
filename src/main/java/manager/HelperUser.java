package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperUser extends HelperBase {
    public HelperUser(WebDriver driver) {
        super(driver);
    }


    public void openARegistrationForm() {
        click(By.xpath("//*[@class='hnf-header__profile-link ']"));
        click(By.xpath("//*[contains(text(),'יצירת חשבון')]"));
    }

    public void fillTheRegistrationForm(User user) {
        type(By.xpath("//*[@name='firstName']"), user.getName());
        type(By.xpath("//*[@name='lastName']"), user.getLastName());
        type(By.xpath("//*[@name='username']"), user.getEmail());
        type(By.xpath("//*[@name='password']"), user.getPassword());
    }

    public void submitRegistrationForm() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='יצירת פרופיל']"))));
        click(By.xpath("//*[text()='יצירת פרופיל']"));
    }

    public void checkBoxPolicy() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='regular-signup-form-acceptPrivacyPolicy']"))));
        click(By.xpath("//*[@id='regular-signup-form-acceptPrivacyPolicy']"));
    }

    public void scrollDownTheForm() {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,450)","");

    }

    public String checkMessage() {

        return driver.findElement(By.xpath("//h1")).getText();
    }

}
