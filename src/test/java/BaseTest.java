import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 1000;
        Configuration.baseUrl = "https://www.fashionette.de";
        Configuration.savePageSource = false;
    }


    @BeforeMethod(alwaysRun = true)
    public void setUpBeforeMethod() {
        Selenide.open(Configuration.baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }


    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() {
        WebDriverRunner.getWebDriver().quit();

    }
}
