
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class HomePageTest {
    @Test
    public void openPage(){

        open("https://www.fashionette.de/");
        HomePage homePage=new HomePage();
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        String titleOfHomePage=title();
        Assert.assertEquals(titleOfHomePage,"Designer Handtaschen & Accessoires online kaufen - fashionette");
    }

}
