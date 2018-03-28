import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 1000;
        Configuration.baseUrl = "https://www.fashionette.de";
        System.out.println("BeforeSuite" + Thread.currentThread().getId());
    }


    @BeforeMethod(alwaysRun = true)
    public void setUpBeforeMethod() {
        Selenide.open(Configuration.baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownAfterMethod() {
        WebDriverRunner.getWebDriver().quit();
    }


    @AfterClass(alwaysRun = true)
    public void tearDownAfterClass() {
        //     WebDriverRunner.closeWebDriver();
        //    WebDriverRunner.getWebDriver().quit();

    }
}
