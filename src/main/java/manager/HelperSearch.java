package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HelperSearch  extends HelperBase{

     String menuBtn = "//button[@aria-labelledby='hnf-header-hamburger-label']";
     String products = "//a[@data-tracking-label='products']";
     String homeFurniture = "//*[@href='https://www.ikea.com/il/he/cat/furniture-fu001/']";
     String tables = "//a[@data-tracking-label='fu004']";
     String coffeeTables = "//*[@data-tracking-label='products | fu001 | fu004 | 10705']";
     String containerPage = "//*[@class='plp-page-container__main']";
     String trulstorpTable = "//*[@data-ref-id='00400277']";
     String whiteColor ="//*[@class='pip-product-styles__item ']";
     String selectStoreBtn = "//button[@class='pip-link-button pip-availability-modal-open-button']";
     String modalBody = "//*[@class='pip-modal-body']";
     String handlerBtn = "//button[@id='onetrust-accept-btn-handler']";
     String submitTownBtn = "//*[@class='pip-btn pip-btn--primary']";
     String storeNameInfo = "//*[@aria-describedby='pip-stockcheck__store-name-info']";


    public HelperSearch(WebDriver driver) {
        super(driver);
    }


    public void openMenu() {
        click(By.xpath(menuBtn));
    }

    public void findTables() {

        click(By.xpath(products));
        try {
            click(By.xpath(homeFurniture));
        }catch (StaleElementReferenceException ex){
            click(By.xpath(homeFurniture));
        }
        click(By.xpath(tables));
    }

    public void findCoffeeTables() {
        click(By.xpath(coffeeTables));
    }

    public void scrollDownPage() {
        WebElement container = driver.findElement(By.xpath(containerPage));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", container);
    }

    public void findTrulstorpTable() {
        click(By.xpath(trulstorpTable));
    }

    public void selectColor() {
        click(By.xpath(whiteColor));
    }


    public void openSearchStore() {
            click(By.xpath(selectStoreBtn));
    }

    public void selectTown(String town) {
        WebElement container = driver.findElement(By.xpath(modalBody));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", container);
        click(By.xpath("//*[text()='" + town + "']"));
        click(By.xpath(handlerBtn));
        click(By.xpath(submitTownBtn));
    }

    public boolean isItemAvailable() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(storeNameInfo))));
        String message = driver.findElement(By.xpath(storeNameInfo)).getText();
        return message.equals("חנות - מוצר במלאי");
    }
}

