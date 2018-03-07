import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;

public class Background {
    LoginFrame loginFrame;
    AccountPage accountPage;

    @BeforeSuite
    public void setUp() {
        Configuration.baseUrl = "https://www.fashionette.de";
        open(Configuration.baseUrl);
    }

    @BeforeTest
    public void setUpTst() {
        System.out.println("Before Test\n");
    }

    @BeforeClass
    public void setUpClss() {
        System.out.println("Before Class\n");
    }

    @BeforeMethod
    public void setUpMthd() {
        System.out.println("Before Method\n");
    }

    @AfterMethod
    public void tearDownMthd() {
        System.out.println("After Method\n");
    }

    @AfterTest
    public void tearDownClss() {
        System.out.println("After Class\n");
    }

    @AfterTest
    public void tearDownTst() {
        System.out.println("After Test\n");

    }
}
