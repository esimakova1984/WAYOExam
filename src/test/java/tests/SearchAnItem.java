package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchAnItem extends TestBase{

    @Test
    public void searchTrulstorpTable(){
        logger.info("The test starts search 'Trulstorp' table");
        app.getHelperSearch().openMenu();
        logger.info("Menu is opened");
        app.getHelperSearch().findTables();
        logger.info("Tables from menu is selected");
        app.getHelperSearch().findCoffeeTables();
        logger.info("Coffee tables from the list of tables are selected");
        app.getHelperSearch().scrollDownPage();
        app.getHelperSearch().findTrulstorpTable();
        logger.info("'Trulstorp' table is selected");
        app.getHelperSearch().selectAColor();
        logger.info("white color of 'Trulstorp' table is selected");
        app.getHelperSearch().openSearchAShop();
        logger.info("The store is selected");
        app.getHelperSearch().selectATown("נתניה");
        logger.info("The town is selected");
        Assert.assertTrue(app.getHelperSearch().isTheItemAvailable());
        logger.info("Check that item is available in the store");
        logger.info("Test passed successfully");
    }
}
