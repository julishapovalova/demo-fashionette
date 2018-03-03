
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomePageTest {

    HomePage homePage;
    LoginPage loginPage;

//@DataProvider


    @BeforeClass
    public void setUp() {
        Configuration.baseUrl = "https://www.fashionette.de";
        open(Configuration.baseUrl);
    }

    @Test
    public void openPage() {
        homePage = new HomePage();
        loginPage = homePage.header.goToLoginPage();

        String titleOfHomePage = title();
        Assert.assertEquals(titleOfHomePage, "Designer Handtaschen & Accessoires online kaufen - fashionette");
    }

}
