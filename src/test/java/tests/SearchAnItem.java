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
        app.getHelperSearch().scrollDownThePage();
        app.getHelperSearch().findTrulstorpTable();
        logger.info("'Trulstorp' table is selected");
        app.getHelperSearch().selectAColor();
        logger.info("white color of 'Trulstorp' table is selected");
        app.getHelperSearch().openSearchAShop();
        logger.info("The store is selected");
        app.getHelperSearch().selectATown("אשתאול");
        logger.info("The town is selected");
        if(!app.getHelperSearch().isTheItemNotAvailable()){
            logger.info("Check that item is available in the store");
            app.getHelperSearch().addToMyWishList();
            logger.info("The item was added to my wish list");
        }else{
            logger.info("The item is not available in the store");
        }

        logger.info("Test passed successfully");






    }
}
