import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        Configuration.baseUrl = "https://www.fashionette.de";
        open(Configuration.baseUrl);
    }

    @AfterMethod
    public void logOut() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }
}
