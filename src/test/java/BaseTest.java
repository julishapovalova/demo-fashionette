import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 1000;
        Configuration.baseUrl = "https://www.fashionette.de";
    }


    @BeforeMethod
    public void setUpBeforeMethod() {
        Selenide.open(Configuration.baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }

    @AfterClass
    public void tearDownBeforeClass() {
        Selenide.close();
    }
}
