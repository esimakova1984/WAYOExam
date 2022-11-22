package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HelperSearch  extends HelperBase{

     String menuBtn = "//button[@aria-labelledby='hnf-header-hamburger-label']";


    public HelperSearch(WebDriver driver) {
        super(driver);
    }


    public void openMenu() {
        click(By.xpath(menuBtn));
    }

    public void findTables() {

        click(By.xpath("//a[@data-tracking-label='products']"));
        try {
            click(By.xpath("//*[@href='https://www.ikea.com/il/he/cat/furniture-fu001/']"));
        }catch (StaleElementReferenceException ex){
            click(By.xpath("//*[@href='https://www.ikea.com/il/he/cat/furniture-fu001/']"));
        }
        click(By.xpath("//a[@data-tracking-label='fu004']"));
    }

    public void findCoffeeTables() {
        click(By.xpath("//*[@data-tracking-label='products | fu001 | fu004 | 10705']"));
    }

    public void scrollDownPage() {
        WebElement container = driver.findElement(By.xpath("//*[@class='plp-page-container__main']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", container);
    }

    public void findTrulstorpTable() {
        click(By.xpath("//*[@data-ref-id='00400277']"));
    }

    public void selectAColor() {
        click(By.xpath("//*[@class='pip-product-styles__item 'and contains(@aria-label, 'לבן')]"));
    }


    public void openSearchAShop() {
            click(By.xpath("//button[@class='pip-link-button pip-availability-modal-open-button']"));
    }

    public void selectATown(String towm) {
        WebElement container = driver.findElement(By.xpath("//*[@class='pip-modal-body']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", container);
        click(By.xpath("//*[text()='" + towm + "']"));
        click(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        click(By.xpath("//*[@class='pip-btn pip-btn--primary']"));
    }

    public boolean isTheItemAvailable() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@aria-describedby='pip-stockcheck__store-name-info']"))));
        String message = driver.findElement(By.xpath("//*[@aria-describedby='pip-stockcheck__store-name-info']")).getText();
        return message.equals("חנות - מוצר במלאי");
    }
}

