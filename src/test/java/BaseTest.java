import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Configuration.baseUrl = "https://www.fashionette.de";
        open(Configuration.baseUrl);
    }

    @BeforeGroups(groups = "validationError")
    @BeforeClass()
    public void setUpBeforeClass() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
    }

    @AfterMethod(dependsOnGroups = "validationError")
    public void tearDown() {
        Selenide.refresh();
    }

    @AfterMethod
    public void logOut() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }
}
