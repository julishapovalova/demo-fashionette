import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        System.out.println("Before Suite" + Thread.currentThread().getId());
        Configuration.browser = "chrome";
        Configuration.timeout = 1000;
        Configuration.baseUrl = "https://www.fashionette.de";
    }

    @BeforeTest
    public void setUpBeforeTest() {
        System.out.println("setUpBeforeTest " + Thread.currentThread().getId());
        Selenide.open(Configuration.baseUrl);

    }

    @BeforeClass
    public void setUpBeforeClass() {
        Selenide.open(Configuration.baseUrl);

    }

    @BeforeMethod
    public void setUpBeforeMethod() {
        Selenide.open(Configuration.baseUrl);
        LoginPage loginPage = new LoginPage();
        loginPage.open();
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }

    @AfterClass
    public void tearDownBeforeClass() {
        Selenide.close();
    }
}
