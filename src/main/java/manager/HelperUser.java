package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperUser extends HelperBase {

    String profileLink = "//*[@class='hnf-header__profile-link ']";
    String signupBtn = "//*[contains(@class,'login-internal-signup-btn-desktop')]";
    String firstName = "//*[@name='firstName']";
    String lastName = "//*[@name='lastName']";
    String email = "//*[@name='username']";
    String password = "//*[@name='password']";
    String spacing = "//*[@class='profile__ikea-col-xl-2 profile__ikea-col-sm-1 profile__col-no-v-spacing']";
    String checkBoxPolicy = "//*[@for='regular-signup-form-acceptPrivacyPolicy']";
    String submitRegistrationForm = "//*[@class='profile__btn__inner profile__btn__inner--primary']";
    String greetingMessage = "//h1";
    String userName = "//*[@id='tab-panel-account']//div[1]/div[2]/span";
    String userEmail = "//*[@id='tab-panel-account']//div[2]/div[2]/span";

    public HelperUser(WebDriver driver) {
        super(driver);
    }


    public void openRegistrationForm() {
        click(By.xpath(profileLink));
        click(By.xpath(signupBtn));
    }

    public void fillRegistrationForm(User user) {
        type(By.xpath(firstName), user.getName());
        type(By.xpath(lastName), user.getLastName());
        type(By.xpath(email), user.getEmail());
        type(By.xpath(password), user.getPassword());
        click(By.xpath(spacing));
    }

    public void submitRegistrationForm() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(submitRegistrationForm))));
        click(By.xpath(submitRegistrationForm));
    }

    public void checkBoxPolicy() {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(checkBoxPolicy)))).click();
    }

    public void scrollDownForm() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)", "");
    }

    public String checkMessage() {
        return driver.findElement(By.xpath(greetingMessage)).getText();
    }

    public String verifyUserName() {
        return driver.findElement(By.xpath(userName)).getText();

    }

    public String verifyUserEmail() {
        return driver.findElement(By.xpath(userEmail)).getText();

    }
}
