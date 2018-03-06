import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomePageTest extends Background {

    HomePage homePage;
    LoginFrame loginFrame;

    @Test
    public void openPage() {
        homePage = new HomePage();
        loginFrame = homePage.header.goToLoginPage();
        String titleOfHomePage = title();
        Assert.assertEquals(titleOfHomePage, "Designer Handtaschen & Accessoires online kaufen - fashionette");
    }

}
