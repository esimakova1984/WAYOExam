package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    HelperUser helperUser;
    HelperSearch helperSearch;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() {
        driver = new ChromeDriver();
        logger.info("All tests start with Chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.ikea.com/il/he/");
        helperUser = new HelperUser(driver);
        helperSearch = new HelperSearch(driver);
    }

    public void stop() {
        driver.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperSearch getHelperSearch() {
        return helperSearch;
    }
}
