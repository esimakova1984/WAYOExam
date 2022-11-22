package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationSuccess(){
        logger.info("The test starts positive registration");
        int index = ((int) System.currentTimeMillis()/1000)%360;
        User user = User.builder()
                .name("Rima")
                .lastName("Sima")
                .email("esimakova" + index + "@gmail.com")
                .password("Fimasima1234!")
                .build();

        app.getHelperUser().openARegistrationForm();
        logger.info("The registration form is opened");
        app.getHelperUser().fillTheRegistrationForm(user);
        logger.info("The registration form is filled with data: " + user);
        app.getHelperUser().scrollDownTheForm();
        logger.info("The page is scrolled");
        app.getHelperUser().checkBoxPolicy();
        logger.info("The checkbox of Policy is necessary");
        app.getHelperUser().submitRegistrationForm();
        Assert.assertEquals(app.getHelperUser().checkMessage(), "שלום " + user.getName()+ " !");
        logger.info("Test passed successfully");
    }
}
