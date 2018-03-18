import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {


    @Test
    public void openPage() {
        HomePage homePage = new HomePage();

        LoginPage loginPage = homePage.header.goToLoginPage();

        Assert.assertTrue(loginPage.checkedIsOpen("/login"));
    }

}
