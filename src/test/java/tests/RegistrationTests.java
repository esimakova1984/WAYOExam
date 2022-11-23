package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    int index = ((int) System.currentTimeMillis()/1000)%360;
    User user = User.builder()
            .name("Rima")
            .lastName("Sima")
            .email("esimakova" + index + "@gmail.com")
            .password("Fimasima1234!")
            .build();

    @Test
    public void registrationSuccess(){
        logger.info("The test starts positive registration");
        app.getHelperUser().openRegistrationForm();
        logger.info("The registration form is opened");
        app.getHelperUser().fillRegistrationForm(user);
        logger.info("The registration form is filled with data: " + user);
        app.getHelperUser().scrollDownForm();
        logger.info("The page is scrolled");
        app.getHelperUser().checkBoxPolicy();
        logger.info("The checkbox of Policy is necessary");
        app.getHelperUser().submitRegistrationForm();
        Assert.assertEquals(app.getHelperUser().checkMessage(), "שלום " + user.getName()+ " !");
        logger.info("Greeting with user name is verified");
        Assert.assertEquals(app.getHelperUser().verifyUserName(), user.getName() + " " + user.getLastName());
        logger.info("User name and lastname are verified");
        Assert.assertEquals(app.getHelperUser().verifyUserEmail(), user.getEmail());
        logger.info("User email is verified");
        logger.info("Test passed successfully");
    }
}
