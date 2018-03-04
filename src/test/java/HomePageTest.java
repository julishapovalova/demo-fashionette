import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomePageTest extends Background {

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void openPage() {
        homePage = new HomePage();
        loginPage = homePage.header.goToLoginPage();
        String titleOfHomePage = title();
        Assert.assertEquals(titleOfHomePage, "Designer Handtaschen & Accessoires online kaufen - fashionette");
    }

}
