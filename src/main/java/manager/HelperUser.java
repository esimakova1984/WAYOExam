package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperUser extends HelperBase {
    public HelperUser(WebDriver driver) {
        super(driver);
    }


    public void openARegistrationForm() {
        click(By.xpath("//*[@class='hnf-header__profile-link ']"));
        click(By.xpath("//*[contains(@class,'login-internal-signup-btn-desktop')]"));
    }

    public void fillTheRegistrationForm(User user) {
        type(By.xpath("//*[@name='firstName']"), user.getName());
        type(By.xpath("//*[@name='lastName']"), user.getLastName());
        type(By.xpath("//*[@name='username']"), user.getEmail());
        type(By.xpath("//*[@name='password']"), user.getPassword());
        click(By.xpath("//*[@class='profile__ikea-col-xl-2 profile__ikea-col-sm-1 profile__col-no-v-spacing']"));
    }

    public void submitRegistrationForm() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='profile__btn__inner profile__btn__inner--primary']"))));
        click(By.xpath("//*[@class='profile__btn__inner profile__btn__inner--primary']"));
    }

    public void checkBoxPolicy() {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath("//*[@for='regular-signup-form-acceptPrivacyPolicy']")))).click();
    }

    public void scrollDownTheForm() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)","");
    }

    public String checkMessage() {
        return driver.findElement(By.xpath("//h1")).getText();
    }

}
